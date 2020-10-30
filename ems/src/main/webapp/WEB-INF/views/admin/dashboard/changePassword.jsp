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
body {
	background: linear-gradient(120grad, #643986, #98aed5);
	font-family: "Roboto";
	color: white;
	font-size: 17px;
	height:auto; 
}

.btn-outline-primary {
	color: #643986;
	background-color: white;
}
.container {
	padding: 60px;
	padding-top: 80px;
}
</style>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Change Password</h1>
		</div>
		<form action="#" method="get">
			<div class="form-group">
				<label>Enter Old Password</label> <input type="text"
					class="form-control" name="oldPassword" placeholder="Old Password">
			</div>
			<div class="form-group">
				<label>Enter New Password</label> <input type="text"
					class="form-control" name="newPasssword" placeholder="New Password">
			</div>
			<div class="form-group">
				<label>Confirm New Password</label> <input type="text"
					class="form-control" name="confirmPassword" placeholder="Confirm Password">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-outline-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>