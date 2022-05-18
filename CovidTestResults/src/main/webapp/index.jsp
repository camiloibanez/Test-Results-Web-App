<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COVID Test Results Web App</title>
<style><%@include file="/css/styles.css"%></style>

</head>
<body>
<div>
	<nav class="login_nav">
		<div class="login_nav_item">
			<a href="<%=request.getContextPath()%>/admin_login" class="login_nav_link">Admin Login</a>
		</div>
	</nav>
</div>

<div class="container container_w_graphic">
	<div class="graphic">
		<h1 class="client_login_header">Client Login Page</h1>
		
		<form action="client_signin" method="POST">
		
			<div>
				<label class="client_login_uname_label" for="username" class="">Username</label>
				<input class="client_login_username" type="text" id="username" name="username" required>
			</div>
	
			<div>
				<label class="client_login_pwd_label"for="password" class="">Password</label>
				<input class="client_login_password" type="password" id="password" name="password" required>
			</div>
			<a class="client_login_cr_account" href="<%=request.getContextPath()%>/newClientAccount">Create an Account</a>
			<input class="btn client_login_btn" type="submit" value="Login">
		</form>
	</div>
</div>

<%@ include file="footer.jsp" %>