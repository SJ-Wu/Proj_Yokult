package web.fundraising.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;
import web.fundraising.service.OrderService;
import web.fundraising.service.PlanService;
import web.fundraising.service.ProposalService;
import web.fundraising.vo.OrderBean;
import web.fundraising.vo.PlanBean;
import web.fundraising.vo.ProposalBean;


@WebServlet("/fundraising")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
//當數據量大於fileSizeThreshold值時，內容將被寫入磁碟
//上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException 異常
public class FundraisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
	    res.addHeader("Access-Control-Allow-Origin", "*");
//	    res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//	    res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//	    res.addHeader("Access-Control-Max-Age", "1728000");

	    
//	    取得目前session參數，在離開servlet前都沒有session關閉的問題
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.getCurrentSession();
//	    Transaction trx = session.beginTransaction();
	    
	    
//	    取得HttpSession，傳遞參數用
    	HttpSession httpSession = req.getSession();
    	
    	
//	    儲存前端request傳來的action動作參數
	    String action = "";
//	    儲存要前往的網頁url
	    String destination = "";
	    
//	    =========================================  主程式開始  =========================================
	    
//	    == 檢查前端form資料 ==
//	    建立檢視template並逐個列印參數，但不含upload file！！！
	    String template = "ParamName: %s,		ParamValue: %s";
	    Enumeration<String> names = req.getParameterNames();
    	while(names.hasMoreElements()) {
    		String key = names.nextElement();
    		System.out.println(String.format(template, key, req.getParameter(key)));				
    	}
    	
//    	單獨列印upload file資訊
    	System.out.println("=== proposalFile ===");
	    String fileName = req.getPart("proposalFile").getSubmittedFileName();
	    System.out.println(String.format(template, "proposalFile", fileName));
	    String memberID = "TGA001";
	    String memberUploadPath = getServletContext().getRealPath("/") + "uploaded" + "\\" + memberID;
	    String memberUploadFilePath = memberUploadPath + "\\" + fileName;
	    for (Part part : req.getParts()) {
	    	if("proposalFile".equals(part.getName())  ) {
	    		File theDir = new File(memberUploadPath);
	    		if (!theDir.exists()){
	    			theDir.mkdirs();
	    			System.out.println("Directory created : " + memberUploadPath);	    			
	    		}else {
	    			System.out.println("Directory is exist.");					
				}
	    		part.write(memberUploadFilePath);	
	    	    System.out.println("The uploaded file uploaded and writed sucessfully.\n");
	    	}
	    }

	    
