package web.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.order.service.OrderService;
import web.order.service.OrderServiceImpl;
import web.order.vo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/api/0.01/order/*")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			OrderService service = new OrderServiceImpl();
			List<Order> orders = service.searchOrders();
			if (orders != null) {
				respObject.addProperty("msg", "success");
				respObject.add("orders", gson.toJsonTree(orders));
			}
		} catch (Exception e) {
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
