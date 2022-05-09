<%@ include file="header.jsp"%>

<c:if test="${ isLoggedIn }">

	<c:if test="${ isEmployee }">

		<div class="container_blue">
		
		<div>
		
			<h1 class="employee_header">Update Account Info</h1>
			
			<form action="updateEmployee" method="POST">
			
				
				<h4 class="emp_id_label">Employee Id: </h4><h2 class="emp_id"><c:out value='${ user.employeeId }' /></h2>
				
				<div class="emp_email">
					<label class="emp_email_label" for="email">Email</label>
					<input class="emp_email_input" type="email" id="email" name="email" value="<c:out value='${ user.email }'/>" required>
				</div>
				
				<div class="emp_username">
					<label class="emp_username_label" for="username">Username</label>
					<input class="emp_username_input" type="text" id="username" name="username" value="<c:out value='${ user.username }'/>" required>
				</div>
		
				<div class="emp_pwd">
					<label class="emp_pwd_label" for="pwd">Password</label>
					<input class="emp_pwd_input" type="password" id="pwd" name="pwd" value="<c:out value='${ user.password }'/>" required>
				</div>
				
				<button class="btn emp_btn" type="submit">Save</button>	
				
			</form>
			
		</div>
	
	</c:if>
	
</c:if>


<c:if test="${ !isLoggedIn }">

	<c:if test="${ !isEmployee }">
	
		<div class="error_container">
			<h2 class="error_header">401 Error</h2>
		
	</c:if>
	
</c:if>


<%@ include file="footer.jsp"%>

