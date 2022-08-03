package web.schedule.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.schedule.servlice.ScheduleService;
import web.schedule.servlice.impl.ScheduleServiceImpl;
import web.schedule.vo.ResultSchedule;
import web.schedule.vo.Schedule;
import web.staff.vo.Staff;

@WebServlet("/api/0.01/schedule/*")
public class ScheduleServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private ScheduleService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			service = new ScheduleServiceImpl();
			List<ResultSchedule> schedules = service.getAll();
			if (schedules != null) {
				respObject.addProperty("msg", "success");
				respObject.add("schedules", gson.toJsonTree(schedules));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}
	
	//取員工id
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		try {
			ScheduleService service = new ScheduleServiceImpl();
			staff = service.staffData(staff);

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(staff));
	}
	
	//新增，修改
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		Schedule schedule = gson.fromJson(req.getReader(), Schedule.class);
		try {
			ScheduleService service = new ScheduleServiceImpl();
			String msg = service.addOrModify(schedule);
			respObject.addProperty("msg", msg);
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
