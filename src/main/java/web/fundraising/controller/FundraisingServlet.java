package web.fundraising.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import model.hibernate.HibernateUtil;
import web.fundraising.common.HtmlDatetimeLocalToSQLDateTimeUtil;
import web.fundraising.common.HtmlPostJsonGetter;
import web.fundraising.service.CategoryService;
import web.fundraising.service.OrderService;
import web.fundraising.service.PlanService;
import web.fundraising.service.PostService;
import web.fundraising.service.ProposalService;
import web.fundraising.service.StatusService;
import web.fundraising.vo.CategoryBean;
import web.fundraising.vo.OrderBean;
import web.fundraising.vo.PlanBean;
import web.fundraising.vo.PostBean;
import web.fundraising.vo.ProposalBean;
import web.fundraising.vo.StatusBean;


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
	    
	    res.addHeader("Access-Control-Allow-Origin", "*");
//	    res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//	    res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//	    res.addHeader("Access-Control-Max-Age", "1728000");


//	    儲存前端request傳來的table動作參數
	    String table = "";
//	    儲存前端request傳來的action動作參數
	    String action = "";
//	    儲存要前往的網頁url
	    String destination = "";
//	    列印request的樣板
	    String template = "ParamName: %s,		ParamValue: %s";
	    
	    
//	    取得HttpSession，傳遞參數用
	    HttpSession httpSession = req.getSession();
//	    檢查是否登入、是否有提案
	    httpSession.setAttribute("memID", "TGA001");
	    String memberID = "TGA001";
	    Integer proposalID = 1;
	    RequestDispatcher requestDispatcher = req.getRequestDispatcher("//");
	    if("memberID" != httpSession.getAttribute("memID")) {
	    	requestDispatcher.forward(req, res);
	    }
	    
	    
//	    取得目前session參數，在離開servlet前都沒有session關閉的問題
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.getCurrentSession();
//    	Transaction trx = session.beginTransaction();
	    
	    
//	    == 檢查前端form資料 ==
//	   	如果有的話，建立檢視template並逐個列印參數，但不含upload file！！！
	    Enumeration<String> names = req.getParameterNames();
	    while(names.hasMoreElements()) {
	    	String key = names.nextElement();
	    	System.out.println(String.format(template, key, req.getParameter(key)));				
	    }
	    
	    
	    
//	    =========================================  主程式開始  =========================================
	    
//	    =========================================  查詢全部proposal  =========================================
	    //如果是JSON格式就先抓看看有沒有自訂的指令參數
//	    try {
//			HtmlPostJsonGetter htmlPostJsonGetter = new HtmlPostJsonGetter(req);
//			table = htmlPostJsonGetter.getString("table");
//			action = htmlPostJsonGetter.getString("action");
//			System.out.println("table : " + table);
//			System.out.println("action : " + action);
//		} catch (Exception e1) {}
//	    
//	    
////	    if("Proposal".equals(req.getParameter("table")) && "GetAll".equals(req.getParameter("action"))){	
//	    if("Proposal".equals(table) && "GetAll".equals(action)) {
//	    	res.setContentType("application/json; charset=utf-8");
//	    	ProposalService proposalService = new ProposalService(session);
//	    	List<ProposalBean> beanList =  proposalService.selectAllBeans();
	    	
//	        res.getWriter().print("beanList : " + beanList.toString());
	    	
	    	
//	    	Gson gson = new Gson();
//	    	PrintWriter out = res.getWriter();
//	    	
//	    	String s = gson.toJson(beanList.get(0));
//    		System.out.println(s);
//    		out.write(s);
	        
//	    	for(ProposalBean row : beanList) {
//	    		String s = gson.toJson(row);
//	    		System.out.println(s);
//	    		out.write(s);
//	    	}
//	    	System.out.println("\n"+json);
	    	
