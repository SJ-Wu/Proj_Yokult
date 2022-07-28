<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List, java.sql.*" %>
<%@ page import="static web.fundraising.common.CommonJDBC.*" %>


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
<%
	OrderService service = new OrderService();
	List<OrderBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單TimeStamp</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="<%= list%>">
		<tr>
			<th>${orderBean.orderID}</th>
			<th>${orderBean.orderInvoiceNumber}</th>
			<th>${orderBean.orderTimeStamp}</th>
			<th>${orderBean.orderAmount}</th>
			<th>${orderBean.proposalID}</th>
			<th>${orderBean.planID}</th>
			<th>${orderBean.memID}</th>
			<th>${orderBean.postID}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (TG-000091, TG-000092, TG-000093)</h4>
<%
	OrderBean bean1 = new OrderBean(
			"TG-000091", new Date(1658419200000L), 111, 112, 113, "mem0091", 114);
	OrderBean bean2 = new OrderBean(
			"TG-000092", new Date(1658505600000L), 211, 212, 213, "mem0092", 214);
	OrderBean bean3 = new OrderBean(
			"TG-000093", new Date(1658592000000L), 311, 312, 313, "mem0093", 314);
	int generatedID1 = service.insertBean(bean1).getOrderID();
	int generatedID2 = service.insertBean(bean2).getOrderID();
	int generatedID3 = service.insertBean(bean3).getOrderID();
	List<OrderBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單TimeStamp</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="<%= list1%>">
		<tr>
			<th>${orderBean.orderID}</th>
			<th>${orderBean.orderInvoiceNumber}</th>
			<th>${orderBean.orderTimeStamp}</th>
			<th>${orderBean.orderAmount}</th>
			<th>${orderBean.proposalID}</th>
			<th>${orderBean.planID}</th>
			<th>${orderBean.memID}</th>
			<th>${orderBean.postID}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (auto increment(TG-000093))</h4>
<%
	service.deleteBean(generatedID3);
	List<OrderBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單TimeStamp</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="<%= list2%>">
		<tr>
			<th>${orderBean.orderID}</th>
			<th>${orderBean.orderInvoiceNumber}</th>
			<th>${orderBean.orderTimeStamp}</th>
			<th>${orderBean.orderAmount}</th>
			<th>${orderBean.proposalID}</th>
			<th>${orderBean.planID}</th>
			<th>${orderBean.memID}</th>
			<th>${orderBean.postID}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (TG-000092 -> TG-000099)</h4>
<%
	OrderBean bean4 = new OrderBean(
			"TG-000099", new Date(1659199428000L), 911, 912, 913, "mem0099", 914);
	service.updateBean(generatedID2, bean4);
	List<OrderBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單TimeStamp</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="<%= list3%>">
		<tr>
			<th>${orderBean.orderID}</th>
			<th>${orderBean.orderInvoiceNumber}</th>
			<th>${orderBean.orderTimeStamp}</th>
			<th>${orderBean.orderAmount}</th>
			<th>${orderBean.proposalID}</th>
			<th>${orderBean.planID}</th>
			<th>${orderBean.memID}</th>
			<th>${orderBean.postID}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除TG-000091,TG-000099)</h4>

<%
	service.deleteBean(generatedID1);
	service.deleteBean(generatedID2);
	List<OrderBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>訂單ID</th> <th>訂單InvoiceNumber</th> <th>訂單TimeStamp</th> <th>訂單Amount</th> <th>提案proposalID</th>	<th>方案planID</th> <th>會員memID</th> <th>寄送postID</th></tr>
	<c:forEach var="orderBean" items="<%= list4%>">
		<tr>
			<th>${orderBean.orderID}</th>
			<th>${orderBean.orderInvoiceNumber}</th>
			<th>${orderBean.orderTimeStamp}</th>
			<th>${orderBean.orderAmount}</th>
			<th>${orderBean.proposalID}</th>
			<th>${orderBean.planID}</th>
			<th>${orderBean.memID}</th>
			<th>${orderBean.postID}</th>
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