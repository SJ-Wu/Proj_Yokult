<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CategoryTest.jsp</title>

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

<h2>Category 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>
<%
	CategoryService service = new CategoryService();
	List<CategoryBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>類別ID</th> <th>類別Name</th>	</tr>
	<c:forEach var="categoryBean" items="<%= list%>">
		<tr>
			<th>${categoryBean.categoryID}</th>
			<th>${categoryBean.categoryName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (91,92,93)</h4>
<%
	CategoryBean bean1 = new CategoryBean("91", "測試類別");
	CategoryBean bean2 = new CategoryBean("92", "測試類別");
	CategoryBean bean3 = new CategoryBean("93", "測試類別");
	service.insertBean(bean1);
	service.insertBean(bean2);
	service.insertBean(bean3);
	List<CategoryBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>類別ID</th> <th>類別Name</th>	</tr>
	<c:forEach var="categoryBean" items="<%= list1%>">
		<tr>
			<th>${categoryBean.categoryID}</th>
			<th>${categoryBean.categoryName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (93)</h4>
<%
	service.deleteBean("93");
	List<CategoryBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>類別ID</th> <th>類別Name</th>	</tr>
	<c:forEach var="categoryBean" items="<%= list2%>">
		<tr>
			<th>${categoryBean.categoryID}</th>
			<th>${categoryBean.categoryName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (92 -> 99)</h4>
<%
	CategoryBean bean4 = new CategoryBean("99", "測試類別(改)");
	service.updateBean("92", bean4);
	List<CategoryBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>類別ID</th> <th>類別Name</th>	</tr>
	<c:forEach var="categoryBean" items="<%= list3%>">
		<tr>
			<th>${categoryBean.categoryID}</th>
			<th>${categoryBean.categoryName}</th>
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除91,99)</h4>
<%
	service.deleteBean("91");
	service.deleteBean("99");
	List<CategoryBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>類別ID</th> <th>類別Name</th>	</tr>
	<c:forEach var="categoryBean" items="<%= list4%>">
		<tr>
			<th>${categoryBean.categoryID}</th>
			<th>${categoryBean.categoryName}</th>
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