//	    	String employeeJsonString = new Gson().toJson(beanList.to);
//	    	out.write(employeeJsonString);
//	    	out.flush();
//	    	res.flushBuffer();
//	    }
	    
	    
	    
	    
////    測試用輸入
//    table = "Order";
//    action = "Insert";
//    =========================================  新增一個order  =========================================
////    if("Order".equals(req.getParameter("table")) && "Insert".equals(req.getParameter("action"))){	    
//    if("Order".equals(table) && "Insert".equals(action)){	    
//		res.setContentType("text/html; charset=UTF-8");
////    	標註起始
//    	FundraisingServlet.getTableActionStart(req, table, action);
//    	
//    	OrderBean bean = new OrderBean();
//    	bean.setOrderInvoiceNumber(req.getParameter("orderInvoiceNumber"));
//    	
//    	java.sql.Timestamp startDate = HtmlDatetimeLocalToSQLDateTimeUtil.parse(req, req.getParameter("orderDateTime"));
//    	bean.setOrderDateTime(startDate);
//    	
//    	bean.setOrderAmount(Integer.parseInt(req.getParameter("orderAmount")));
//    	bean.setProposalID(Integer.parseInt(req.getParameter("proposalID")));
//    	bean.setPlanID(Integer.parseInt(req.getParameter("planID")));
//    	bean.setPostID(Integer.parseInt(req.getParameter("postID")));
//    	bean.setMemID("TGA001");
//    	
//    	System.out.println("print bean");
//    	System.out.println(bean);
//    	
//    	
////    	執行存入(MySQL)
//    	OrderService orderService = new OrderService(session);
//    	System.out.println("new orderService");
//    	try {
////	    	== 將前端 newOrder頁面 form參數傳入對應的bean資訊 ==
//    		orderService.insertBean(bean);
//		} catch (Exception e) {
//		} finally {
//			System.out.println("insertBean");
////	    	標註結束
//			FundraisingServlet.getTableActionEnd(req, table, action);
//		}
//    }
	    
	    
	    
	    
////    測試用輸入
//    table = "Post";
//    action = "Insert";
//    =========================================  新增一個post  =========================================
////    if("Post".equals(req.getParameter("table")) && "Insert".equals(req.getParameter("action"))){	    
//    if("Post".equals(table) && "Insert".equals(action)){	    
//		res.setContentType("text/html; charset=UTF-8");
////    	標註起始
//    	FundraisingServlet.getTableActionStart(req, table, action);
//    	
//    	PostBean bean = new PostBean();
//    	bean.setPostFisrtName(req.getParameter("postFisrtName"));
//    	bean.setPostLastName(req.getParameter("postLastName"));
//    	bean.setPostCellphone(req.getParameter("postCellphone"));
//    	bean.setPost_SID(Integer.parseInt(req.getParameter("post_SID")));
//    	bean.setPostAddress(req.getParameter("postAddress"));
//    	bean.setMemID("TGA001");
//    	
//    	System.out.println("print bean");
//    	System.out.println(bean);
//    	
//    	
////    	執行存入(MySQL)
//    	PostService postService = new PostService(session);
//    	System.out.println("new postService");
//    	try {
////	    	== 將前端 newPost頁面 form參數傳入對應的bean資訊 ==
//    		postService.insertBean(bean);
//		} catch (Exception e) {
//		} finally {
//			System.out.println("insertBean");
////	    	標註結束
//			FundraisingServlet.getTableActionEnd(req, table, action);
//		}
//    }

	    
	    
