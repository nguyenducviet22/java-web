<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
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
</head>
<style type="text/css">
.red {
	color: red;
}
</style>
<body>

	<%
	Object obj = session.getAttribute("customer");
	Customer customer = null;
	if (obj != null)
		customer = (Customer) obj;
	if (customer == null) {
	%>
	<h3>You need to sign in the system first.</h3>
	<div class="text-center">
		<a href="signIn.jsp">Sign-in</a>
	</div>
	<%
	} else {
	String error = request.getAttribute("error") + "";
	if (error.equals("null")) {
		error = "";
	}
	%>
	<div class="container">
		<form class="form" action="change-password" method="post">
			<div class="text-center">
				<h1>Change password</h1>
			</div>
			<div class="text-center">
				<span class="red"> <%=error%>
				</span>
			</div>
			<!-- Old password -->
			<div class="mb-3">
				<label for="oldPassword" class="form-label">Enter old
					password</label> <input type="password" class="form-control"
					id="oldPassword" name="oldPassword" required="required"
					placeholder="Enter old password">
			</div>
			<!-- New password1 -->
			<div class="mb-3">
				<label for="newPassword" class="form-label">Enter new
					password</label> <input type="password" class="form-control"
					id="newPassword" name="newPassword" required="required"
					placeholder="Enter new password">
			</div>
			<!-- New password2 -->
			<div class="mb-3">
				<label for="newRepassword" class="form-label">Re-enter new
					password</label> <input type="password" class="form-control"
					id="newRepassword" name="newRepassword" required="required"
					placeholder="Re-enter new password">
			</div>
			<div class="text-center">
				<button type="submit" value="Sign-in" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
	<%
	}
	%>
</body>
</html>