<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
.container {
	margin: 80px;
	padding: 20px;
}
</style>
<body>
	<div class="container">
			<form action="addQuestionForm" method="get">
				<div class="form-group">
					<label>Enter Old Password</label> <input type="text"
						class="form-control" name="oldPassword">
				</div>
				<div class="form-group">
					<label>Enter New Password</label> <input type="text"
						class="form-control" name="newPasssword">
				</div>
				<div class="form-group">
					<label>Confirm New Password</label> <input type="text"
						class="form-control" name="confirmPassword">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
	</div>
</body>
</html>