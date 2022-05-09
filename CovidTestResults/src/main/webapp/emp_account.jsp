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
		<a href="<%=request.getContextPath()%>/client_login" class="login_nav_item">Client Login</a>
	</nav>
</div>

<div class="container_blue">

	<h1 class="cr_employee_header">Create Employee Account</h1>
	
	<div>
		
		<form action="createEmployeeAccount" method="POST">	
			
			<div class="emp_email">
				<label class="emp_email_label" for="email">Email</label>
				<input class="emp_email_input" type="email" id="email" name="email" required>
			</div>
			
			<div class="emp_username">
				<label class="emp_username_label" for="username">Username</label>
				<input class="emp_username_input" type="text" id="username" name="username" required>
			</div>
	
			<div class="emp_pwd">
				<label class="emp_pwd_label" for="pwd">Password</label>
				<input class="emp_pwd_input" type="password" id="pwd" name="pwd" required>
			</div>
		
			<button class="btn emp_btn" type="submit">Create</button>	
		
		</form>
		
	</div>

<%@ include file="footer.jsp"%>

