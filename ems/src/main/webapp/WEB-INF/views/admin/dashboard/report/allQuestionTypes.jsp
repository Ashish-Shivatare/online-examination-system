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
.container {
	padding: 70px;
}
#delete{
color:red;
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
								<td><a role="button" href="${pageContext.request.contextPath}/questionType/update/${que.questionType}/${que.id}">Update</a></td>
								<td><a role="button" href="${pageContext.request.contextPath}/questionType/delete/${que.id}" id="delete">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</body>
</html>