<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Report</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style type="text/css">
.container {
	padding: 20px;
	margin: 80px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Student Name</th>
						<th scope="col">Email</th>
						<th scope="col">Mobile No</th>
						<th scope="col">Total Solved Question Count</th>
						<th scope="col">Correct Answer Count</th>
						<th scope="col">Incorrect Answer Count</th>
						<th scope="col">Status</th>
						<th scope="col">View Question Paper</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${studentReportList}">
						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.studentName}" /></td>
							<td><c:out value="${student.studentEmail}" /></td>
							<td><c:out value="${student.studentMobileNo}" /></td>
							<td><c:out value="${student.totalSolvedQuestion}" /></td>
							<td><c:out value="${student.correctAnswerCount}" /></td>
							<td><c:out value="${student.incorrectAnswerCount}" /></td>
							<td><c:out value="${student.status}" /></td>
							<td><a role="button" href="${pageContext.request.contextPath}/studentReport/paper/${student.id}">View Question paper</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>