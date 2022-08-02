package web.staff.servlet;

import java.io.IOException;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			StaffService service = new StaffServiceImpl();
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


//登入
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		System.out.println(gson.toJson(staff));
		try {
			StaffService service = new StaffServiceImpl();
			Staff rsStaff = service.login(staff);

			if (rsStaff != null) {
				resp.getWriter().append(gson.toJson(rsStaff));
			} else {
				resp.getWriter().append(gson.toJson("false"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

//刪除
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		try {
			StaffService service = new StaffServiceImpl();
			Integer status = service.remove(staff);
			if (status > 0) {
				respObject.addProperty("msg", "success");
			} else {
				respObject.addProperty("msg", "fail");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

//新增，修改
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		System.out.println(gson.toJson(staff));
		try {
			StaffService service = new StaffServiceImpl();
			Integer status = service.addOrModify(staff);
			if(StringUtils.isBlank(staff.getStaff_id())) {
				respObject.addProperty("type", "insert");
			} else {
				respObject.addProperty("type", "update");
			}
			if (status > 0) {
				respObject.addProperty("msg", "success");
			} else {
				respObject.addProperty("msg", "fail");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));

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
