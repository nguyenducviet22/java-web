<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Computer</title>
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
	<div class="container">
		<form action="purchaseComputer.jsp">
			<h1>Choose the processor</h1>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei9" value="Core i9"> <label
					class="form-check-label" for="corei9"> Core i9 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei7" value="Core i7"> <label
					class="form-check-label" for="corei7"> Core i7 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei5" value="Core i5"> <label
					class="form-check-label" for="corei5"> Core i5 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei3" value="Core i3"> <label
					class="form-check-label" for="corei3"> Core i3 </label>
			</div>

			<h1>Choose the RAM</h1>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="ram8g"
					value="RAM 8G"> <label class="form-check-label" for="ram8g">
					RAM 8G </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="ram16g"
					value="RAM 16G"> <label class="form-check-label"
					for="ram16g"> RAM 16G </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="ram32g"
					value="RAM 32G"> <label class="form-check-label"
					for="ram32g"> RAM 32G </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="ram64g"
					value="RAM 64G"> <label class="form-check-label"
					for="ram64g"> RAM 64G </label>
			</div>
			<h1>Monitor</h1>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="Monitor"
					id="monitor" name="monitor"> <label
					class="form-check-label" for="monitor"> Monitor </label>
			</div>
			<h1>Accessories</h1>
			<select class="form-select" multiple
				aria-label="multiple select example" name="accessories">
				<option value="Camera">Camera</option>
				<option value="Printer">Printer</option>
				<option value="Scanner">Scanner</option>
			</select>
			<button class="btn btn-primary mt-2" type="submit">Purchase</button>
		</form>
	</div>

</body>
</html>