package web.fundraising.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import web.fundraising.common.HibernateUtil;

@WebServlet("/fundraising")
public class FundraisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    res.setContentType("text/html; charset=UTF-8");

//	    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//	    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    
//	    Session session = sessionFactory.getCurrentSession();
//	    Transaction trx = session.beginTransaction();
	    
	    
//	    PlanBean pb = new PlanBean(
//	    		"感謝小卡",
//	    		500,
//	    		"備註：感謝小卡將由我們親自設計",
//	    		"只寄送台灣本島",
//	    		new Date(1655568000000L),
//	    		new Date(1668787200000L),
//	    		1,
//	    		1);
//	    
//	    
//	    
//	    String action = "";
	    String destination = "";
	        
	    
	    //測試model & SQL間是否無誤
//	    if("ModelTest".equalsIgnoreCase(action)) {	    	
	    	destination = "/fundraising/ModelTest.jsp";
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
	    	requestDispatcher.forward(req, res);
//	    }
	    
	    
//	    trx.commit();
//	    session.close();
//	    sessionFactory.close();
	    HibernateUtil.closeSessionFactory();
	}
}
