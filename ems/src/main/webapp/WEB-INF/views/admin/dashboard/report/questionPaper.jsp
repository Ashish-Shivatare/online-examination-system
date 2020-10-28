<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Question Paper</title>
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
.table-responsive {
    overflow-x: initial;
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
	padding: 60px;
}
.all-paper-question {
	padding: 20px;
}
.questionRow {
	text-align: left;
}
.row.question-option {
	padding-left: 40px;
}
.row.answer-option {
	padding-left: 40px;
}
.row.correct-answer-option {
	padding-left: 40px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="all-paper-question">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Question & Options</th>
							<th scope="col">QuestionType</th>
							<th scope="col">Selected Answer</th>
							<th scope="col">Correct Answer</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="st" items="${student.answer}" varStatus="id">
							<tr>
								<td><c:out value="${id.count}" /></td>
								<td class="questionRow"><c:out value="${st.question}" /> 
									<c:forEach var="options" items="${st.allOptions}" varStatus="option">
										<div class="row question-option">
											<input class="form-check-input" type="${st.answerButton}"
												name="answerButtonTable" value="${option.count}"
												id="correctAnswer${option.count}">
											<c:out value="${options}" />
										</div>
									</c:forEach>
								</td>
								<td><c:out value="${st.questionType}" /></td>
								<td>
									<c:forEach var="selectedAnswer" items="${st.selectedAnswer}">
										<div class="row answer-option">
											<c:out value="${selectedAnswer}" />
										</div>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="question" items="${questionList}">
										<c:if test="${question.id == st.questionId}">
												<c:set var="correctOptionsList" value="${question.correctAnswer}"/>
										</c:if>
									</c:forEach>
									<c:forEach var="correctAnswer" items="${correctOptionsList}">
										<div class="row correct-answer-option">
											<c:out value="${correctAnswer}"></c:out>
										</div>
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>