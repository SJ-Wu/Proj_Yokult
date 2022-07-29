<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.fundraising.vo.*, web.fundraising.service.*, web.fundraising.dao.*"%>
<%@ page import="web.fundraising.controller.SessionSaver"%>
<%@ page import="java.util.List, java.sql.*, org.hibernate.Session" %>
<%@ page import="static web.fundraising.common.CommonJDBC.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostTest.jsp</title>

<style>
  table {
    bpost: 2px solid black;
    text-align: center;
    padding: 5px;
  }
  th {
    bpost-left: 1px solid black;
    text-align: center;

  }
  th {
    bpost-bottom: 2px solid black;
    text-align: center;
        margin-left: 5px;
  }
</style>

</head>
<body>

<h2>Post 測試頁面</h2>

<!-- ------------------------------------------------------------ -->
<h4>這是原表</h4>
<%
	//Session currentSession = (Session)request.getAttribute("session");
	PostService service = new PostService(SessionSaver.getSession());
	List<PostBean> list = service.selectAllBeans();
%>
<table>
	<tr> <th>寄送資訊ID</th> <th>名字FirstName</th> <th>姓氏LastName</th> <th>手機號碼Cellphone</th> <th>城市City</th> <th>區域District</th> <th>地址Address</th> <th>會員帳號MemID</th> </tr>
	<c:forEach var="postBean" items="<%= list%>">
		<tr>
			<th>${postBean.postID}</th>
			<th>${postBean.postFisrtName}</th>
			<th>${postBean.postLastName}</th>
			<th>${postBean.postCellphone}</th>
			<th>${postBean.cityName}</th>
			<th>${postBean.districtName}</th>
			<th>${postBean.postAddress}</th>
			<th>${postBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是新增 (三筆，名字: 政瑋1, 政瑋2, 政瑋3)</h4>
<%
PostBean bean1 = new PostBean(
		"政瑋1", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_91");
PostBean bean2 = new PostBean(
		"政瑋2", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_92");
PostBean bean3 = new PostBean(
		"政瑋3", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_93");
	int generatedID1 = service.insertBean(bean1).getPostID();
	int generatedID2 = service.insertBean(bean2).getPostID();
	int generatedID3 = service.insertBean(bean3).getPostID();
	List<PostBean> list1 = service.selectAllBeans();
%>
<table>
	<tr> <th>寄送資訊ID</th> <th>名字FirstName</th> <th>姓氏LastName</th> <th>手機號碼Cellphone</th> <th>城市City</th> <th>區域District</th> <th>地址Address</th> <th>會員帳號MemID</th> </tr>
	<c:forEach var="postBean" items="<%= list%>">
		<tr>
			<th>${postBean.postID}</th>
			<th>${postBean.postFisrtName}</th>
			<th>${postBean.postLastName}</th>
			<th>${postBean.postCellphone}</th>
			<th>${postBean.cityName}</th>
			<th>${postBean.districtName}</th>
			<th>${postBean.postAddress}</th>
			<th>${postBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是刪除 (名字： 政瑋3)</h4>
<%
	service.deleteBean(generatedID3);
	List<PostBean> list2 = service.selectAllBeans();
%>
<table>
	<tr> <th>寄送資訊ID</th> <th>名字FirstName</th> <th>姓氏LastName</th> <th>手機號碼Cellphone</th> <th>城市City</th> <th>區域District</th> <th>地址Address</th> <th>會員帳號MemID</th> </tr>
	<c:forEach var="postBean" items="<%= list%>">
		<tr>
			<th>${postBean.postID}</th>
			<th>${postBean.postFisrtName}</th>
			<th>${postBean.postLastName}</th>
			<th>${postBean.postCellphone}</th>
			<th>${postBean.cityName}</th>
			<th>${postBean.districtName}</th>
			<th>${postBean.postAddress}</th>
			<th>${postBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是更新 (名字： 政瑋2 -> 政瑋4)</h4>
<%
	PostBean bean4 = new PostBean(
			"政瑋4", "陳", "0939676595", "新北市", "新店區", "OO路XX號", "test_account_93");
	service.updateBean(generatedID2, bean4);
	List<PostBean> list3 = service.selectAllBeans();
%>
<table>
	<tr> <th>寄送資訊ID</th> <th>名字FirstName</th> <th>姓氏LastName</th> <th>手機號碼Cellphone</th> <th>城市City</th> <th>區域District</th> <th>地址Address</th> <th>會員帳號MemID</th> </tr>
	<c:forEach var="postBean" items="<%= list%>">
		<tr>
			<th>${postBean.postID}</th>
			<th>${postBean.postFisrtName}</th>
			<th>${postBean.postLastName}</th>
			<th>${postBean.postCellphone}</th>
			<th>${postBean.cityName}</th>
			<th>${postBean.districtName}</th>
			<th>${postBean.postAddress}</th>
			<th>${postBean.memID}</th>	
		</tr>
	</c:forEach>
</table>

<!-- ------------------------------------------------------------ -->
<h4>這是復原 (刪除兩筆，名字： 政瑋2、政瑋4)</h4>

<%
	service.deleteBean(generatedID1);
	service.deleteBean(generatedID2);
	List<PostBean> list4 = service.selectAllBeans();
%>
<table>
	<tr> <th>寄送資訊ID</th> <th>名字FirstName</th> <th>姓氏LastName</th> <th>手機號碼Cellphone</th> <th>城市City</th> <th>區域District</th> <th>地址Address</th> <th>會員帳號MemID</th> </tr>
	<c:forEach var="postBean" items="<%= list%>">
		<tr>
			<th>${postBean.postID}</th>
			<th>${postBean.postFisrtName}</th>
			<th>${postBean.postLastName}</th>
			<th>${postBean.postCellphone}</th>
			<th>${postBean.cityName}</th>
			<th>${postBean.districtName}</th>
			<th>${postBean.postAddress}</th>
			<th>${postBean.memID}</th>	
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