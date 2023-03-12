<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
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
<style>
.rq {
	color: red;
}
</style>
<script>
	function mySubmit() {
		//catch error
		error = "";
		productCode = document.getElementById("productCode").value;
		sellingPrice = document.getElementById("sellingPrice").value;

		if (productCode.length == 0) {
			alert("You must enter product code");
		}
		if (sellingPrice <= 0) {
			error_sellingPrice = document.getElementById("error_sellingPrice");
			error_sellingPrice.innerHTML = "<span class='rq'>Enter</span>";
		} else {
			//submit
			myForm = document.getElementById("myForm");
			myForm.submit();
		}
	}
</script>
</head>
<body>
	<%
	String e_productCode = request.getAttribute("e_productCode") + "";
	if (e_productCode == null || e_productCode.equals("null")) {
		e_productCode = "";
	}

	// (2)keeping values have been entered into boxes
	String value_productCode = request.getAttribute("value_productCode") + "";
	String value_nameOfProduct = request.getAttribute("value_nameOfProduct") + "";
	String value_inputPrice = request.getAttribute("value_inputPrice") + "";
	String value_sellingPrice = request.getAttribute("value_sellingPrice") + "";
	String value_dateTime = request.getAttribute("value_dateTime") + "";
	String value_vat = request.getAttribute("value_vat") + "";
	String value_description = request.getAttribute("value_description") + "";

	// to eliminate null in writing box
	value_productCode = (value_productCode.equals("null")) ? "" : value_productCode;
	value_nameOfProduct = (value_nameOfProduct.equals("null")) ? "" : value_nameOfProduct;
	value_inputPrice = (value_inputPrice.equals("null")) ? "" : value_inputPrice;
	value_sellingPrice = (value_sellingPrice.equals("null")) ? "" : value_sellingPrice;
	value_dateTime = (value_dateTime.equals("null")) ? "" : value_dateTime;
	value_vat = (value_vat.equals("null")) ? "" : value_vat;
	value_description = (value_description.equals("null")) ? "" : value_description;
	%>
	<div class="container mt-4">
		<form class="row g-3 needs-validation" action="save-product"
			id="myForm">
			<div class="row">
				<div class="col-6">
					<label for="productCode" class="form-label">Product Code <span
						class="rq">*</span></label> <input type="text" class="form-control"
						id="productCode" name="productCode" value="<%=value_productCode%>"
						required> <!-- (3)keeping values have entered into boxes -->
					<div class="rq"><%=e_productCode%></div>
				</div>
				<div class="col-6">
					<label for="nameOfProduct" class="form-label">Name of
						product<span class="rq">*</span>
					</label> <input type="text" class="form-control" id="nameOfProduct"
						name="nameOfProduct" value="<%=value_nameOfProduct%>" required>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputPrice" class="form-label">Input Price<span
						class="rq">*</span>
					</label> <input type="number" step="0.01" class="form-control"
						id="inputPrice" name="inputPrice" value="<%=value_inputPrice%>"
						required>
				</div>
				<div class="col-6">
					<label for="sellingPrice" class="form-label">Selling Price<span
						class="rq">*</span>
					</label> <input type="number" step="0.01" class="form-control"
						id="sellingPrice" name="sellingPrice"
						value="<%=value_sellingPrice%>" required>
					<div id="error_sellingPrice"></div>
				</div>

			</div>
			<div class="row">
				<div class="col-6">
					<label for="dateTime" class="form-label">Date Time </label> <input
						type="datetime-local" class="form-control" id="dateTime"
						name="dateTime" value="<%=value_dateTime%>">
				</div>
				<div class="col-6">
					<label for="vat" class="form-label">VAT </label> <input
						type="number" step="0.01" class="form-control" id="vat" name="vat"
						value="<%=value_vat%>">
				</div>
			</div>
			<div class="col-12">
				<label for="description" class="form-label">Description </label>
				<textarea rows="10" cols="20" class="form-control" id="description"
					name="description"><%=value_description%></textarea>
			</div>
			<div class="col-12">
				<button class="btn btn-primary" type="button" onclick="mySubmit()">Save</button>
			</div>
		</form>
	</div>
</body>
</html>