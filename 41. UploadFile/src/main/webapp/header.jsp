<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Narvar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img alt="Galaxy"
			src="image/galaxy.png">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link disabled">Disabled</a>
				</li>
			</ul>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>

				<%
				Object obj = session.getAttribute("customer");
				Customer customer = null;
				if (obj != null)
					customer = (Customer) obj;
				if (customer == null) {
				%>
				<a class="btn btn-primary" style="white-space: nowrap;"
					href="signIn.jsp">Sign in</a>
				<%
				} else {
				%>
				<div class="form-control ml-1">
					<!-- Dropdown -->
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">My account</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">My cart</a></li>
								<li><a class="dropdown-item" href="#">Notification</a></li>
								<li><a class="dropdown-item" href="changeAvatar.jsp">Avatar</a></li>
								<li><a class="dropdown-item" href="changeInfo.jsp">Info</a></li>
								<li><a class="dropdown-item" href="changePassword.jsp">Change
										password</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="cus-control?act=sign-out&">Sign out</a></li>
							</ul></li>
					</ul>
				</div>
				<%
				}
				%>
			</form>
		</div>
	</div>
</nav>
<!-- End Narvar -->