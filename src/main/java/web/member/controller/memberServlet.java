package web.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import model.hibernate.HibernateUtil;
import web.member.dao.impl.MemberDaoHibernate;
import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;
import web.member.vo.Member;

@WebServlet("/api/0.01/member/*")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
	private MemberService service;
	private HttpSession session;

	@Override
	public void init() throws ServletException {
		service = new MemberServiceImpl(new MemberDaoHibernate(HibernateUtil.getSessionFactory()));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(req, resp);
		JsonObject respObject = new JsonObject();
		try {
			pathInfo = req.getPathInfo();
			infos = pathInfo.split("/");
			if (infos.length != 0) {
				System.out.println("Param: " + infos[1]);
				if ("verify".equals(infos[1])) {
					String code = req.getParameter("code");
					String memID = req.getParameter("memID");
					Member member = new Member();
					member.setMemID(memID);
					if (service.emailVerification(code, member)) {
						respObject.addProperty("msg", "verification pass!");
					} else {
						respObject.addProperty("msg", "verification fail");
					}
				} else {
					Member member = service.getOneByID(infos[1]);
					if (session == null || session.getAttribute("account") == null) {
						respObject.addProperty("msg", "not login");
					} else if (member != null && (member.getMemID().equals((String) session.getAttribute("account")))) {
						respObject.addProperty("msg", "success");
						respObject.add("member", gson.toJsonTree(member));
					} else {
						respObject.addProperty("msg", "fail");
					}
				}
			} else {
				List<Member> members = service.getAll();
				if (members != null) {
					respObject.addProperty("msg", "success");
					respObject.add("members", gson.toJsonTree(members));
				} else {
					respObject.addProperty("msg", "fail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(req, resp);
		JsonObject respObject = new JsonObject();
		Member member = gson.fromJson(req.getReader(), Member.class);
		System.out.println(member);
		try {
			pathInfo = req.getPathInfo();
			infos = pathInfo.split("/");
			if ("register".equals(infos[1])) {
				Integer status = service.register(member);
				if (status > 0) {
					respObject.addProperty("msg", "success");
					session = req.getSession();
					session.setAttribute("account", member.getMemID());
				} else {
					respObject.addProperty("msg", "fail");
				}
			} else if ("login".equals(infos[1])) {
				member = service.login(member);
				if (member != null) {
					respObject.addProperty("msg", "success");
					session = req.getSession();
					session.setAttribute("account", member.getMemID());
					// Referenced from
					// https://stackoverflow.com/questions/22585970/how-to-add-an-object-as-a-property-of-a-jsonobject-object
					respObject.add("member", gson.toJsonTree(member));
				} else {
					respObject.addProperty("msg", "fail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(req, resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Member member = gson.fromJson(req.getReader(), Member.class);
		if ("remove".equals(infos[1])) {
			try {
				Integer status = service.remove(member);
				if (status > 0) {
					respObject.addProperty("msg", "success");
				} else {
					respObject.addProperty("msg", "fail");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.getWriter().append(gson.toJson(respObject));
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("getCharacterEncoding: "+req.getCharacterEncoding());
		setHeaders(req, resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Member member = gson.fromJson(req.getReader(), Member.class);
		System.out.println(member);
		if ("modify".equals(infos[1])) {
			try {
				if (service.modify(member) > 0) {
					respObject.addProperty("msg", "success");
				} else {
					respObject.addProperty("msg", "fail");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(gson.toJson(respObject));
			resp.getWriter().append(gson.toJson(respObject));
		}
	}

	/*
	 * 誇域
	 */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(req, resp);
	}

	private void setHeaders(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		// 重要
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		// 重要
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}
}