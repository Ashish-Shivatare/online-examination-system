<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Type</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<style>
		.container{
			padding: 50px;		
		}
	</style>
</head>
<body>
	<div class="container">
		<form action="questionTypeForm" method="get">
			<div class="form-group text-center">
				<label>Question Type</label> <input
					type="text" name="questionType" class="form-control">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>