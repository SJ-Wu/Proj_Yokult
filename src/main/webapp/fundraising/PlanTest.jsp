<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List, java.sql.*, org.hibernate.Session" %>
<%@ page import="static web.fundraising.common.CommonJDBC.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PlanTest.jsp</title>

<style>
  table {
    bplan: 2px solid black;
    text-align: center;
    padding: 5px;
  }
  th {
    bplan-left: 1px solid black;
    text-align: center;

  }
  th {
    bplan-bottom: 2px solid black;
    text-align: center;
        margin-left: 5px;
  }
</style>

</head>
<body>

<h2>Plan 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>
<%
	Session currentSession = (Session)request.getAttribute("session");
	PlanService service = new PlanService(currentSession);
	List<PlanBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="<%= list%>">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.propoID}</th>			
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (三筆，Amount: 100, 200, 300)</h4>
<%
	PlanBean bean1 = new PlanBean(
		"感謝小卡", 100, "備註：感謝小卡將由我們親自設計", "只寄送台灣本島", new Date(1655568000000L), new Date(1668787200000L), 1, 1);
	PlanBean bean2 = new PlanBean(
		"感謝小卡", 200, "備註：感謝小卡將由我們親自設計", "只寄送台灣本島", new Date(1655568000000L), new Date(1668787200000L), 1, 1);
	PlanBean bean3 = new PlanBean(
		"感謝小卡", 300, "備註：感謝小卡將由我們親自設計", "只寄送台灣本島", new Date(1655568000000L), new Date(1668787200000L), 1, 1);
	int generatedID1 = service.insertBean(bean1).getPlanID();
	int generatedID2 = service.insertBean(bean2).getPlanID();
	int generatedID3 = service.insertBean(bean3).getPlanID();
	List<PlanBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="<%= list%>">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.propoID}</th>			
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (auto increment(Amount: 300))</h4>
<%
	service.deleteBean(generatedID3);
	List<PlanBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="<%= list%>">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.propoID}</th>			
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (Amount: 200 -> 400)</h4>
<%
	PlanBean bean4 = new PlanBean(
		"感謝小卡", 400, "備註：感謝小卡將由我們親自設計", "只寄送台灣本島", new Date(1655568000000L), new Date(1668787200000L), 1, 1);
	service.updateBean(generatedID2, bean4);
	List<PlanBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="<%= list%>">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.propoID}</th>			
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除兩筆，Amount: 100, 400)</h4>

<%
	service.deleteBean(generatedID1);
	service.deleteBean(generatedID2);
	List<PlanBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="<%= list%>">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.propoID}</th>			
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