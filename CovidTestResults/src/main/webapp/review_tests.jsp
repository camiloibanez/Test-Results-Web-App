<%@ include file="header.jsp"%>

<c:if test="${ isLoggedIn }">

	<div class="container">
	
	<div class="pending_left">
	
		<c:if test="${ not empty pendingTests }"><h2 class="pending_header">Pending Tests</h2></c:if>
		
		<c:if test="${ empty pendingTests }"><h2 class="pending_header_none">You have no Pending Tests</h2></c:if>
		
		<c:forEach begin="0" end="0" var="pendingTest" items="${ pendingTests }">
		
			<h3 class="pending_text"><c:out value="${ pendingTests[0].date }"></c:out> test is being analyzed...</h3>
		
		</c:forEach>
		
		<div class="pending_tests">
		
			<c:forEach var="pendingTest" items="${ pendingTests }">
		
				<div class="pill_single">
					<span class="pill_single_text"><c:out value="${ pendingTest.date }" /></span>
				</div>
				
			</c:forEach>
		
		</div>
	</div>
	
	<div class="pending_right">
		<div class="completed_tests">
		
			<c:forEach var="completedTest" items="${ completedTests }">
			
				<div class="pill_double">
					<div class="pill_double_date">
						<span><c:out value="${ completedTest.date }" /></span>
					</div>
					<div class="pill_double_result">
						<span><c:out value="${ completedTest.result }" /></span>
					</div>
				</div>
				
			</c:forEach>
		</div>
	</div>

</c:if>


<c:if test="${ !isLoggedIn }">
	
		<div class="error_container">
			<h2 class="error_header">401 Error</h2>
	
	
</c:if>


<%@ include file="footer.jsp" %>