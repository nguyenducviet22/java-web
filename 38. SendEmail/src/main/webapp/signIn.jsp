<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-in</title>
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
<style type="text/css">
.red {
	color: red;
}
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<%
	String error = request.getAttribute("error") + "";
	error = (error.equals("null")) ? "" : error;

	String username = request.getAttribute("username") + "";
	username = (username.equals("null")) ? "" : username;
	%>
	<div class="container">
		<form action="cus-control" method="post">
			<input type="hidden" name="act" value="sign-in">
			<div class="text-center">
				<h1>Sign-in</h1>
			</div>
			<%
			//String error = request.getAttribute("error") + "";
			if (error.equals("null")) {
				error = "";
			}
			%>
			<div class="text-center">
				<span class="red"><%=error%></span>
			</div>
			<div>
				<!-- Username -->
				<div class="mb-3">
					<label for="username" class="form-label">Username</label> <input
						type="text" class="form-control" id="username" name="username"
						required="required" placeholder="Enter username"
						value="<%=username%>">
				</div>
				<!-- Password -->
				<div class="mb-3">
					<label for="password" class="form-label">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						required="required" placeholder="Enter password">
				</div>
				<!-- Remember me -->
				<div class="mb-3 form-check">
					<label class="form-check-label" for="rememberMe">Remember
						me</label><input type="checkbox" class="form-check-input" id="rememberMe"
						name="rememberMe">

				</div>
				<div class="text-center">
					<button type="submit" value="Sign-in" class="btn btn-primary"
						id=signIn name="signIn">Sign-in</button>
				</div>
				<div class="text-center">
					<a href="register.jsp">Register new account</a>
				</div>
			</div>
		</form>
	</div>
	<!-- Footer -->
	<%@include file="footer.jsp"%>
</body>
</html>