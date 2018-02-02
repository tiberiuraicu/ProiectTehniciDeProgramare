<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Alarm Data</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/order.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow:700'
	rel='stylesheet' type='text/css'>

</head>

<body>

	

	<section id="content">
		<div>
			<table>
				<tr>
					<th>ID</th>
					<th>Food ID</th>
					<th>Food Name</th>
					<th>Client ID</th>
					<th>Client Name</th>
					<th>Command Status</th>
					<th>Number Of Products</th>
				</tr>

			</table>
		</div>
		<div >
			<table>
				<c:forEach var="tempCostumer" items="${pendingOrders}">
					
							<tr>
							    <td>${tempCostumer.id}</td>
								<td>${tempCostumer.foodId}</td>
								<td>${tempCostumer.foodName}</td>
								<td>${tempCostumer.clientId}</td>
								<td>${tempCostumer.clientName}</td>
								<td>${tempCostumer.status}</td>
								<td>${tempCostumer.numberOfProducts}</td>
							</tr>
						
				</c:forEach>

			</table>
		</div>
	</section>


	

</body>
</html>
