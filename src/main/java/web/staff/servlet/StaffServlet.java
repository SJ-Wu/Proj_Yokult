package web.staff.servlet;

import java.io.IOException;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.staff.service.StaffService;
import web.staff.service.impl.StaffServiceImpl;
import web.staff.vo.Staff;

@WebServlet("/api/0.01/staff/*")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
	private StaffService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			service = new StaffServiceImpl();
			Set<Staff> staffs = service.getAll();
			if (staffs != null) {
				respObject.addProperty("msg", "success");
				respObject.add("staffs", gson.toJsonTree(staffs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);

		JsonObject respObject = new JsonObject();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		try {
			service = new StaffServiceImpl();
			pathInfo = req.getPathInfo();
			infos = pathInfo.split("/");
			if ("register".equals(infos[1])) {
				Integer status = service.register(staff);
				if (status > 0) {
					respObject.addProperty("msg", "success");
				} else {
					respObject.addProperty("msg", "fail");
				}
			} else if ("login".equals(infos[1])) {
				staff = service.login(staff);
				if (staff != null) {
					respObject.addProperty("msg", "success");
					// Referenced from
					// https://stackoverflow.com/questions/22585970/how-to-add-an-object-as-a-property-of-a-jsonobject-object
					respObject.add("staff", new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJsonTree(staff));
				} else {
					respObject.addProperty("msg", "fail");
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		if ("remove".equals(infos[1])) {
			try {
				StaffService service = new StaffServiceImpl();
				Integer status = service.remove(staff);
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
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		if ("modify".equals(infos[1])) {
			try {
				StaffService service = new StaffServiceImpl();
				if (service.modify(staff) > 0) {
					respObject.addProperty("msg", "success");
				} else {
					respObject.addProperty("msg", "fail");
				}
			} catch (NamingException e) {
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
		setHeaders(resp);
	}

	private void setHeaders(HttpServletResponse response) {
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
