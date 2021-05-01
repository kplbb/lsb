<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
	font: poppins;
	}
body{
	width:100%;
}
#logo {
	width: 100%;
	margin:  0;
	color: black;
}
</style>
<head>
<meta charset="UTF-8">
<title>Lsb Admin</title>
<!-- <link rel="stylesheet" href="admin/css/admin.css"> -->
<script type="text/javascript" src="admin/product/product.js"></script>
<c:choose>
	<c:when test="${empty workerId}">
		<script type="text/javascript">
			location.href = 'LsbServlet?command=admin_login_form';
		</script>
	</c:when>
</c:choose>
</head>
<body onload="go_ab()">
	<div id="wrap">
		<header style="width:100%; background-color: black;">			
			<div id="logo">
				<a href="LsbServlet?command=admin_login_form"> 
					<img style="width:50%; margin-bottom:0px;"src="admin/images/LSB_admin_banner.JPG">
<!-- 					<img src="admin/images/admin.jpg"> -->
				</a>
			</div>	
<!-- 			<input class="btn" type="button"  value="logout"  style="float: right;" -->
<!-- 			   onClick="location.href='LsbServlet?command=admin_logout'">			 -->
		</header>
 		<div class="clear"></div>