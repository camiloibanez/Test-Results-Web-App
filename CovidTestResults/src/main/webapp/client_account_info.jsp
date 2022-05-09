<%@ include file="header.jsp"%>

<c:if test="${ isLoggedIn }">

	<div class="container_blue">
	
	<div>
	
		<h1 class="cl_header">Update Account Info</h1>
		
		<form action="updateClient" method="POST">
	
			<div>
				<input type="hidden" name="id" value="<c:out value='${ user.clientId }' />">		
			</div>
			<div class="cl_email">
				<label class="cl_email_label" for="email">Email</label>
				<input class="cl_email_input" type="email" id="email" name="email" value="<c:out value='${ user.email }'/>" required>
			</div>
			
			<div class="cl_username">
				<label class="cl_username_label" for="username">Username</label>
				<input class="cl_username_input" type="text" id="username" name="username" value="<c:out value='${ user.username }'/>" required>
			</div>
	
			<div class="cl_pwd">
				<label class="cl_pwd_label" for="pwd">Password</label>
				<input class="cl_pwd_input" type="password" id="pwd" name="pwd" value="<c:out value='${ user.password }'/>" required>
			</div>
	
			<div class="cl_addrL1">
				<label class="cl_addrL1_label" for="addressLine1">Address Line 1</label>
				<input class="cl_addrL1_input" type="text" id="addressLine1" name="addressLine1" value="<c:out value='${ user.addressLine1 }'/>" required>
			</div>
	
			<div class="cl_addrL2">
				<label class="cl_addrL2_label" for="addressLine2">Address Line 2</label>
				<input class="cl_addrL2_input" type="text" id="addressLine2" name="addressLine2" value="<c:out value='${ user.addressLine2 }'/>" required>
			</div>
	
			<div class="cl_city">
				<label class="cl_city_label" for="city">City</label>
				<input class="cl_city_input" type="text" id="city" name="city" value="<c:out value='${ user.city }'/>" required>
			</div>
	
			<div class="cl_state">
				<label class="cl_state_label" for="state">State</label>
				<input class="cl_state_input" type="text" id="state" name="state" value="<c:out value='${ user.state }'/>" required>
			</div>
	
			<div class="cl_zipcode">
				<label class="cl_zipcode_label" for="zipcode">Zipcode</label>
				<input class="cl_zipcode_input" type="text" id="zipcode" name="zipcode" value="<c:out value='${ user.zipCode }'/>" required>
			</div>
	
			<div class="cl_ins">
				<label class="cl_ins_label" for="insuranceNo">Insurance No</label>
				<input class="cl_ins_input" type="text" id="insuranceNo" name="insuranceNo" value="<c:out value='${ user.insuranceNo }'/>" required>
			</div>
	
			<div class="cl_phone">
				<label class="cl_phone_label" for="phone">Phone</label>
				<input class="cl_phone_input" type="text" id="phone" name="phone" value="<c:out value='${ user.phone }'/>" required>
			</div>
	
			<div class="cl_fname">
				<label class="cl_fname_label" for="firstName">First Name</label>
				<input class="cl_fname_input" type="text" id="firstName" name="firstName" value="<c:out value='${ user.firstName }'/>" required>
			</div>
	
			<div class="cl_lname">
				<label class="cl_lname_label" for="lastName">Last Name</label>
				<input class="cl_lname_input" type="text" id="lastName" name="lastName" value="<c:out value='${ user.lastName }'/>" required>
			</div>
	
			<div class="cl_card">
				<label class="cl_card_label" for="cardNo">Card Number</label>
				<input class="cl_card_input" type="text" id="cardNo" name="cardNo" value="<c:out value='${ user.cardNo }'/>" required>
			</div>
	
			<div class="cl_expMonth">
				<label class="cl_expMonth_label" for="expMonth">Exp Month</label>
				<input class="cl_expMonth_input" type="text" id="expMonth" name="expMonth" value="<c:out value='${ user.expMonth }'/>" required>
			</div>
	
			<div class="cl_expYear">
				<label class="cl_expYear_label" for="expYear">Exp Year</label>
				<input class="cl_expYear_input" type="text" id="expYear" name="expYear" value="<c:out value='${ user.expYear }'/>" required>
			</div>
	
			<div class="cl_cvc">
				<label class="cl_cvc_label" for="securityCode">CVC</label>
				<input class="cl_cvc_input" type="text" id="securityCode" name="securityCode" value="<c:out value='${ user.securityCode }'/>" required>
			</div>
			
			<button class="btn cl_btn" type="submit">Save</button>	
			
		</form>
		
	</div>

</c:if>

<c:if test="${ !isLoggedIn }">

	<div class="error_container">
		<h2 class="error_header">401 Error</h2>
	
</c:if>
<%@ include file="footer.jsp"%>

