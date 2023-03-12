<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Register</title>
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
	String error = request.getAttribute("error") + "";
	error = (error.equals("null")) ? "" : error;

	String username = request.getAttribute("username") + "";
	username = (username.equals("null")) ? "" : username;

	String fullName = request.getAttribute("fullName") + "";
	fullName = (fullName.equals("null")) ? "" : fullName;

	String gender = request.getAttribute("gender") + "";
	gender = (gender.equals("null")) ? "" : gender;

	String dateOfBirth = request.getAttribute("dateOfBirth") + "";
	dateOfBirth = (dateOfBirth.equals("null")) ? "" : dateOfBirth;

	String address = request.getAttribute("address") + "";
	address = (address.equals("null")) ? "" : address;

	String receivedAddress = request.getAttribute("receivedAddress") + "";
	receivedAddress = (receivedAddress.equals("null")) ? "" : receivedAddress;

	String phoneNumber = request.getAttribute("phoneNumber") + "";
	phoneNumber = (phoneNumber.equals("null")) ? "" : phoneNumber;

	String email = request.getAttribute("email") + "";
	email = (email.equals("null")) ? "" : email;
	%>
	<div class="container">
		<div class="text-center">
			<h1>Register</h1>
		</div>
		<div class="red" id="error">
			<%=error%>
		</div>
		<form class="form" action="cus-control" method="post">
		<input type="hidden" name="act" value="register">
			<div class="row">
				<div class="col-md-6">
					<h3>Account</h3>
					<!-- Username -->
					<div class="mb-3">
						<label for="username" class="form-label">Username<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="username" name="username" required="required"
							value="<%=username%>">
					</div>
					<!-- Password -->
					<div class="mb-3">
						<label for="password" class="form-label">Password</label><span
							class="red">*</span> <input type="password" class="form-control"
							id="password" name="password" required="required"
							onkeyup="checkPassword()">
					</div>
					<!-- Reenter Password -->
					<div class="mb-3">
						<label for="reenteredPassword" class="form-label">Reenter
							Password</label><span id="red">*</span><span id="msg" class="red">*</span>
						<input type="password" class="form-control" id="reenteredPassword"
							name="reenteredPassword" onkeyup="checkPassword()">
					</div>
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
					<!-- Agree -->
					<div class="mb-3 form-check">
						<label class="form-check-label" for="agree">I agree</label><span
							class="red">*</span> <input type="checkbox"
							class="form-check-input" id="agree" name="agree"
							required="required" onchange="clickAgree()">
					</div>
				</div>
				<button type="submit" value="Submit" class="btn btn-primary"
					id="submit" name="submit" style="visibility: hidden;">Submit</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	function checkPassword() {
		password = document.getElementById("password").value;
		reenteredPassword = document.getElementById("reenteredPassword").value;
		if (password != reenteredPassword) {
			document.getElementById("msg").innerHTML = " The passwords you entered do not match";
			return false;
		} else
			document.getElementById("msg").innerHTML = "";
			return true;
	}

	function clickAgree() {
		agree = document.getElementById("agree");
		if (agree.checked == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else
			document.getElementById("submit").style.visibility = "hidden";
	}
</script>
</html>