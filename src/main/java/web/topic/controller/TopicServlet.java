package web.topic.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;
import web.member.vo.Member;
import web.topic.service.TopicService;
import web.topic.service.impl.TopicServiceImpl;
import web.topic.vo.Topic;

@WebServlet("/api/0.01/topic/*")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
	private TopicService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			service = new TopicServiceImpl();
			List<Topic> topics = service.selectAll();
			if (topics != null) {
				respObject.addProperty("msg", "success");
				respObject.add("topics", gson.toJsonTree(topics));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);

		JsonObject respObject = new JsonObject();
		Topic topic = gson.fromJson(req.getReader(), Topic.class);
		try {
			service = new TopicServiceImpl();
			pathInfo = req.getPathInfo();
			infos = pathInfo.split("/");
			if ("update".equals(infos[1])) {
				Integer status = service.update(topic);
				if (status > 0) {
					respObject.addProperty("msg", "success");
				} else {
					respObject.addProperty("msg", "fail");
				}
		
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));

	}
	
/*修改*/
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Topic topic = gson.fromJson(req.getReader(), Topic.class);
		if ("modify".equals(infos[1])) {
			try {
				TopicService service = new TopicServiceImpl();
				if (service.modify(topic) > 0) {
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
	
	

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		JsonObject respObject = new JsonObject();
		Topic topic = gson.fromJson(req.getReader(), Topic.class);
		if ("remove".equals(infos[1])) {
			try {
				TopicService service = new TopicServiceImpl();
				Integer status = service.remove(topic);
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
