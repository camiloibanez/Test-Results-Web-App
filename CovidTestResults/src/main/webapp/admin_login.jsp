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
			<a href="<%=request.getContextPath()%>/client_login" class="login_nav_link">Client Login</a>
		</div>
	</nav>
</div>

<div class="container_grey container_w_graphic">
	<div class="graphic_grey">
		<h1 class="emp_login_header">Employee Login Page</h1>
		
		<form action="admin_signin" method="POST">
		
			<div>
				<label class="emp_login_uname_label" for="username" class="">Username</label>
				<input class="emp_login_username" type="text" id="username" name="username" required>
			</div>
	
			<div>
				<label class="emp_login_pwd_label" for="password" class="">Password</label>
				<input class="emp_login_password" type="password" id="password" name="password" required>
			</div>
			<a class="emp_login_cr_account" href="<%=request.getContextPath()%>/newEmployeeAccount">Create an Account</a>
			<input class="btn emp_login_btn" type="submit" value="Login">
		</form>
	</div>
</div>

<%@ include file="footer.jsp" %>