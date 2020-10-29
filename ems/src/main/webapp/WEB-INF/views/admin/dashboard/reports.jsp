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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
body {
	background: -webkit-linear-gradient(left, #643986, #98aed5);
	background: linear-gradient(to right, #643986, #98aed5);
	font-family: 'Roboto', sans-serif;
}

.container {
	padding: 0px;
	padding-top: 80px
}

}
table {
	width: 100%;
	table-layout: fixed;
}

thead {
	background-color: rgba(255, 255, 255, 0.3);
}

tbody {
	height: 300px;
	overflow-x: auto;
	margin-top: 0px;
	border: 1px solid rgba(255, 255, 255, 0.3);
}

th {
	padding: 20px 15px;
	text-align: left;
	font-weight: 500;
	font-size: 15px;
	color: #fff;
	text-transform: uppercase;
}

td {
	padding: 15px;
	text-align: left;
	vertical-align: middle;
	font-weight: 400;
	font-size: 15px;
	color: #fff;
	border-bottom: solid 1px rgba(255, 255, 255, 0.1);
}

#viewQuestion {
	color: white;
}

#viewQuestion:hover {
	color: blue;
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
							<td id="status"><c:out value="${student.status}" /></td>
							<td><a id="viewQuestion" role="button"
								href="${pageContext.request.contextPath}/studentReport/paper/${student.id}">View
									Question paper</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>