//	    =========================================  新增一個proposal  =========================================
//	    if("Proposal".equals(req.getParameter("table")) && "Insert".equals(req.getParameter("action"))){	    
//    		res.setContentType("text/html; charset=UTF-8");
////    		單獨列印newProposal頁面upload file資訊
//	    	System.out.println("=== proposalFile ===");
//	    	String fileName = req.getPart("proposalFile").getSubmittedFileName();
//	    	System.out.println(String.format(template, "proposalFile", fileName));
////	    	預設會員帳號TGA001
//	    	String memberUploadPath = getServletContext().getRealPath("/") + "uploaded\\proposal" + "\\" + memberID;
//	    	String memberUploadFilePath = memberUploadPath + "\\" + fileName;
////	    	儲存會員上傳的檔案
//	    	for (Part part : req.getParts()) {
////	    		newProposal頁面
//		    	if("proposalFile".equals(part.getName())  ) {
//		    		File theDir = new File(memberUploadPath);
//		    		if (!theDir.exists()){
//		    			theDir.mkdirs();
//		    			System.out.println("Directory created : " + memberUploadPath);	    			
//		    		}else {
//		    			System.out.println("Directory is exist.");					
//					}
//		    		part.write(memberUploadFilePath);	
//		    	    System.out.println("The uploaded file uploaded and writed sucessfully.\n");
//		    	}
//	    	}
//	    	
////	    	標註起始
//	    	FundraisingServlet.getTableActionStart(req, table, action);
//	    	
//	    	ProposalBean bean = new ProposalBean();
//	    	bean.setProposalName(req.getParameter("proposalName"));
//	    	bean.setProposalHostName(req.getParameter("proposalHostName"));
//	    	bean.setProposalGoal(Integer.parseInt(req.getParameter("proposalGoal")));
//	    	bean.setProposalCategoryID(req.getParameter("proposalCategory"));
//	    	
//	    	java.sql.Timestamp startDate = HtmlDatetimeLocalToSQLDateTimeUtil.parse(req, req.getParameter("proposalStartedDateTime"));
//		    bean.setProposalStartedDateTime(startDate);
//		    java.sql.Timestamp endDate = HtmlDatetimeLocalToSQLDateTimeUtil.parse(req, req.getParameter("proposalEndedDateTime"));
//		    bean.setProposalEndedDateTime(endDate);
//		    
//	    	bean.setStatusID("3");
//	    	bean.setProposalEmail(req.getParameter("proposalEmail"));
//	    	bean.setProposalCellphone(req.getParameter("proposalCellphone"));
//	    	bean.setProposalSummary(req.getParameter("proposalContent"));
//	    	bean.setProposalPageContent(memberUploadFilePath);
//	    	bean.setMemID("TGA001");
//	    	
//	    	System.out.println("print bean");
//	    	System.out.println(bean);
//	    	
//	    	
////	    	執行存入(MySQL)
//	    	ProposalService proposalService = new ProposalService(session);
//	    	System.out.println("new proposalService");
//	    	try {
////		    	== 將前端 newProposal頁面 form參數傳入對應的bean資訊 ==
//	    		proposalService.insertBean(bean);
//			} catch (Exception e) {
//			} finally {
//				System.out.println("insertBean");
////		    	標註結束
//				FundraisingServlet.getTableActionEnd(req, table, action);
//			}
//	    }

	    
	    
//	    =========================================  新增一個plan  =========================================
//	    if("Plan".equals(req.getParameter("table")) && "Insert".equals(req.getParameter("action"))) {
//	    	
////    		單獨列印newPlan頁面upload file資訊
//	    	System.out.println("=== planPicture ===");
//	    	String pictureName = req.getPart("planPicture").getSubmittedFileName();
//	    	System.out.println(String.format(template, "planPicture", pictureName));
////	    	預設會員帳號TGA001
//	    	String memberUploadPath = getServletContext().getRealPath("/") + "uploaded\\proposal\\plan" + "\\" + memberID;
//	    	String memberUploadPicturePath = memberUploadPath + "\\" + pictureName;
////	    	儲存會員上傳的檔案
//	    	for (Part part : req.getParts()) {
////	    		newPlan頁面
//		    	if("planPicture".equals(part.getName())  ) {
//		    		File theDir = new File(memberUploadPath);
//		    		if (!theDir.exists()){
//		    			theDir.mkdirs();
//		    			System.out.println("Directory created : " + memberUploadPath);	    			
//		    		}else {
//		    			System.out.println("Directory is exist.");					
//					}
//		    		part.write(memberUploadPicturePath);
//		    	    System.out.println("The uploaded picture uploaded and writed sucessfully.\n");
//		    	}
//	    	}
//	    	
////	    	標註起始
//	    	FundraisingServlet.getTableActionStart(req, table, action);
////	    	
//	    	PlanBean bean = new PlanBean();
//	    	bean.setPlanName(req.getParameter("planName"));
//	    	bean.setPlanAmount(Integer.parseInt(req.getParameter("planAmount")));
//	    	bean.setPlanContent(req.getParameter("planContent"));
//	    	bean.setPlanPostNote(req.getParameter("planPostNote"));
//	    	
//	    	java.sql.Timestamp planStartedDateTime = HtmlDatetimeLocalToSQLDateTimeUtil.parse(req, req.getParameter("planStartedDateTime"));
//	    	bean.setPlanStartedDate(planStartedDateTime);
//	    	java.sql.Timestamp planEndedDateTime = HtmlDatetimeLocalToSQLDateTimeUtil.parse(req, req.getParameter("planEndedDateTime"));
//	    	bean.setPlanEndedDate(planEndedDateTime);
//	    	
//	    	bean.setStatusID(req.getParameter(memberID));
//	    	bean.setProposalID(proposalID);
//	    	
//	    	System.out.println(bean);
//	    	
//	    	
////	    	執行存入(MySQL)
//	    	PlanService planService = new PlanService(session);
//	    	System.out.println("new planService");
//	    	try {
//	    		planService.insertBean(bean);
//			} catch (Exception e) {
//			} finally {
//				System.out.println("insertBean");
////		    	標註結束
//				FundraisingServlet.getTableActionEnd(req, table, action);
//			}
//	    	
//		    destination = "/fundraising/ModelTest.jsp";
//		    requestDispatcher = req.getRequestDispatcher(destination);
//		    requestDispatcher.forward(req, res);
//	    }
	    
	    
//	    =========================================  其他(查詢)  =========================================
	    
