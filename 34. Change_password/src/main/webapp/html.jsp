<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion Shop</title>
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
	<!-- Narvar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img alt="Galaxy"
				src="image/galaxy.png">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
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
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
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
									<li><a class="dropdown-item" href="#">Change info</a></li>
									<li><a class="dropdown-item" href="changePassword.jsp">Change password</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="sign-out">Sign out</a></li>
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

	<!-- Page content -->
	<div class="container">
		<div class="row">
			<!-- Menu left -->
			<div class="col-lg-3">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action">Men
						fashion</a> <a href="#" class="list-group-item list-group-item-action">Women
						fashion</a> <a href="#" class="list-group-item list-group-item-action">Kid
						fashion</a>
				</div>
			</div>
			<!-- End menu left -->
			<!-- Slider and products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleCaptions" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="image/slider/Design.png" class="d-block w-100"
								alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>First slide label</h5>
								<p>Some representative placeholder content for the first
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="image/slider/Design1.png" class="d-block w-100"
								alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>Second slide label</h5>
								<p>Some representative placeholder content for the second
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="image/slider/Design2.png" class="d-block w-100"
								alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>Third slide label</h5>
								<p>Some representative placeholder content for the third
									slide.</p>
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Product -->
				<div class="row">
					<!-- Pro #1 -->
					<div class="col-lg-4 col-md-6 md-4">
						<div class="card h-100" style="width: 18rem;">
							<img src="image/product/1.png" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">White Shirt</h5>
								<p class="card-text">beautiful.</p>
								<a href="#" class="btn btn-primary">Buy now</a>
							</div>
						</div>
					</div>
					<!-- End Pro #1 -->
					<!-- Pro #2 -->
					<div class="col-lg-4 col-md-6 md-4">
						<div class="card h-100" style="width: 18rem;">
							<img src="image/product/2.png" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">Blue Suit</h5>
								<p class="card-text">beautiful.</p>
								<a href="#" class="btn btn-primary">Buy now</a>
							</div>
						</div>
					</div>
					<!-- End Pro #2 -->
					<!-- Pro #3 -->
					<div class="col-lg-4 col-md-6 md-4">
						<div class="card h-100" style="width: 18rem;">
							<img src="image/product/3.png" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">Black Suit</h5>
								<p class="card-text">beautiful.</p>
								<a href="#" class="btn btn-primary">Buy now</a>
							</div>
						</div>
					</div>
					<!-- End Pro #3 -->
				</div>
				<!-- End Product -->
			</div>
			<!-- End Slider and products -->
		</div>
	</div>
	<!-- End Page content -->
	<!-- Footer -->
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Home</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Features</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Pricing</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">FAQs</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">About</a></li>
		</ul>
		<p class="text-center text-muted">© 2022 Company, Inc</p>
	</footer>
	<!-- End Footer -->
</body>
</html>