<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.container {
	margin: 20px;
	padding: 20px;
	background-color: lightgrey;
	max-width: 1280px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">name</th>
						<th scope="col">Email</th>
						<th scope="col">Mobile No</th>
						<th scope="col">Higher Education</th>
						<th scope="col">Gender</th>
						<th scope="col">DOB</th>
						<th scope="col">Address</th>
						<th scope="col">City</th>
						<th scope="col">Country</th>
						<th scope="col">Pan card(scan copy)</th>
						<th scope="col">Higher education certificate(scan copy)</th>
						<th scope="col">Registration date</th>
						<th scope="col">Edit</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="student" items="${studentInfoList}">
					<tr>	
							<td><c:out value="${student.id}"/></td>
							<td><c:out value="${student.name}"/></td>
							<td><c:out value="${student.email}"/></td>
							<td><c:out value="${student.mobileNo}"/></td>
							<td><c:out value="${student.higherEducation}"/></td>
							<td><c:out value="${student.gender}"/></td>
							<td><c:out value="${student.dob}"/></td>
							<td><c:out value="${student.address}"/></td>
							<td><c:out value="${student.city}"/></td>
							<td><c:out value="${student.country}"/></td>
							<td><c:out value="${student.panCard}"/></td>
							<td><c:out value="${student.higherEducationCertificate}"/></td>
							<td><c:out value="${student.registrationDate}"/></td>
							<td><a href="update/${student.id}">Edit</a></td>		
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>