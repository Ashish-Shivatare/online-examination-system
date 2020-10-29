<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Exam Over</title>
<style type="text/css">
body{
	background: -webkit-linear-gradient(left, #643986, #98aed5);
  	background: linear-gradient(to right, #643986, #98aed5);
  	font-family: 'Roboto', sans-serif;
}
.container {
	margin: 20px;
	padding: 60px;
	max-width: 1280px;
}
thead{
  background-color: rgba(255,255,255,0.3);
 }
tbody{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 15px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 400;
  font-size: 15px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}
h1{
color: white;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Exam Result</h1>
		</div>
		<div class="text-center">
			<table class="table table-bordered" style="width: 100%">
				<tr>
					<th>Total Solved Question:</th>
					<td><c:out value="${totalSolvedQuestion}" /></td>
				</tr>
				<tr>
					<th>Total Correct Answer</th>
					<td><c:out value="${totalCorrectAnswer}" /></td>
				</tr>
				<tr>
					<th>Total Incorrect Answer</th>
					<td><c:out value="${totalIncorrectAnswer}" /></td>
				</tr>
				<tr>
					<th>Status</th>
					<td id="status"><c:out value="${status}" /></td>
				</tr>
			</table>
		</div>
		<div class="text-center">
			<h3>
				<a class="dropdown-item"
					href="${pageContext.request.contextPath}/studentLogout"
					role="button">Click to Logout From DashBoard</a>
			</h3>
		</div>
	</div>
	<script type="text/javascript">
		var a = document.getElementById("status");
		if(a.innerHTML == "Failed"){
			a.style.color = "red";
			a.style.fontSize = "larger";
			a.style.backgroundColor = "white";
			a.style.fontWeight = "600";
		}
	</script>
</body>
</html>