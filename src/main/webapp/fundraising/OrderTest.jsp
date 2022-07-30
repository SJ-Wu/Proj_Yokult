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

<h2>Order 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>

<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單DateTime</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="${list_Order}">
		<tr>
			<th>${orderBean.getOrderID()}</th>
			<th>${orderBean.getOrderInvoiceNumber()}</th>
			<th>${orderBean.getOrderDateTime()}</th>
			<th>${orderBean.getOrderAmount()}</th>
			<th>${orderBean.getProposalID()}</th>
			<th>${orderBean.getPlanID()}</th>
			<th>${orderBean.getMemID()}</th>
			<th>${orderBean.getPostID()}</th>
		</tr>
	</c:forEach>
</table>

</body>

</html>