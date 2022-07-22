package web.product.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;
import web.member.vo.Member;
import web.product.service.ProductService;
import web.product.service.impl.ProductServiceImpl;
import web.product.vo.Product;

@WebServlet("/api/0.01/product/*")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//	private String pathInfo;
//	private String[] infos;
	private ProductService service;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		JsonObject respObject = new JsonObject();
		try {
			service = new ProductServiceImpl();
			Set<Product> products = service.getAll();
			if (products != null) {
				respObject.addProperty("msg", "success");
				respObject.add("products", gson.toJsonTree(products));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}


	private void setHeaders(HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


}
