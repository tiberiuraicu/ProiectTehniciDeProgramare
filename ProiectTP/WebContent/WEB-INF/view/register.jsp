<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/register-style.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script>
	
</script>
</head>
<body>
	<div class="top_header">
		<a href="/index/"><img
			src="${pageContext.request.contextPath}/resources/images/logo.png"
			alt=""></a> <a href="/login/"><button>Log in</button></a>
	</div>
	<div class="registerBox">
		<img
			src="${pageContext.request.contextPath}/resources/images/img3.png"
			class="user">
		<h2>Register</h2>
		<form:form id="registerForm" method="post"
			modelAttribute="registerForm" action="/register/register">
			<p>First Name:</p>
			<form:input type="text" id="firstName" path="firstName"
				placeholder="First name.." required="true" />
			<br>
			<p>Second Name:</p>
			<form:input type="text" id="lastName" path="lastName"
				placeholder="Second name.." required="true" />
			<br>
			<p>Email:</p>
			<form:input type="email" id="email" path="email"
				placeholder="Email.." required="true" />
			<br>
			<p>Password:</p>
			<form:input type="password" id="password" path="password"
				placeholder="Password..." required="true" />
			<br>
			<form:button id="register-bttn" type="submit">Register</form:button>

		</form:form>
	</div>

</body>
</html>