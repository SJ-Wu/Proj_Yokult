<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StatusTest.jsp</title>

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

<h2>Status 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>
<%
	StatusService service = new StatusService();
	List<StatusBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>階段ID</th> <th>階段Name</th>	</tr>
	<c:forEach var="statusBean" items="<%= list%>">
		<tr>
			<th>${statusBean.statusID}</th>
			<th>${statusBean.statusName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (91,92,93)</h4>
<%
	StatusBean bean1 = new StatusBean("91", "測試階段");
	StatusBean bean2 = new StatusBean("92", "測試階段");
	StatusBean bean3 = new StatusBean("93", "測試階段");
	service.insertBean(bean1);
	service.insertBean(bean2);
	service.insertBean(bean3);
	List<StatusBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>階段ID</th> <th>階段Name</th>	</tr>
	<c:forEach var="statusBean" items="<%= list1%>">
		<tr>
			<th>${statusBean.statusID}</th>
			<th>${statusBean.statusName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (93)</h4>
<%
	service.deleteBean("93");
	List<StatusBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>階段ID</th> <th>階段Name</th>	</tr>
	<c:forEach var="statusBean" items="<%= list2%>">
		<tr>
			<th>${statusBean.statusID}</th>
			<th>${statusBean.statusName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (92 -> 99)</h4>
<%
	StatusBean bean4 = new StatusBean("99", "測試階段(改)");
	service.updateBean("92", bean4);
	List<StatusBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>階段ID</th> <th>階段Name</th>	</tr>
	<c:forEach var="statusBean" items="<%= list3%>">
		<tr>
			<th>${statusBean.statusID}</th>
			<th>${statusBean.statusName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除91,99)</h4>
<%
	service.deleteBean("91");
	service.deleteBean("99");
	List<StatusBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>階段ID</th> <th>階段Name</th>	</tr>
	<c:forEach var="statusBean" items="<%= list4%>">
		<tr>
			<th>${statusBean.statusID}</th>
			<th>${statusBean.statusName}</th>
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