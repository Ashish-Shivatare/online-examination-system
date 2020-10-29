<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" />
<style type="text/css">
body {
	background-color: #f7f7f8;;
}

.container {
	padding: 60px;
	padding-top: 80px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Oops! Sorry</h1>
			<h2>
				<c:out value="${message}"></c:out>
			</h2>
			<h5>Sorry, an error has occurred, Requested page not found!</h5>
		</div>

		<div class="text-center">
				<h5>
					<a role="button" href="${pageContext.request.contextPath}">Take Me Home</a>
				</h5>
				<h5>
					<a role="button" href="${pageContext.request.contextPath}">Contact Support</a>
				</h5>
		</div>
	</div>
</body>
</html>