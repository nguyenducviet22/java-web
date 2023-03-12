<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<style>
.rq {
	color: red;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<%
		String e_quantity = request.getAttribute("e_quantity") + "";
		String e_phoneNumbers = request.getAttribute("e_phoneNumbers") + "";
		String e_email = request.getAttribute("e_email") + "";

		e_quantity = (e_quantity.equals("null")) ? "" : e_quantity;
		e_phoneNumbers = (e_phoneNumbers.equals("null")) ? "" : e_phoneNumbers;
		e_email = (e_email.equals("null")) ? "" : e_email;
		%>
		<form action="buy-product" method="get">
			Quantity: <input class="form-control" type="text" name="quantity"
				required="required"> <span class="rq"><%=e_quantity%></span><br>
			Phone numbers: <input class="form-control" type="text"
				name="phoneNumbers" required="required"> <span class="rq"><%=e_phoneNumbers%></span><br>
			Email: <input class="form-control" type="text" name="email"
				required="required"> <span class="rq"><%=e_email%></span><br>
			<input class="form-control" type="submit" value="Buy">
		</form>
	</div>

</body>
</html>