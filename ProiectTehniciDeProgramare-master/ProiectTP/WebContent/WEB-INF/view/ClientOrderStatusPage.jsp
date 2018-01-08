<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Alarm Data</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow:700'
	rel='stylesheet' type='text/css'>

</head>

<body>

	

	<section id="content">
	
		

		<div class="tbl-header">

			<table cellpadding="0" cellspacing="0" border="0">

				<tr>
					<th>Title</th>
					<th>TimeStamp</th>
					<th>Priority</th>
					<th>Message</th>


				</tr>

			</table>
		</div>
		<div class="tbl-content">
			<table>
				<c:forEach var="tempCostumer" items="${pendingOrders}">
					
						
							<tr bgcolor="#8A0808">
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
