<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Customer info</title>
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

	String fullName = customer.getFullName();

	String gender = customer.getGender();

	String dateOfBirth = customer.getDateOfBirth().toString();

	String address = customer.getAddress();

	String receivedAddress = customer.getReceivedAddress();

	String phoneNumber = customer.getPhoneNumber();

	String email = customer.getEmail();
	%>
	<div class="container">
		<div class="red" id="error">
			<%=error%>
		</div>
		<form class="form" action="cus-control" method="post">
		<input type="hidden" name="act" value="change-info">
			<div class="row">
				<div class="col-md-6">
					<h3>Customer info</h3>
					<!-- Full name -->
					<div class="mb-3">
						<label for="fullName" class="form-label">Full name</label> <input
							type="text" class="form-control" id="fullName" name="fullName"
							required="required" value="<%=fullName%>">
					</div>
					<!-- Gender -->
					<div class="mb-3">
						<label for="gender" class="form-label">Gender</label> <select
							class="form-control" id="gender" name="gender">
							<option></option>
							<option value="Male"
								<%=(gender.equals("Male")) ? "selected='selected'" : ""%>>Male</option>
							<option value="Female"
								<%=(gender.equals("Female")) ? "selected='selected'" : ""%>>Female</option>
							<option value="Other"
								<%=(gender.equals("Other")) ? "selected='selected'" : ""%>>Other</option>
						</select>
					</div>
					<!-- Date of birth -->
					<div class="mb-3">
						<label for="dateOfBirth" class="form-label">Date of birth</label>
						<input type="date" class="form-control" id="dateOfBirth"
							name="dateOfBirth" required="required" value="<%=dateOfBirth%>">
					</div>
				</div>
				<div class="col-md-6">
					<h3>Address</h3>
					<!-- Address -->
					<div class="mb-3">
						<label for="address" class="form-label">Address</label> <input
							type="text" class="form-control" id="address" name="address"
							required="required" value="<%=address%>">
					</div>
					<!-- Received address -->
					<div class="mb-3">
						<label for="receivedAddress" class="form-label">Received
							address</label> <input type="text" class="form-control"
							id="receivedAddress" name="receivedAddress" required="required"
							value="<%=receivedAddress%>">
					</div>
					<!-- Phone numbers -->
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Phone number</label> <input
							type="tel" class="form-control" id="phoneNumber"
							name="phoneNumber" required="required" value="<%=phoneNumber%>">
					</div>
					<!-- Email -->
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							required="required" value="<%=email%>">
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
</body>
</html>