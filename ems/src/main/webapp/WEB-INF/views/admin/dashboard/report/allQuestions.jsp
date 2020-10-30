<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Report Add Question</title>
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
	padding: 50px;
}
.all-show-question {
	padding: 20px;
}
#questionRow {
	text-align: left;
}
#questionOptionRow {
	padding-left: 40px;
}
#answerButtonTable {
	padding-right: 10px;
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
		<div class="all-show-question">
			<div class="text-center">
				<h1>All Added Questions</h1>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Question</th>
								<th scope="col">Correct Answer</th>
								<th scope="col">Question Type</th>
								<th scope="col">Update</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="que" items="${allQuestionList}">
								<tr>
									<td><c:out value="${que.id}" /></td>
									<td id="questionRow"><c:out value="${que.question}" /> <c:forEach
											var="options" items="${que.questionOption}"
											varStatus="option">
											<div id="questionOptionRow" class="row">
												<input class="form-check-input" type="${que.answerButton}"
													name="answerButtonTable" value="${option.count}"
													id="correctAnswer${option.count}">
												<c:out value="${options}" />
											</div>
										</c:forEach></td>
									<td><c:forEach var="correctAnswer"
											items="${que.correctAnswer}">
											<div id="questionOptionRow" class="row">
												<c:out value="${correctAnswer}" />
											</div>
										</c:forEach></td>
									<td><c:out value="${que.questionType}" /></td>
									<td><a id="update" role="button" href="${pageContext.request.contextPath}/admin/addQuestion/report/update/${que.id}">Update</a></td>
									<td><a id="delete" role="button" href="${pageContext.request.contextPath}/admin/addQuestion/delete/${que.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>