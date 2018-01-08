<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>User</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.color.js"></script>
<script>
	$(document).ready(function() {
		$(document).ready(function() {
			$('#bars').click(function() {
				$('#right-bar').slideToggle();
			});

			$('#select1').click(function() {
				$('#div-sel2').fadeOut();
				$('#div-sel3').fadeOut();
				$('#div-sel1').fadeToggle();
				$('#right-bar').slideUp();
				$('#grey-bck').fadeIn();
			});

			$('#save-bttn').click(function() {
				$('#div-sel1').fadeOut();
				$('#grey-bck').fadeOut();
			});

			$('#select2').click(function() {
				$('#div-sel1').fadeOut();
				$('#div-sel3').fadeOut();
				$('#div-sel2').fadeToggle();
				$('#right-bar').slideUp();
				$('#grey-bck').fadeIn();

			});

			$('#select3').click(function() {
				$('#div-sel2').fadeOut();
				$('#div-sel1').fadeOut();
				$('#div-sel3').fadeToggle();

			});

			$('#ex-bttn').click(function() {
				$('#div-sel1').fadeOut();
				$('#grey-bck').fadeOut();
			});

			$('#ex-bttn2').click(function() {
				$('#div-sel2').fadeOut();
				$('#grey-bck').fadeOut();
			});

			$('#contact-bttn').click(function() {
				$('#div-sel2').fadeOut();
				$('#grey-bck').fadeOut();
			});
		});
	});
</script>

<!-- Client details modifier -->
<script>
	function passwordMatch() {
		var password = $('#password').val();
		var confirmedPassword = $('#confirmedPassword').val();
		if (password == confirmedPassword)
			return true;
		else
			return false;
	}
	function toJson() {
		var obj = new Object();
		obj.firstName = $('#firstName').val();
		obj.lastName = $('#lastName').val();
		obj.phoneNumber = $('#phoneNumber').val();
		obj.homeAdress = $('#homeAdress').val();
		if (passwordMatch())
			obj.password = $('#password').val()
		else
			obj.password = ""
		obj.email = $('#email').val();
		var newData = JSON.stringify(obj);
		return newData;
	}

	function sendData() {
		console.log("ceva")
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			url : window.location.protocol + "//" + window.location.host + "/" + "ProiectTP/Client/saveNewAccountInfo",
			data : toJson(),

			success : function(result) {
				console.log(result)
			}
		});
	}
</script>

<script>
	var chatIn,
		chatOut,
		webSocket,
		i = 0;

	function reset() {
		if (i != 0) {
			$(document).ready(function() {

				$('#content').load('/Proiect/home/alarm #content')

			});
		}
	}

	document.addEventListener("DOMContentLoaded", function() {



		webSocket = new WebSocket("ws://localhost:8090/Proiect/home/alarm");
		webSocket.onopen = function() {
			console.log("Socket is now open.");
		};
		webSocket.onerror = function() {
			console.log("There was an error.");
		};
		webSocket.onmessage = function(e) {
			i++;
			console.log("Got message: " + e.data);
			var p = document.createElement("p");
			p.innerHTML = e.data;
			document.getElementById("span").textContent = i;

		}

	});
</script>
</head>
<body>
	<div class="container">
		<header>
			<div class="top_header">
				<img id="bars"
					src="${pageContext.request.contextPath}/resources/images/3bars.png"
					alt="">
				<button>Log out</button>
			</div>
			<img
				src="${pageContext.request.contextPath}/resources/images/img3.png"
				class="user">
		</header>
		<section id="left-section">
			<div id="right-bar">
				<ul id="lista">
					<a href="#"><li>Meniu</li></a>
					<a href="#"><li>Rezervare</li></a>
					<li id="select1">Setarile contului</li>
					<li id="select2">Contact</li>
				</ul>
			</div>
		</section>

		<section id="right-section">
			<div id="grey-bck">
				<div id="div-sel1">
					<h2>Setarile contului</h2>
					<form action="">
						<h3>Date personale</h3>
						<label for="">Nume</label> <input id="firstName" type="text">
						<label for="">Prenume</label> <input id="lastName" type="text"
							placeholder=""> <br> <br> <label for="">Telefon</label>
						<input id="phoneNumber" type="text"> <br> <br> <label
							for="">Domiciliu</label> <input id="homeAdress" type="text">
					</form>
					<button id='save-bttn' onclick="sendData()">Save</button>
					<div id="ex-bttn">X</div>
					<h3 id="hp">Modificare parola</h3>
					<br> <br>
					<div id="right-form">
						<form action="">
							<label for="">Parola noua</label> <input id="password"
								type="password"> <br> <label for="">Confirmare</label>
							<input id="confirmedPassword" type="password">
						</form>
					</div>
					<h3 id="he">Modificare e-mail</h3>
					<div id="right-form2">
						<form action="">
							<label for="">Email nou</label> <input id="email" type="email">
						</form>
					</div>
				</div>
			</div>
			<div id="div-sel2">
				<h2>Contact us</h2>
				<br> <br>
				<form action="">
					<div id="subject-contact">
						<label for="">Subiect</label> <input type="text">
					</div>
					<br> <br> <label id="msg-label" for="">Mesaj</label>
					<textarea name="" id="msg-txtarea" cols="30" rows="10">	</textarea>
					<br> <br>
					<div id=></div>
					<button id="contact-bttn">Send</button>
				</form>
				<div id="ex-bttn2">X</div>
			</div>
	</div>
	<div id="recomand">
		<h2>Program</h2>
		<h3>Luni:9:00 - 22:00</h3>
		<h3>Marti:9:00 - 22:00</h3>
		<h3>Miercuri:9:00 - 22:00</h3>
		<h3>Joi:9:00 - 22:00</h3>
		<h3>Vineri:9:00 - 22:00</h3>
		<h3>Sambata:10:00 - 16:00</h3>
		<h3>Duminica:10:00 - 13:00</h3>
	</div>

	<div id="window">
		<h2 id="window-head">News</h2>
		<p id="window-paragraph">Lorem ipsum dolor sit amet, consectetur
			adipiscing elit. Nullam quis varius tortor. Vestibulum at ex sed est
			lacinia molestie id fermentum metus. Cras vel velit varius, egestas
			nulla et, gravida arcu. Etiam arcu ligula, facilisis a sodales in,
			consectetur a augue. Nunc auctor ante eget finibus porttitor.
			Suspendisse viverra rhoncus dolor suscipit interdum. Morbi hendrerit
			massa sed enim iaculis elementum. Phasellus sit amet ex malesuada,
			blandit nunc quis, dignissim mi. Pellentesque ut magna eu tortor
			elementum blandit mollis sed eros. Suspendisse potenti. Praesent
			dignissim eu dui vel tristique. Mauris blandit pharetra libero, sed
			molestie metus maximus sit amet.</p>
		<hr>

		<img id="reduceri_1"
			src="${pageContext.request.contextPath}/resources/images/ap5.jpg"
			alt=""> <img id="reduceri_2"
			src="${pageContext.request.contextPath}/resources/images/nod1.jpg"
			alt="">
		<div id="equal">=</div>
		<div id="circle">
			<p id="circle-text">-20%</p>
		</div>
	</div>
	</div>
	</section>
</body>
</html>