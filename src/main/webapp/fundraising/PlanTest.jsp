<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List, java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderTest.jsp</title>

<style>
  table {
    border: 2px solid black;
    text-align: center;
    padding: 5px;
  }
  th {
    border-left: 1px solid black;
    text-align: center;

  }
  th {
    border-bottom: 2px solid black;
    text-align: center;
        margin-left: 5px;
  }
</style>

</head>
<body>

<h2>Plan 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>

<table>
	<tr> <th>募資方案ID</th> <th>方案名稱Name</th> <th>目標金額Amount</th> <th>方案內容Content</th> <th>寄送備註PostNote</th> <th>開始時間StartedDate</th> <th>結束時間EndedDate</th> <th>募資階段statusID</th> <th>募資提案propoID</th> </tr>
	<c:forEach var="planBean" items="${list_Plan}">
		<tr>
			<th>${planBean.planID}</th>
			<th>${planBean.planName}</th>
			<th>${planBean.planAmount}</th>
			<th>${planBean.planContent}</th>
			<th>${planBean.planPostNote}</th>
			<th>${planBean.planStartedDate}</th>
			<th>${planBean.planEndedDate}</th>
			<th>${planBean.statusID}</th>
			<th>${planBean.proposalID}</th>
		</tr>
	</c:forEach>
</table>

</body>

</html>