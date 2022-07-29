<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CategoryTest.jsp</title>

</head>
<body>
<%
	request.setAttribute("session", request.getAttribute("session"));
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	//System.out.println(path);
%>
<h2>Fundraising Index | 募資model & SQL測試頁面</h2>
<hr>
<table>
	<thead>
		<th>model名稱</th> <td>｜</td> <th>執行測試</th>
	</thead>
	
	<tbody>
		<td>募資類別（Category）</td>
		<td>：</td>
		<th>
			<a href="<%= path%>/fundraising/CategoryTest.jsp">
				<input type="button" value="測試"></input>
			</a>
		</th>
	</tbody>
		<tbody>
		<td>訂單（Order）</td>
		<td>：</td>
		<th>
			<a href="<%= path%>/fundraising/OrderTest.jsp">
				<input type="button" value="測試"></input>
			</a>
		</th>
	</tbody>
	
	<tbody>
		<td>募資方案（Plan）</td>
		<td>：</td>
		<th>
			<a href="<%= path%>/fundraising/PlanTest.jsp">
				<input type="button" value="測試"></input>
			</a>
		</th>
	</tbody>
		
	<tbody>
		<td>募資階段（Status）</td>
		<td>：</td>
		<th>
			<a href="<%= path%>/fundraising/StatusTest.jsp">
				<input type="button" value="測試"></input>
			</a>
		</th>
	</tbody>
			
	<tbody>
		<td>寄送資訊（Post）</td>
		<td>：</td>
		<th>
			<a href="<%= path%>/fundraising/PostTest.jsp">
				<input type="button" value="測試"></input>
			</a>
		</th>
	</tbody>
		
</table>

</body>

</html>