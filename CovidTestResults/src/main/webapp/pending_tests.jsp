<%@ include file="header.jsp"%>


<c:if test="${ isLoggedIn }">

	<c:if test="${ isEmployee }">

		<div class="container_blue">
		
			<h1 class="pending_tests_header">Pending Tests</h1>
		
		
			<table>
				<thead>
					<tr>
						<th>Test ID</th>
						<th>Date</th>
						<th>Result</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="test" items="${ pendingTests }">
				
					<tr>
						<td>
							<c:out value="${ test.testId }" />
						</td>
						<td>
							<c:out value="${ test.date }" />
						</td>
						<td>
							<c:out value="${ test.result }" />
						</td>
						<td>
							<a href="editTest?testId=<c:out value='${ test.testId }' />">
								<button class="btn_sm">Edit</button>
							</a>
						</td>
					</tr>
					
					</c:forEach>
				</tbody>
			</table>
				
	</c:if>
	
</c:if>


<c:if test="${ !isLoggedIn }">

	<c:if test="${ !isEmployee }">
	
		<div class="error_container">
			<h2 class="error_header">401 Error</h2>
		
	</c:if>
	
</c:if>

	
<%@ include file="footer.jsp" %>