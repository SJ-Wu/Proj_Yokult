package web.fundraising.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.fundraising.service.CategoryService;
import web.fundraising.vo.CategoryBean;

@WebServlet("/fundraising")
public class FundraisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    res.setContentType("text/html; charset=UTF-8");

	    String action = "";
	    String destination = "";
	    
	    if("ModelTest".equalsIgnoreCase(action)) {	    	
	    	destination = "/fundraising/ModelTest.jsp";
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
	    	requestDispatcher.forward(req, res);
	    }
	}

}
