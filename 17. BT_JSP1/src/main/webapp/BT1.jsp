<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.lang.Math"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BT JSP 1</title>
</head>
<body>
	<%
	int a = 2;
	int b = 3;
	int sum = a + b;
	double sqrt = Math.sqrt(sum);
	%>
	3 + 2 =
	<%=sum%> <br>
	sqrt =
	<%=sqrt%>
</body>
</html>