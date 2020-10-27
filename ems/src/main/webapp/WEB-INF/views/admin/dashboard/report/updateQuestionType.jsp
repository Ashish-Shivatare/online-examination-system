<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Type Report</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.h1 {
	padding: 20px
}

#formDiv {
	padding: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="h1 text-center">Update Question Type</div>
		<div id="formDiv">
			<form action="${pageContext.request.contextPath}/questionType/update"
				method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="questionId" name="id"
						value="${questionId}" readonly="readonly">
				</div>
				<div class="form-group">
					<input type="text" id="questionType" class="form-control" name="questionType"
						value="${questionType}">
				</div>
				<div class="text-center">
					<button class="btn btn-warning" type="submit">Update</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>