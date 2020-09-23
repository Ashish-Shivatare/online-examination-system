<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
</head>
<body>
	<div>
		<form action="addQuestionForm" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Question</label> 
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp"> 
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1">
			</div>	
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>