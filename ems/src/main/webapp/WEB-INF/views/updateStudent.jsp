<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin: 40px;
	margin-top: 20px; 
	padding: 80px;
}
.h1{
padding-bottom: 30px;
}
.text-center{
	padding-top: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="h1">Update Student Details</div>
		<form action="${pageContext.request.contextPath}/updateStudentForm" method="post">
			<div class="form-group">
				<label>Student Id</label> <input type="text" class="form-control"
					id="question" name="id" value="${student.id}" readonly>
			</div>
		
			<div class="form-group">
				<label>Student Name</label> <input type="text" class="form-control" name="name" value="${student.name}">
			</div>

			<div class="form-group">
				<label>Email</label> <input type="text" class="form-control" name="email" value="${student.email}">
			</div>

			<div class="form-group">
				<label>Mobile No</label> <input type="text" class="form-control" name="mobileNo" value="${student.mobileNo}">
			</div>

			<div class="form-group">
				<label>Higher Education</label> <input type="text"
					class="form-control" name="higherEducation" value="${student.higherEducation}">
			</div>

			<div class="form-group">
				<label>Gender</label> <input type="text" class="form-control" name="gender" value="${student.gender}">
			</div>

			<div class="form-group">
				<label>Date of birth</label> <input type="text" class="form-control" name="dob" value="${student.dob}">
			</div>

			<div class="form-group">
				<label>Address</label> <input type="text" class="form-control" name="address" value="${student.address}">
			</div>

			<div class="form-group">
				<label>City</label> <input type="text" class="form-control" name="city" value="${student.city}">
			</div>

			<div class="form-group">
				<label>Country</label> <input type="text" class="form-control" name="country" value="${student.country}">
			</div>

			<div class="form-group">
				<label>Pan Card</label> <input type="text" class="form-control" name="panCard" value="${student.panCard}">
			</div>

			<div class="form-group">
				<label>Higher Education Certificate</label> <input type="text"
					class="form-control" name="higherEducationCertificate" value="${student.higherEducationCertificate}">
			</div>

			<div class="form-group">
				<label>Registration Date</label> <input type="text"
					class="form-control" name="registrationDate" value="${student.registrationDate}">
			</div>
			<div class="text-center">
				<a href="${pageContext.request.contextPath}/studentInformation" class="btn btn-outline-primary">Back</a>
				<button type="submit" class="btn btn-warning">Update</button>
			</div>
		</form>
	</div>
</body>
</html>