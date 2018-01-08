<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Reset password</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/recover.css">
</head>
<body>
	<div class="top_header">
		<a href="/index/"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a>
	</div>
	<div class = "loginBox">
		 <img src="${pageContext.request.contextPath}/resources/images/img3.png" class = "user">
		 <h2>Reset password</h2>
		 <form:form modelAttribute="newPasswordForm" action="/recovery/setNewPassoword">
		 	<p>Password:</p>
			<form:input type="password" name="" placeholder="Enter  password..." id="password" path="password" required="true"/>
			<form:input type="hidden" name="" placeholder="Enter  password..." id="token" path="token" value="${token_activare}" required="true"/>
			
			<br>
			<p>Confirm Password:</p>
			<input type="password" name="" placeholder="Confirm password..." required="true"/>
			<br>
			<button id="send-bttn">Send</button>
		 </form:form>
	</div>

</body>
</html>