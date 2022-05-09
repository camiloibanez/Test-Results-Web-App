<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COVID Test Results Web App</title>
<style><%@include file="/css/styles.css"%></style>

</head>
<body>

<c:if test="${ isLoggedIn }">

	<div>
		<nav class="main_nav">
			<div class="nav_left">
				<c:if test="${ !isEmployee }">
					<div class="nav_item">
						<a href="<%=request.getContextPath()%>/new_test" class="nav_link">New Test</a>
					</div>
					<div class="nav_item">
						<a href="<%=request.getContextPath()%>/review_tests" class="nav_link">Review Tests</a>
					</div>
					<div class="nav_item">
						<a href="<%=request.getContextPath()%>/updateClientForm" class="nav_link">Account Info</a>
					</div>
				</c:if>
				
				<c:if test="${ isEmployee }">
					<div class="nav_item_bg">
						<a href="<%=request.getContextPath()%>/pending_tests" class="nav_link">Pending Tests</a>
					</div>
					<div class="nav_item_bg">
						<a href="<%=request.getContextPath()%>/test_history" class="nav_link">View Test History</a>
					</div>
					<div class="nav_item">
						<a href="<%=request.getContextPath()%>/updateEmployeeForm" class="nav_link">Account Info</a>
					</div>
				</c:if>
				
			</div>
			
			<div class="nav_right">
				<div class="nav_item">
					<a href="<%=request.getContextPath()%>/logout" class="nav_link">Logout</a>
				</div>
			</div>
		</nav>
	</div>
	
</c:if>