//	    if(true) {
	    CategoryService categoryService = new CategoryService(session);
	    List<CategoryBean> list_Category = categoryService.selectAllBeans();
	    for(CategoryBean b : list_Category) {
	    	System.out.println(b);
	    }
	    System.out.println();
//	    	httpSession.setAttribute("list_Category", list_Category);
//	    }
	    System.out.println("-------------- command ------- end -------\n");
	    
	    
//	    if(true) {
	    OrderService orderService = new OrderService(session);
	    List<OrderBean> list_Order = orderService.selectAllBeans();
	    for(OrderBean b : list_Order) {
	    	System.out.println(b);
	    }
	    System.out.println();
//	    	httpSession.setAttribute("list_Order", list_Order);
//	    }
	    System.out.println("-------------- command :  ------- end -------\n");

	    
//	    if(true) {
	    PlanService planService = new PlanService(session);
	    List<PlanBean> list_Plan = planService.selectAllBeans();
	    for(PlanBean b : list_Plan) {
	    	System.out.println(b);
	    }
	    System.out.println();
//	    	httpSession.setAttribute("list_Plan", list_Plan);
//		}
	    System.out.println("-------------- command :  ------- end -------\n");

	    
//	    if(true) {
	    PostService postService = new PostService(session);
	    List<PostBean> list_Post = postService.selectAllBeans();
	    for(PostBean b : list_Post) {
	    	System.out.println(b);
	    }
	    System.out.println();
//	    	httpSession.setAttribute("list_Post", list_Post);
//		}
	    System.out.println("-------------- command :  ------- end -------\n");
	    
	    
//	    if(true) {
	    	ProposalService proposalService = new ProposalService(session);
	    	List<ProposalBean> list_Proposal = proposalService.selectAllBeans();
	    	for(ProposalBean b : list_Proposal) {
	    		System.out.println(b);
	    	}
	    	System.out.println();
//	    	httpSession.setAttribute("list_Proposal", list_Proposal);
//		}
		    System.out.println("-------------- command :  ------- end -------\n");

		    
//	    if(true) {
	    	StatusService statusService = new StatusService(session);
	    	List<StatusBean> list_Status = statusService.selectAllBeans();
	    	for(StatusBean b : list_Status) {
	    		System.out.println(b);
	    	}
	    	System.out.println();
//	    	httpSession.setAttribute("list_Status", list_Status);
//	    }
	    System.out.println("-------------- command ------- end -------\n");
	    
	    
	    
//	    trx.commit();
//	    destination = "/fundraising/ModelTest.jsp";
//	    requestDispatcher = req.getRequestDispatcher(destination);
//	    requestDispatcher.forward(req, res);


	}
	public static String getTableActionStart(HttpServletRequest req, String table, String action) {
		return "\n-------------- command : " + req.getParameter(table) + " " + req.getParameter(action) + " ------- start -------";
	}
	public static String getTableActionEnd(HttpServletRequest req, String table, String action) {
		return "\n-------------- command : " + req.getParameter(table) + " " + req.getParameter(action) + " ------- End -------";
	}
}
