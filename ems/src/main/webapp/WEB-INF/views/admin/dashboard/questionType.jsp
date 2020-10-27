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
	</div>
</body>
</html>