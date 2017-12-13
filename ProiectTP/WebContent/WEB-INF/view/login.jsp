<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
	<div class="top_header">
		<a href="/index/"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a> <a href="/register/"><button>Register</button></a>
	</div>
	<div class="loginBox">
		<img src="${pageContext.request.contextPath}/resources/images/img3.png" class="user">
		<h2>Log in</h2>
		<h1 id="h1"></h1>
		<form:form id="loginForm" modelAttribute="loginForm" action="/login/login" >
		<p>Email:</p>
		<form:input type="email" path="loginEmail" id="loginEmail" placeholder="Enter email.." required="true" />
		<br>
		<p>Password:</p>
		<form:input type="password" path="loginPassword" id="loginPassword" placeholder="Enter password..." required="true" />
		<br>
		<form:button type="submit" id="login-bttn" >Sign in</form:button>
		<a href="/recovery/">Forgot password?</a>
		</form:form>
	</div>

</body>
</html>