<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List, java.sql.*, org.hibernate.Session" %>
<%@ page import="static web.fundraising.common.CommonJDBC.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProposalTest.jsp</title>

<style>
  table {
    bproposal: 2px solid black;
    text-align: center;
    padding: 5px;
  }
  th {
    bproposal-left: 1px solid black;
    text-align: center;

  }
  th {
    bproposal-bottom: 2px solid black;
    text-align: center;
        margin-left: 5px;
  }
</style>

</head>
<body>

<h2>Proposal 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>
<%
	//Session currentSession = (Session)request.getAttribute("session");
	ProposalService service = new ProposalService();
	List<ProposalBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>提案ID</th> <th>提案名稱Name</th> <th>提案人Name</th> <th>目標金額Amount</th> <th>類別ID</th> 
	<th>開始日期StartedDate</th> <th>結束日期EndedDate</th> <th>階段ID</th> <th>電子郵件Email</th>
	<th>連絡電話Phone</th> <th>概要Summary</th> <th>頁面內容Page檔案</th> <th>會員ID</th> </tr>
	<c:forEach var="proposalBean" items="<%= list%>">
		<tr>
			<th>${proposalBean.proposalID}</th>
			<th>${proposalBean.proposalName}</th>
			<th>${proposalBean.proposalHostName}</th>
			<th>${proposalBean.proposalGoal}</th>
			<th>${proposalBean.proposalCategoryID}</th>
			<th>${proposalBean.proposalStartedDateTime}</th>
			<th>${proposalBean.proposalEndedDateTime}</th>
			<th>${proposalBean.statusID}</th>
			<th>${proposalBean.proposalEmail}</th>
			<th>${proposalBean.proposalCellphone}</th>
			<th>${proposalBean.proposalSummary}</th>
			<th>${proposalBean.proposalPageContent}</th>
			<th>${proposalBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (三筆，名字: 政瑋1, 政瑋2, 政瑋3)</h4>
<%

ProposalBean bean1 = new ProposalBean(
		"偏鄉牙醫志工團｜為偏鄉學童巡迴牙齒健檢", 
		"社團法人中華民國牙醫師公會全國聯合會", 
		"500000",
		1, 
		"2022-06-01 00:00:00", 
		"2022-09-01 00:00:00",
		"1",
		"abc@gmail.com",
		"0912345678",
		"跟我們一起為偏鄉國小注入活力吧！",
		"\\src\\main\\java\\web\\fundraising\\sql\\file\\PageContent_1.docx",
		"test_account1");
ProposalBean bean2 = new ProposalBean(
		"政瑋2", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_92");
ProposalBean bean3 = new ProposalBean(
		"政瑋3", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_93");
	int generatedID1 = service.insertBean(bean1).getProposalID();
	int generatedID2 = service.insertBean(bean2).getProposalID();
	int generatedID3 = service.insertBean(bean3).getProposalID();
	List<ProposalBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>提案ID</th> <th>提案名稱Name</th> <th>提案人Name</th> <th>目標金額Amount</th> <th>類別ID</th> 
	<th>開始日期StartedDate</th> <th>結束日期EndedDate</th> <th>階段ID</th> <th>電子郵件Email</th>
	<th>連絡電話Phone</th> <th>概要Summary</th> <th>頁面內容Page檔案</th> <th>會員ID</th> </tr>
	<c:forEach var="proposalBean" items="<%= list%>">
		<tr>
			<th>${proposalBean.proposalID}</th>
			<th>${proposalBean.proposalName}</th>
			<th>${proposalBean.proposalHostName}</th>
			<th>${proposalBean.proposalGoal}</th>
			<th>${proposalBean.proposalCategoryID}</th>
			<th>${proposalBean.proposalStartedDateTime}</th>
			<th>${proposalBean.proposalEndedDateTime}</th>
			<th>${proposalBean.statusID}</th>
			<th>${proposalBean.proposalEmail}</th>
			<th>${proposalBean.proposalCellphone}</th>
			<th>${proposalBean.proposalSummary}</th>
			<th>${proposalBean.proposalPageContent}</th>
			<th>${proposalBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (名字： 政瑋3)</h4>
<%
	service.deleteBean(generatedID3);
	List<ProposalBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>提案ID</th> <th>提案名稱Name</th> <th>提案人Name</th> <th>目標金額Amount</th> <th>類別ID</th> 
	<th>開始日期StartedDate</th> <th>結束日期EndedDate</th> <th>階段ID</th> <th>電子郵件Email</th>
	<th>連絡電話Phone</th> <th>概要Summary</th> <th>頁面內容Page檔案</th> <th>會員ID</th> </tr>
	<c:forEach var="proposalBean" items="<%= list%>">
		<tr>
			<th>${proposalBean.proposalID}</th>
			<th>${proposalBean.proposalName}</th>
			<th>${proposalBean.proposalHostName}</th>
			<th>${proposalBean.proposalGoal}</th>
			<th>${proposalBean.proposalCategoryID}</th>
			<th>${proposalBean.proposalStartedDateTime}</th>
			<th>${proposalBean.proposalEndedDateTime}</th>
			<th>${proposalBean.statusID}</th>
			<th>${proposalBean.proposalEmail}</th>
			<th>${proposalBean.proposalCellphone}</th>
			<th>${proposalBean.proposalSummary}</th>
			<th>${proposalBean.proposalPageContent}</th>
			<th>${proposalBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (名字： 政瑋2 -> 政瑋4)</h4>
<%
	ProposalBean bean4 = new ProposalBean(
			"政瑋4", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_93");
	service.updateBean(generatedID2, bean4);
	List<ProposalBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>提案ID</th> <th>提案名稱Name</th> <th>提案人Name</th> <th>目標金額Amount</th> <th>類別ID</th> 
	<th>開始日期StartedDate</th> <th>結束日期EndedDate</th> <th>階段ID</th> <th>電子郵件Email</th>
	<th>連絡電話Phone</th> <th>概要Summary</th> <th>頁面內容Page檔案</th> <th>會員ID</th> </tr>
	<c:forEach var="proposalBean" items="<%= list%>">
		<tr>
			<th>${proposalBean.proposalID}</th>
			<th>${proposalBean.proposalName}</th>
			<th>${proposalBean.proposalHostName}</th>
			<th>${proposalBean.proposalGoal}</th>
			<th>${proposalBean.proposalCategoryID}</th>
			<th>${proposalBean.proposalStartedDateTime}</th>
			<th>${proposalBean.proposalEndedDateTime}</th>
			<th>${proposalBean.statusID}</th>
			<th>${proposalBean.proposalEmail}</th>
			<th>${proposalBean.proposalCellphone}</th>
			<th>${proposalBean.proposalSummary}</th>
			<th>${proposalBean.proposalPageContent}</th>
			<th>${proposalBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除兩筆，名字： 政瑋2、政瑋4)</h4>

<%
	service.deleteBean(generatedID1);
	service.deleteBean(generatedID2);
	List<ProposalBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>提案ID</th> <th>提案名稱Name</th> <th>提案人Name</th> <th>目標金額Amount</th> <th>類別ID</th> 
	<th>開始日期StartedDate</th> <th>結束日期EndedDate</th> <th>階段ID</th> <th>電子郵件Email</th>
	<th>連絡電話Phone</th> <th>概要Summary</th> <th>頁面內容Page檔案</th> <th>會員ID</th> </tr>
	<c:forEach var="proposalBean" items="<%= list%>">
		<tr>
			<th>${proposalBean.proposalID}</th>
			<th>${proposalBean.proposalName}</th>
			<th>${proposalBean.proposalHostName}</th>
			<th>${proposalBean.proposalGoal}</th>
			<th>${proposalBean.proposalCategoryID}</th>
			<th>${proposalBean.proposalStartedDateTime}</th>
			<th>${proposalBean.proposalEndedDateTime}</th>
			<th>${proposalBean.statusID}</th>
			<th>${proposalBean.proposalEmail}</th>
			<th>${proposalBean.proposalCellphone}</th>
			<th>${proposalBean.proposalSummary}</th>
			<th>${proposalBean.proposalPageContent}</th>
			<th>${proposalBean.memID}</th>	
		</tr>
	</c:forEach>
</table>
<%
	String path = request.getServletPath();
	System.out.println(path + ".......OK！");
%>
<!-- ------------------------------------------------------------ -->
</body>

</html>