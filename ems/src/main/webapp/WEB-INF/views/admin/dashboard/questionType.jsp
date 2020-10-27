<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Type</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.container {
	padding: 50px;
}
.question-form{
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="question-form">
			<form action="questionTypeForm" method="get">
				<div class="form-group text-center">
					<label>Add Question Type</label> <input type="text" name="questionType"
						class="form-control">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>

		<div class="text-center">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Question Type</th>
							<th scope="col">Edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="que" items="${questionTypeList}">
							<tr>
								<td><c:out value="${que.id}" /></td>
								<td><c:out value="${que.questionType}" /></td>
								<td><a role="button" href="${pageContext.request.contextPath}/questionTypeReport/${que.questionType}/${que.id}">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>