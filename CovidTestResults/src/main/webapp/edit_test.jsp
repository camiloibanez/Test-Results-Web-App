<%@ include file="header.jsp"%>

<c:if test="${ isEmployee }">

	<div class="container">

		<h1 class="test_header">Edit Test</h1>
		
		<h2 class="test_date"><c:out value="${ test.date }" /></h2>
		
		<p class="test_inst">Please enter the results of lab test <c:out value="${ test.testId }"/>: </p>
		
		<form action="updateTest" method="GET">
		
			<input type="hidden" name="testId" value="${ test.testId }">
		
			<div class="test_left">
				<input class="test_radio_pend" type="radio" id="radio-pending" name="result" value="Pending">
				<label class="test_label_pend btn_grey" for="radio-pending">Revert to Pending</label>
				
				<input class="test_radio_error"type="radio" id="radio-error" name="result" value="ERROR">
				<label class="test_label_error btn_grey"for="radio-error">Declare Error</label>
			</div>
			
			<div class="test_right">
				<input class="test_radio_pos" type="radio" id="radio-positive" name="result" value="POSITIVE">
				<label class="test_label_pos btn_red" for="radio-positive">POSITIVE</label>
				
				<input class="test_radio_neg" type="radio" id="radio-negative" name="result" value="NEGATIVE">	
				<label class="test_label_neg btn_green" for="radio-negative">NEGATIVE</label>
			</div>
			
			<input class="btn_lg test_btn" type="submit" value="Submit">
			
		</form>
	
</c:if>

<c:if test="${ !isLoggedIn }">

	<c:if test="${ !isEmployee }">
	
		<div class="error_container">
			<h2 class="error_header">401 Error</h2>
		
	</c:if>
	
</c:if>

<%@ include file="footer.jsp" %>