<%@ page import="com.db.DBConnect"%>
<%@ page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	
	<div class="container p-5">
		<div class="fs-4 text-center">
			<h2>Welcome to Abhishek's Clinic Management System</h2>
			<br>Click here to register yourself<a href="signup.jsp"
				class="text-decoration-none"> Click here</a>
		</div>
	</div>

	<!-- Checking Connection  
	Connection conn = DBConnect.getConn();
	out.print(conn););
	%>
	-->
</body>
</html>