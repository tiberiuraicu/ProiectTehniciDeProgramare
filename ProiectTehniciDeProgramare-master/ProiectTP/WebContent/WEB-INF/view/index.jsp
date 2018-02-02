<!DOCTYPE html>

<head>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0"/>

	<meta charset="UTF-8">
	<title>Welcome!</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index-style.css">
</head>
<body>

	<div class = "Box1">
		 <img src="${pageContext.request.contextPath}/resources/images/logo.png" class = "user">
		 <h2>About us</h2>
		 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean porttitor, est a facilisis viverra, velit lacus consequat metus, vel consectetur lacus lacus non massa. Fusce sit amet diam eros. Pellentesque id dolor dui. Sed nunc massa, tincidunt non ultricies at, semper a metus. Sed aliquam dignissim fringilla. Vivamus vestibulum tempus urna. Praesent finibus justo at urna facilisis molestie. Integer id urna finibus, tempor est nec, luctus nisi.</p>
	</div>
	<a href="meniu.html"><div class="min_menu">
			<h4>Meniu</h4>
			<img id="menu_img" src="${pageContext.request.contextPath}/resources/images/logo1.png" alt="">
		</div></a>

	<div class = "Box2">
		<h1>Welcome!</h1>
		<img src="${pageContext.request.contextPath}/resources/images/img3.png" class = "user">
		
			<a href="/ProiectTP/login/"><button id="button1">Log in</button></a>
			<br><br>
			<a href="/ProiectTP/register/"><button id="button2">Register</button></a>
			<a id="passForg" href="#">Forgot password?</a>		
	</div>
</body>
</html>