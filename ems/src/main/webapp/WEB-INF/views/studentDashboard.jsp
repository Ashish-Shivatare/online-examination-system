<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Over</title>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Exam Result</h1>
		</div>
		<div class="text-center">
			<table class="table table-bordered" style="width: 100%">
				<tr>
					<th>Total Solved Question:</th>
					<td><c:out value="${totalSolvedQuestion}" /></td>
				</tr>
				<tr>
					<th>Total Correct Answer</th>
					<td><c:out value="${totalCorrectAnswer}" /></td>
				</tr>
				<tr>
					<th>Total Incorrect Answer</th>
					<td><c:out value="${totalIncorrectAnswer}" /></td>
				</tr>
				<tr>
					<th>Status</th>
					<td><c:out value="${status}" /></td>
				</tr>
			</table>
		</div>
		<div class="text-center">
			<h3>
				<a class="dropdown-item"
					href="${pageContext.request.contextPath}/studentLogout"
					role="button">Click To Logout From DashBoard</a>
			</h3>
		</div>
	</div>
</body>
</html>