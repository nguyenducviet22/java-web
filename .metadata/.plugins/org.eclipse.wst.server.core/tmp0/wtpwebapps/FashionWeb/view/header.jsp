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
	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
		<!-- Container wrapper -->
		<div class="container">
			<!-- Toggle button -->
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse"
				data-mdb-target="#navbarSupportedContent1"
				aria-controls="navbarSupportedContent1" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>

			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent1">
				<!-- Navbar brand -->
				<a class="navbar-brand mt-2 mt-sm-0" href="https://mdbootstrap.com/">
					<img
					src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
					height="20" alt="MDB Logo" loading="lazy" />
				</a>
				<!-- Left links -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item active"><a class="nav-link "
						href="https://mdbootstrap.com/">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://mdbootstrap.com/docs/standard/">About MDB</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://mdbootstrap.com/docs/standard/getting-started/installation/">Free
							download</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://mdbootstrap.com/education/bootstrap/">Free
							tutorials</a></li>
				</ul>
				<!-- Left links -->
			</div>
			<!-- Collapsible wrapper -->

			<!-- Right elements -->
			<div class="d-flex align-items-center">
				<!-- Icon -->
				<a class="nav-link me-3" href="#"> <i
					class="fas fa-shopping-cart"></i> <span
					class="badge rounded-pill badge-notification bg-danger">1</span>
				</a> <a class="nav-link me-3" href="#"> <i class="fab fa-facebook-f"></i>
				</a> <a class="nav-link me-3" href="#"> <i class="fab fa-twitter"></i>
				</a> <a href="https://github.com/mdbootstrap/bootstrap-material-design"
					class="border rounded px-2 nav-link" target="_blank"> <i
					class="fab fa-github me-2"></i>MDB GitHub
				</a>
			</div>
			<!-- Right elements -->

		</div>
		<!-- Container wrapper -->
	</nav>
	<!-- Navbar -->