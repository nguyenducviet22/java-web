<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>
	<%
	String fullName = request.getParameter("fullName");
	String email = request.getParameter("email");
	String quantity = request.getParameter("quantity");
	int quantityProducts = 1;
	try {
		quantityProducts = Integer.parseInt(quantity);
	} catch (Exception e) {

	}
	%>
	<p>
		Thank you, <b><%=fullName%></b> has ordered <b><%=quantityProducts%></b>
		products. <br /> The total of money is: <b><%=quantityProducts * 5%>$</b>
		<br>You will receive the information of products through email: <b><%=email%></b>
	</p>

</body>
</html>