<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">

<title>Admin</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Admin.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.color.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

	$(document).ready(function() {
		
		var mese = [];
		var i = 0;
		var $masa;
        var masaSelectata="";

		$('#add_obiect').click(function() {
			$('#add_masa').fadeToggle();
			$('#add_planta').fadeToggle();
		});

		$('#add_masa').click(function() {
			var masa = new Object();

			$masa = $('<img  src="${pageContext.request.contextPath}/resources/images/Av-table.png" id="masa" alt="" />');
			$('.main').append($masa);
			$masa.draggable();
			$masa.attr("id", "masa" + i);
			masa.id = "masa" + i.toString();
			var position = $($masa).position();
			masa.xCoord = position.left;
			masa.yCoord = position.top;
			masa.stare = "libera";
			mese.push(masa);


			$("img").mouseup(function() {
				masaSelectata=$(this).attr("id")
				for (i = 0; i < mese.length; i++) {
					if (mese[i].id == $(this).attr("id")) {
						
						var position = $(this).position();
						mese[i].xCoord = position.left
						mese[i].yCoord = position.top
						console.log(JSON.stringify(mese));
					}
				}
			});
			i++;
		});



		$('#salveaza_mese').click(function() {
			console.log(JSON.stringify(mese))
			$.ajax({
				url : "http://localhost:8081/ProiectTP/Administrator/salvareMese",
				type : "POST",
				data : JSON.stringify(mese),
				datatype : "application/json",
				contentType : "application/json",
				success : function(data) {
					console.log("da")
				},
				error : function(data, errorCode, errorMessage) {
					// error handling
				}
			});
		});
		
		$('#sterge_masa').click(function() {
			$("#"+masaSelectata).remove();
			for (j = 0; j < mese.length; j++) {
				if (mese[j].id == masaSelectata) {
					mese.splice(j,1)
					
				}
			}
		});
		
	});
</script>
</head>
<body>

	<div class="container">
		<div class="top_header">
			<button id="add_obiect">Adauga obiect</button>

			<button id="add_masa">Adauga masa</button>

			<button id="sterge_masa">Sterge masa</button>
		</div>

		<div class="main"></div>

		<div id="footer"></div>
		<button id="salveaza_mese">Salveaza mese</button>
	</div>

</body>
</html>