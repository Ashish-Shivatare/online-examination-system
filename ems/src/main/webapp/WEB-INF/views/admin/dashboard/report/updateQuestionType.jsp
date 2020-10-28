<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Type Report</title>
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
.btn-outline-primary {
	background-color:white;
	border-color:#643986;
	color: #643986;
}
.btn-outline-warning {
	background-color:white;
	border-color:#643986;
	color: #643986;
}
.container{
	padding: 80px;
	padding-top: 60px;
}
.h1 {
	padding: 20px
}

#formDiv {
	padding: 30px;
}
#error{
	color:red;
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
					<a class="btn btn-outline-primary" role="button" href="${pageContext.request.contextPath}/questionType/report">Back</a>
					<button class="btn btn-outline-warning" type="submit">Update</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>