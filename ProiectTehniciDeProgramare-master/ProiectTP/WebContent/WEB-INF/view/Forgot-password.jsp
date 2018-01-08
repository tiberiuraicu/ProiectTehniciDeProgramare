<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Log in</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/F_pass.css">
</head>
<body>
	<div class="top_header">
		<a href="/index/"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a>
		<a href="/register/"><button>Register</button></a>
		<a href="/login/"><button>Login</button></a>

	</div>
	<div class = "loginBox">
		 <img src="${pageContext.request.contextPath}/resources/images/img3.png" class = "user">
		 <h2>Forgot Password?</h2>
		 <form:form action="/recovery/sendRecoveryEmail" id="recoveryEmail" modelAttribute="recoveryEmail" method="post">
		 	<p id="f_txt">Don`t worry ,enter your email down below and we will send you a password recovery email: <p>
		 	<br>
		 	<br>
		 	<p>Email:</p>
			<form:input type="email" path="recoverEmail" id="recoverEmail"  placeholder="Enter email.." required="true"/>
			<br>
			
			<br>
			<form:button type="submit" id="frgt-bttn">Send</form:button>
		
		
		</form:form>
	</div>

</body>
</html>