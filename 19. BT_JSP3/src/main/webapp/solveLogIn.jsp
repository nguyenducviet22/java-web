<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Solve Log In</title>
</head>
<body>
	<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	%>
	<%
	if(userName.equalsIgnoreCase("viet")&&password.equals("123")) {
	%>
	<h1>You have logged in successfully</h1>
	<%
	} else {
	%>
	<h1>You have not logged in successfully</h1>
	<%
	}
	%>
</body>
</html>