<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
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
<link href="<c:url value="/view/index.css"/> rel="
	stylesheet" type="text/css">
</head>
<body>
	<!-- Navbar -->
	<%@include file="header.jsp" %>
	<!-- Navbar -->

	<!-- carousel -->
	<div id="carouselExampleCaptions" class="carousel slide carousel-fade"
		data-mdb-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-mdb-target="#carouselExampleCaptions"
				data-mdb-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-mdb-target="#carouselExampleCaptions"
				data-mdb-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-mdb-target="#carouselExampleCaptions"
				data-mdb-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%282%29.jpg"
					class="d-block w-100" alt="Wild Landscape" />
				<div class="mask" style="background-color: rgba(0, 0, 0, 0.4)"></div>
				<div class="carousel-caption d-none d-sm-block mb-5">
					<h1 class="mb-4">
						<strong>Learn Bootstrap 5 with MDB</strong>
					</h1>

					<p>
						<strong>Best & free guide of responsive web design</strong>
					</p>

					<p class="mb-4 d-none d-md-block">
						<strong>The most comprehensive tutorial for the Bootstrap
							5. Loved by over 3 000 000 users. Video and written versions
							available. Create your own, stunning website.</strong>
					</p>

					<a target="_blank"
						href="https://mdbootstrap.com/education/bootstrap/"
						class="btn btn-outline-white btn-lg">Start free tutorial <i
						class="fas fa-graduation-cap ms-2"></i>
					</a>
				</div>
			</div>

			<div class="carousel-item">
				<img
					src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%285%29.jpg"
					class="d-block w-100" alt="Exotic Fruits" />
				<div class="mask" style="background-color: rgba(0, 0, 0, 0.4)"></div>
				<div class="carousel-caption d-none d-md-block mb-5">
					<h1 class="mb-4">
						<strong>Learn Bootstrap 5 with MDB</strong>
					</h1>

					<p>
						<strong>Best & free guide of responsive web design</strong>
					</p>

					<p class="mb-4 d-none d-md-block">
						<strong>The most comprehensive tutorial for the Bootstrap
							5. Loved by over 3 000 000 users. Video and written versions
							available. Create your own, stunning website.</strong>
					</p>

					<a target="_blank"
						href="https://mdbootstrap.com/education/bootstrap/"
						class="btn btn-outline-white btn-lg">Start free tutorial <i
						class="fas fa-graduation-cap ms-2"></i>
					</a>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-mdb-target="#carouselExampleCaptions" data-mdb-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-mdb-target="#carouselExampleCaptions" data-mdb-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!--Main layout-->
	<main>
		<div class="container">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2"
				style="background-color: #607D8B">
				<!-- Container wrapper -->
				<div class="container-fluid">

					<!-- Navbar brand -->
					<a class="navbar-brand" href="#">Categories:</a>

					<!-- Toggle button -->
					<button class="navbar-toggler" type="button"
						data-mdb-toggle="collapse"
						data-mdb-target="#navbarSupportedContent2"
						aria-controls="navbarSupportedContent2" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-bars"></i>
					</button>

					<!-- Collapsible wrapper -->
					<div class="collapse navbar-collapse" id="navbarSupportedContent2">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">

							<!-- Link -->
							<li class="nav-item acitve"><a class="nav-link text-white"
								href="#">All</a></li>
							<li class="nav-item"><a class="nav-link text-white" href="#">Shirts</a>
							</li>
							<li class="nav-item"><a class="nav-link text-white" href="#">Sport
									wears</a></li>
							<li class="nav-item"><a class="nav-link text-white" href="#">Outwears</a>
							</li>

						</ul>

						<!-- Search -->
						<form class="w-auto py-1" style="max-width: 12rem">
							<input type="search" class="form-control rounded-0"
								placeholder="Search" aria-label="Search">
						</form>

					</div>
				</div>
				<!-- Container wrapper -->
			</nav>
			<!-- Navbar -->

			<!-- Products -->
			<div class="container">
				<div class="col-ms-9">
					<div class="row">
						<c:forEach items="${listP}" var="o">
							<div class="col-lg-4 col-md-6 md-4">
								<div class="card h-100" style="width: 18rem;">
									<img src="image/product/1.png" class="card-img-top"
										alt="${o.name}">
									<div class="card-body">
										<h5 class="card-title">${o.name}</h5>
										<p class="card-text">${o.title}</p>
										<p class="card-text">${o.price}</p>
										<p class="card-text">${o.description}</p>
										<a href="#" class="btn btn-primary">Buy now</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- End Products -->

			<!-- Pagination -->
			<nav aria-label="Page navigation example"
				class="d-flex justify-content-center mt-3">
				<ul class="pagination">
					<li class="page-item disabled"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">5</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
			<!-- Pagination -->
		</div>
	</main>
	<!--Main layout-->
	<!-- Footer -->
	<%@include file="footer.jsp"%>

</body>
</html>