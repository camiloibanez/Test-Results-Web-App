<%@ include file="header.jsp"%>

<c:if test="${ isLoggedIn }">

	<div class="container container_w_graphic">
	
	<div class="graphic_grey2">
	
		<h1 class="new_test_header">New Test</h1>
		
		<h4 class="new_test_welcome">Welcome <c:out value="${ firstName }"/> <c:out value="${ lastName }"/></h4>
		
		<p class="new_test_prompt">Would you like to submit another test?</p>
		
		<a class="new_test_submit btn_lg" href="<%=request.getContextPath()%>/check">Check</a>
	
	</div>

</c:if>


<c:if test="${ !isLoggedIn }">
	
		<div class="error_container">
			<h2 class="error_header">401 Error</h2>
				
</c:if>


<%@ include file="footer.jsp" %>