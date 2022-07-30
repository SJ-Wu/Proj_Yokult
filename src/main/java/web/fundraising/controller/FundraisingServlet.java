package web.fundraising.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;
import web.fundraising.service.OrderService;
import web.fundraising.service.PlanService;
import web.fundraising.vo.OrderBean;
import web.fundraising.vo.PlanBean;


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
	    Session session = sessionFactory.getCurrentSession();
//	    Transaction trx = session.beginTransaction();
	    
	    //取得HttpSession，傳遞參數
    	HttpSession httpSession = req.getSession();
	    

//	    String action = "";
	    String destination = "";
	    

	    if(true) {
	    	PlanService planService = new PlanService(session);
	    	List<PlanBean> list_Plan = planService.selectAllBeans();
	    	httpSession.setAttribute("list_Plan", list_Plan);
		}
	    
	    if(true) {
	    	OrderService orderService = new OrderService(session);
	    	List<OrderBean> list_Order = orderService.selectAllBeans();
	    	httpSession.setAttribute("list_Order", list_Order);
	    }
	    	destination = "/fundraising/ModelTest.jsp";
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
	    	requestDispatcher.forward(req, res);

	}
}
