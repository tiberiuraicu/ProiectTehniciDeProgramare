<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>User</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.color.js"></script>
	<script>
		$(document).ready(function(){
				$('#bars').click(function(){
					$('#right-bar').slideToggle();
				});

				$('#select1').click(function(){
					$('#div-sel2').fadeOut();
					$('#div-sel3').fadeOut();
					$('#div-sel1').fadeToggle();
					$('#right-bar').slideUp();
					$('#grey-bck').fadeIn();
				});

				$('#btn1').click(function(){
					$('#div-sel1').fadeOut();
				});

				$('#select2').click(function(){
					$('#div-sel1').fadeOut();
					$('#div-sel3').fadeOut();
					$('#div-sel2').fadeToggle();
					
				});

				$('#select3').click(function(){
					$('#div-sel2').fadeOut();
					$('#div-sel1').fadeOut();
					$('#div-sel3').fadeToggle();
					
				});

				$('#ex-bttn').click(function(){
					$('#div-sel1').fadeOut();
					$('#grey-bck').fadeOut();
				});


		 });	
	</script>
</head>
<body>
	<div class="container">
	<header>
			<div class="top_header">
				<img id="bars" src="${pageContext.request.contextPath}/resources/images/3bars.png" alt="">
				<button>Log out</button>
			</div>
			<img src="${pageContext.request.contextPath}/resources/images/img3.png" class = "user">
	</header>
	<section id="left-section">
			<div id="right-bar">
				<ul id="lista">
					<a href="#"><li>Meniu</li></a>
					<a href="#"><li>Rezervare</li></a>
					<li id="select1">Setarile contului</li>
					<li id="select2">Promotii</li>
					<li id="select3">Contact</li>
				</ul>
			</div>
	</section>

	<section id="right-section">
		<div id="grey-bck">
		<div id="div-sel1">
			<h2>Setarile contului</h2>
				<form action="">
					<h3>Date personale</h3>
					<label for="">Nume</label>
					<input type="text">
					<label for="">Prenume</label>
					<input type="text">
					<br>
					<br>
					<label for="">Telefon</label>
					<input type="text">
					<br>
					<br>
					<label for="">Domiciliu</label>
					<input type="text">
				</form>
				<button id='save-bttn'>Save</button>
				<div id="ex-bttn">X</div>
				<h3 id="hp">Modificare parola</h3>
				<br>
				<br>
				<div id="right-form">
					<form action="">
						<label for="">Parola noua</label>
						<input type="password">
						<br>
						<label for="">Confirmare</label>
						<input type="password">
					</form>
				</div>
				<h3 id="he">Modificare e-mail</h3>
				<div id="right-form2">
					<form action="">
						<label for="">Email nou</label>
						<input type="email">
					</form>
				</div>
		</div>
		</div>
		<div id="div-sel2"></div>
		<div id="div-sel3"></div>


		<div id="recomand">
			<h2>Recomandari</h2>
		</div>

		<div id="window"></div>
	</section>
</body>
</html>