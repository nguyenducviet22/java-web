<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Avatar</title>
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
<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
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
	%>
	<%
	String error = request.getAttribute("error") + "";
	error = (error.equals("null")) ? "" : error;

	String linkAvatar = customer.getLinkAvatar();
	%>
	<div class="container">
		<div class="red" id="error">
			<%=error%>
		</div>
		<form class="form" action="cus-change-avatar" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-6">
					<h3>Avatar</h3>
					<!-- Avatar image -->
					<img alt="Avatar" src="/avatar/<%=linkAvatar%>" width="200">
					<div class="mb-3">
						<label for="linkAvatar" class="form-label">Link avatar</label> <input
							type="file" class="form-control" id="linkAvatar"
							name="linkAvatar">
					</div>
				</div>
				<button type="submit" value="Save" class="btn btn-primary" id="save"
					name="save">Save</button>
			</div>
		</form>
	</div>
	<%
	}
	%>
	<!-- Footer -->
	<%@include file="footer.jsp"%>
</body>
</html>