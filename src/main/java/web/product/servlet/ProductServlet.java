package web.product.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.product.service.ProductService;
import web.product.service.impl.ProductServiceImpl;
import web.product.vo.Product;

@WebServlet("/api/0.01/product/*")
@MultipartConfig
public class ProductServlet extends HttpServlet {
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

		String category = req.getParameter("category");
		String productName = req.getParameter("productName");

		System.out.println(category);
		try {
			service = new ProductServiceImpl();
			List<Product> products = service.getAll(category, productName);
			if (products != null) {
				respObject.addProperty("msg", "success");
				respObject.add("products", gson.toJsonTree(products));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		JsonObject respObject = new JsonObject();
		String pathInfo = req.getPathInfo();
		System.out.println(pathInfo);
		if (pathInfo != null && pathInfo != "") {
			String[] infos = pathInfo.split("/");
			for (String info: infos) {
				System.out.println(info);
			}
			if ("uploadImage".equals(infos[1])) {
				final String saveDirectory = "/images_uploaded";
				req.setCharacterEncoding("UTF-8");
				String realpath = getServletContext().getRealPath(saveDirectory);
				File fSaveDirectory = new File(realpath);
				if (!fSaveDirectory.exists()) {
					fSaveDirectory.mkdir();
				}
				String imagePath = "";
				Collection<Part> parts = req.getParts();
				for (Part part : parts) {
					SimpleDateFormat sDateFormat = new SimpleDateFormat("yyMMddHHmmss");
					String filename = sDateFormat.format(new Date()) + "_" + part.getSubmittedFileName();
					File f = new File(fSaveDirectory, filename);
					part.write(f.toString());
					imagePath = req.getContextPath()+ saveDirectory + "/" + filename;
					System.out.println("image path: " + imagePath);
				}

				respObject.addProperty("msg", "success");
				respObject.addProperty("proPicture", imagePath);
			}
		}
		else {
			Product product = gson.fromJson(req.getReader(), Product.class);
			try {
				service = new ProductServiceImpl();
				Integer status = service.add(product);
				if (status > 0) {
					respObject.addProperty("msg", "success");
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		resp.getWriter().append(gson.toJson(respObject));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Product product = gson.fromJson(req.getReader(), Product.class);
		System.out.println(product.toString());

		try {
			service = new ProductServiceImpl();
			service.save(product);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		resp.getWriter().append(gson.toJson(""));
	}

	private void setHeaders(HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

}