//	    == 將前端form參數傳入對應的bean資訊 ==
	    if("newProposal".equals(req.getParameter("action"))){	    
	    	System.out.println("\n-------------- command : " + req.getParameter("action") + " ------- start -------");
	    	
	    	ProposalBean bean = new ProposalBean();
	    	bean.setProposalName(req.getParameter("proposalName"));
//	    	System.out.println("proposalName");
	    	bean.setProposalHostName(req.getParameter("proposalHostName"));
//	    	System.out.println("proposalHostName");
	    	bean.setProposalGoal(Integer.parseInt(req.getParameter("proposalGoal")));
//	    	System.out.println("proposalGoal");
	    	bean.setProposalCategoryID(req.getParameter("proposalCategory"));
//	    	System.out.println("proposalCategory");
	    	
	    	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm");
		    
	    	String[] start = req.getParameter("proposalStartedDateTime").split("T");
		    String startDateTime = start[0] + " " + start[1];
		    java.util.Date startDate = null;
			try {startDate = formatter.parse(startDateTime);} catch (ParseException e) {}
			java.sql.Timestamp startTimestamp = new java.sql.Timestamp(startDate.getTime());
//		    System.out.println("timestamp : " + startTimestamp);
		    bean.setProposalStartedDateTime(startTimestamp);
//	    	System.out.println("proposalStartedDateTime");

		    String[] end = req.getParameter("proposalEndedDateTime").split("T");
		    String endDateTime = end[0] + " " + end[1];
		    java.util.Date endDate = null;
			try {endDate = formatter.parse(endDateTime);} catch (ParseException e) {}
			java.sql.Timestamp endTimestamp = new java.sql.Timestamp(endDate.getTime());
//		    System.out.println("timestamp : " + endTimestamp);
		    bean.setProposalEndedDateTime(endTimestamp);
//	    	System.out.println("proposalEndedDateTime");
	    	
		    
		    System.out.println(endDate.getTime() - startDate.getTime());
		    System.out.println("startDate.getTime() : " + startDate.getTime());
		    System.out.println("endDate.getTime() : " + endDate.getTime());
		    
		    
	    	bean.setStatusID(req.getParameter("proposalCategory"));
//	    	System.out.println("proposalCategory");
	    	bean.setProposalEmail(req.getParameter("proposalEmail"));
//	    	System.out.println("proposalEmail");
	    	bean.setProposalCellphone(req.getParameter("proposalCellphone"));
//	    	System.out.println("proposalCellphone");
	    	bean.setProposalSummary(req.getParameter("proposalContent"));
//	    	System.out.println("proposalContent");
	    	bean.setProposalPageContent(memberUploadFilePath);
//	    	System.out.println("proposalFile" + memberUploadFilePath.length());
	    	bean.setMemID("TGA001");
//	    	System.out.println("memID");
	    	
//	    	以下為測試輸入用(經確認可用)
//	    	bean.setProposalStartedDateTime(new java.sql.Timestamp(1655568000000L));
//	    	bean.setProposalEndedDateTime(new java.sql.Timestamp(1668787200000L));
	    	
//	    	以下為測試用資料(經確認可用)
//	    	ProposalBean bean = new ProposalBean(
//	    			"12023微笑曲線計畫｜為每個人打造獨一無二的微笑曲線",
//	    			"1牙樂多診所1",
//	    			10,
//	    			"1",
//	                new java.sql.Timestamp(1655568000000L),
//	                new java.sql.Timestamp(1668787200000L),
//	    			"1",
//	    			"xyz@yahoo.com",
//	    			"0987654321",
//	    			"們一起打造獨一無二的微笑曲線吧",
//	    			"ising\\sql\\file\\PageC",
//	    			"TGA002"
//	    			);
	    	
	    	
	    	System.out.println(bean);
	    	
//	    	執行存入(MySQL)
	    	ProposalService proposalService = new ProposalService(session);
	    	System.out.println("new proposalService");
	    	proposalService.insertBean(bean);
	    	System.out.println("insertBean");
	    	
	    	System.out.println("-------------- command : " + req.getParameter("action") + " ------- end -------\n");
	    }

//	    if(true) {
//	    	ProposalService proposalService = new ProposalService(session);
//	    	List<ProposalBean> list_Proposal = proposalService.selectAllBeans();
//	    	httpSession.setAttribute("list_Proposal", list_Proposal);
//		}
//	    System.out.println("-------------- command : " + req.getParameter("action") + " ------- end -------\n");
//
//	    if(true) {
//	    	PlanService planService = new PlanService(session);
//	    	List<PlanBean> list_Plan = planService.selectAllBeans();
//	    	httpSession.setAttribute("list_Plan", list_Plan);
//		}
//	    System.out.println("-------------- command : " + req.getParameter("action") + " ------- end -------\n");
//
//	    if(true) {
//	    	OrderService orderService = new OrderService(session);
//	    	List<OrderBean> list_Order = orderService.selectAllBeans();
//	    	httpSession.setAttribute("list_Order", list_Order);
//	    }
//	    System.out.println("-------------- command : " + req.getParameter("action") + " ------- end -------\n");

	    
//	    trx.commit();
	    destination = "/fundraising/ModelTest.jsp";
	    RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
	    requestDispatcher.forward(req, res);
	    
	    System.out.println("-------------- command : " + req.getParameter("action") + " ------- end -------\n");

	}
}
