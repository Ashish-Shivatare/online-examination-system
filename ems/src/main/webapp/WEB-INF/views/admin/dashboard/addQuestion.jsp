<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
body {
	background: linear-gradient(120grad, #643986, #98aed5);
	font-family: "Roboto";
	color: white;
	font-size: 17px;
	height:auto; 
}
.error{
	color: red;
}
.container {
	padding: 50px;
}

.form-control {
	margin: 10px;
}

.form-check {
	padding-left: 20px;
}

.form-check-inline .form-check-input {
	margin-left: 20px;
}

label input {
	display: none;
}

label span {
	height: 15px;
	width: 15px;
	border: 1px solid white;
	display: inline-block;
	position: relative;
	top: 2px;
	margin-right: 7px;
}

[type="radio"]:checked+span:before {
	content: "\2713";
	position: absolute;
	top: -5px;
	left: 0px;
}

.btn-outline-primary {
	color: #643986;
	background-color: white;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Add Question</h1>
		</div>
		<div class="add-question-form">
			<form:form action="addQuestionForm" method="post" modelAttribute="question">
				<div class="form-group">
					<label>Question</label> <input type="text" class="form-control" value="${question.question}" name="question" placeholder="Enter Question"/>
						  <form:errors path="question" cssClass="error"/> 
				</div>
				<div class="form-group">
					<label>Multiple Choice Answer</label>
					<div class="form-check  form-check-inline">
						<input class="form-check-input" type="radio" name="answerButton"
							id="radioButton" onclick="getAnswerButton(this.value)"
							value="radio" checked>
							 <label class="form-check-label">Radio
							Buttons</label>
					</div>

					<div class="form-check  form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="answerButton"
							id="checkButton" onclick="getAnswerButton(this.value)"
							value="checkbox">
							<span></span>Check Boxes
						</label>
					</div>
				</div>

				<div class="form-group">
					<div class="answer-option">
						<p id="options">
							<label>Options:</label>
							<form:errors path="questionOption" cssClass="error"/> 
							 <input id="option1" class="form-control" type="text"
								name="questionOption" placeholder="option 1"> 
								<input
								id="option2" class="form-control" type="text"
								name="questionOption" placeholder="option 2"> 
						</p>
					</div>

					<div class="text-center">
					<input type="button" id="deleteOption" value="Delete Option"
							class="btn btn-outline-primary">
						
						<input type="button" id="addOption" value="Add Options"
							class="btn btn-outline-primary">
					</div>
				</div>

				<div class="form-group">
					<label>Question Type</label> <select class="form-control"
						id="questionType" name="questionType">
						<c:forEach var="type" items="${questionTypeList}">
							<option><c:out value="${type.questionType}"></c:out></option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label>Correct Answer:</label>
					<div class="form-check  form-check-inline">
						<p id="correctAns">
							<input class="form-check-input" type="radio" name="correctAnswer"
								id="correctAnswer1" value="1"> <label
								class="form-check-label">1</label> <input
								class="form-check-input" type="radio" name="correctAnswer"
								id="correctAnswer2" value="2"> <label
								class="form-check-label">2</label>
						</p>
					</div>
					<form:errors path="correctAnswer" cssClass="error"/> 
				</div>
				<div class="text-center">
					<a role="button" class="btn btn-outline-primary" href="dashboard">Back</a>
					<button type="submit" class="btn btn-outline-primary">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
	<script src="<c:url value="/resources/js/question.js"/>"></script>
</body>
</html>