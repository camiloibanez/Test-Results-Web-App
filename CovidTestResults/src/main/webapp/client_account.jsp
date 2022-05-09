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
		<a href="<%=request.getContextPath()%>/admin_login" class="login_nav_item">Admin Login</a>
	</nav>
</div>

<div class="container_blue">

	<h1 class="cl_header">Create Client Account</h1>
	
	<div>
	
		<form action="createClientAccount" method="POST">
			
			<div class="cl_email">
				<label class="cl_email_label" for="email">Email</label>
				<input class="cl_email_input" type="email" id="email" name="email" required>
			</div>
			
			<div class="cl_username">
				<label class="cl_username_label" for="username">Username</label>
				<input class="cl_username_input" type="text" id="username" name="username" required>
			</div>
	
			<div class="cl_pwd">
				<label class="cl_pwd_label" for="pwd">Password</label>
				<input class="cl_pwd_input" type="password" id="pwd" name="pwd" required>
			</div>
	
			<div class="cl_addrL1">
				<label class="cl_addrL1_label" for="addressLine1">Address Line 1</label>
				<input class="cl_addrL1_input" type="text" id="addressLine1" name="addressLine1">
			</div>
	
			<div class="cl_addrL2">
				<label class="cl_addrL2_label" for="addressLine2">Address Line 2</label>
				<input class="cl_addrL2_input" type="text" id="addressLine2" name="addressLine2">
			</div>
	
			<div class="cl_city">
				<label class="cl_city_label" for="city">City</label>
				<input class="cl_city_input" type="text" id="city" name="city">
			</div>
	
			<div class="cl_state">
				<label class="cl_state_label" for="state">State</label>
				<input class="cl_state_input" type="text" id="state" name="state">
			</div>
	
			<div class="cl_zipcode">
				<label class="cl_zipcode_label" for="zipcode">Zipcode</label>
				<input class="cl_zipcode_input" type="text" id="zipcode" name="zipcode">
			</div>
	
			<div class="cl_ins">
				<label class="cl_ins_label" for="insuranceNo">Insurance No</label>
				<input class="cl_ins_input" type="text" id="insuranceNo" name="insuranceNo" required>
			</div>
	
			<div class="cl_phone">
				<label class="cl_phone_label" for="phone">Phone</label>
				<input class="cl_phone_input" type="text" id="phone" name="phone">
			</div>
	
			<div class="cl_fname">
				<label class="cl_fname_label" for="firstName">First Name</label>
				<input class="cl_fname_input" type="text" id="firstName" name="firstName" required>
			</div>
	
			<div class="cl_lname">
				<label class="cl_lname_label" for="lastName">Last Name</label>
				<input class="cl_lname_input" type="text" id="lastName" name="lastName" required>
			</div>
	
			<div class="cl_card">
				<label class="cl_card_label" for="cardNo">Card Number</label>
				<input class="cl_card_input" type="text" id="cardNo" name="cardNo">
			</div>
	
			<div class="cl_expMonth">
				<label class="cl_expMonth_label" for="expMonth">Expiration Month</label>
				<input class="cl_expMonth_input" type="text" id="expMonth" name="expMonth">
			</div>
	
			<div class="cl_expYear">
				<label class="cl_expYear_label" for="expYear">Expiration Year</label>
				<input class="cl_expYear_input" type="text" id="expYear" name="expYear">
			</div>
	
			<div class="cl_cvc">
				<label class="cl_cvc_label" for="securityCode">CVC</label>
				<input class="cl_cvc_input" type="text" id="securityCode" name="securityCode">
			</div>
			
		
				<button class="btn cl_btn" type="submit">Create</button>	
	
		</form>
		
	</div>

<%@ include file="footer.jsp"%>

