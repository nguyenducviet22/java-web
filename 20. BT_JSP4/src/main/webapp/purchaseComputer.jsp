<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Computer</title>
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
	<%
	double total = 0;
	//radio
	String processor = request.getParameter("processor");
	double processorPrice = 0;
	if (processor != null) {
		if (processor.equals("Core i9")) {
			processorPrice = 5000000;
		} else if (processor.equals("Core i7")) {
			processorPrice = 4000000;
		} else if (processor.equals("Core i5")) {
			processorPrice = 3000000;
		} else if (processor.equals("Core i3")) {
			processorPrice = 2000000;
		}
		total += processorPrice;
	}

	//radio
	String ram = request.getParameter("ram");
	double ramPrice = 0;
	if (ram != null) {
		if (ram.equals("RAM 8G")) {
			ramPrice = 2000000;
		} else if (ram.equals("RAM 16G")) {
			ramPrice = 3000000;
		} else if (ram.equals("RAM 32G")) {
			ramPrice = 4000000;
		} else if (ram.equals("RAM 64G")) {
			ramPrice = 5000000;
		}
		total += ramPrice;
	}

	//checkbox
	String monitor = request.getParameter("monitor");
	double monitorPrice = 0;
	if (monitor != null) {
		monitorPrice = 5000000;
	}
	total += monitorPrice;

	//select
	String[] accessories = request.getParameterValues("accessories");
	double accessoriesPrice = 0;
	if (accessories != null)
		for (String choose : accessories) {
			if (choose.equals("Camera")) {
		accessoriesPrice = 1000000;
			} else if (choose.equals("Printer")) {
		accessoriesPrice = 1500000;
			} else if (choose.equals("Scanner")) {
		accessoriesPrice = 1200000;
			}
			total += accessoriesPrice;
		}
	%>

	<h1>Bill</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name of product</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (processor != null) {
			%>
			<tr>
				<td><%=processor%></td>
				<td><%=processorPrice%></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tbody>
			<%
			if (ram != null) {
			%>
			<tr>
				<td><%=ram%></td>
				<td><%=ramPrice%></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tbody>
			<%
			if (monitor != null) {
			%>
			<tr>
				<td><%=monitor%></td>
				<td><%=monitorPrice%></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tbody>
			<%
			if (accessories != null) {
				for (String choose : accessories) {
			%>
			<tr>
				<td><%=choose%></td>
				<td><%=accessoriesPrice%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
		<tbody>
			<tr>
				<td>Total</td>
				<td><b><%=total%></b></td>
			</tr>
		</tbody>
	</table>
</body>
</html>