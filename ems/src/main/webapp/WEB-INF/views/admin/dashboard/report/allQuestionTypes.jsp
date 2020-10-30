<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Question Types</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
body{
	background: -webkit-linear-gradient(left, #643986, #98aed5);
  	background: linear-gradient(to right, #643986, #98aed5);
  	font-family: 'Roboto', sans-serif;
}
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
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
.container {
	padding: 70px;
}
#update, #delete{
	color: white;
}
#delete:hover{
	color: red;
}
#update:hover{
	color:blue;
}
</style>
</head>
<body>
   <div class="container">
   		<div class="text-center">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Question Type</th>
							<th scope="col">Update</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="que" items="${questionTypeList}">
							<tr>
								<td><c:out value="${que.id}" /></td>
								<td><c:out value="${que.questionType}" /></td>
								<td><a role="button" href="${pageContext.request.contextPath}/admin/questionType/update/${que.questionType}/${que.id}" id="update">Update</a></td>
								<td><a role="button" href="${pageContext.request.contextPath}/admin/questionType/delete/${que.id}" id="delete">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</body>
</html>