<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: red">
	<%
	String username = (String) session.getAttribute("username");
	%>
	Hello, <%=username %><br>
	<h1>Welcome</h1>
	<a href="page1.jsp">Page 1</a>
	<a href="page2.jsp">Page 2</a>
	<a href="page3.jsp">Page 3</a>
</body>
</html>