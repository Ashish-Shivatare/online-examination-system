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
body {
	background: linear-gradient(120grad, #643986, #98aed5);
	font-family: "Roboto";
	color: white;
	font-size: 17px;
	height:auto; 
}
.btn-outline-primary{
 color: #643986;
 background-color: white;
}
.container {
	padding: 60px;
	padding-top: 80px;
}
.question-form{
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="question-form">
			<form action="questionTypeForm" method="post">
				<div class="form-group text-center">
					<h1><label>Add Question Type</label></h1> <input type="text" name="questionType"
						class="form-control"/>
				</div>
				<div class="text-center">
					<a role="button" class="btn btn-outline-primary" href="dashboard">Back</a>
					<button type="submit" class="btn btn-outline-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>