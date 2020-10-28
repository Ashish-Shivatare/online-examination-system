<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
body {
	background: linear-gradient(120grad, #643986, #98aed5);
	font-family: "Roboto";
	color: white;
	font-size: 17px;
	height: auto;
}

.btn-outline-primary {
	border-color: #643986;
	color: #643986;
	background-color: white;
}

.btn-outline-warning {
	border-color: #643986;
	color: #643986;
	background-color: white;
}

.h1 {
	padding: 20px;
}

.container {
	padding: 60px;
	padding-top: 80px;
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
	border: 1px solid black;
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

.error {
	color: red;
}
</style>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Update Question</h1>
		</div>
		<div class="update-question-form">
			<form:form action="updateForm" method="post"
				modelAttribute="updateQuestion">
				<div class="form-group">
					<label>Question Id</label> <input type="text" class="form-control"
						name="id" value="${que.id}" readonly>
				</div>
				<div class="form-group">
					<label>Question</label> <input type="text" class="form-control"
						id="question" name="question" value="${que.question}">
					<form:errors path="question" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Multiple Choice Answer</label>
					<div class="form-check  form-check-inline">
						<input class="form-check-input" type="radio" name="answerButton"
							id="radioButton" onclick="getAnswerButton(this.value)"
							value="radio"> <label class="form-check-label">Radio
							Buttons</label>
					</div>
					<div class="form-check  form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="answerButton"
							id="checkButton" onclick="getAnswerButton(this.value)"
							value="checkbox" checked><span></span>Check Boxes
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="answer-option">
						<p id="options">
							Options:
							<form:errors path="questionOption" cssClass="error" />
							<c:forEach var="options" items="${que.questionOption}">
								<input id="option1" class="form-control" type="text"
									name="questionOption" placeholder="option 1" value="${options}">
							</c:forEach>
						</p>
					</div>
				</div>
				<div class="form-group">
					<label>Question Type</label> <select class="form-control"
						id="questionType" name="questionType">
						<c:forEach var="type" items="${questionTypeList}">
							<option value="${type.questionType}"><c:out
									value="${type.questionType}"></c:out></option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Correct Answer:</label>
					<div class="form-check  form-check-inline">
						<p id="correctAns">
							<c:forEach var="correctOption" begin="1"
								end="${fn:length(que.questionOption)}" varStatus="answerCount">
								<input class="form-check-input" type="${que.answerButton}"
									name="correctAnswer" id="correctAnswer${correctOption}"
									value="${answerCount.count}">
								<label class="form-check-label"><c:out
										value="${correctOption}" /></label>
							</c:forEach>
						</p>
					</div>
					<form:errors path="correctAnswer" cssClass="error" />
				</div>
				<div class="text-center">
					<a class="btn btn-outline-primary" role="button"
						href="${pageContext.request.contextPath}/addQuestion/report">Back</a>
					<button type="submit" class="btn btn-outline-warning">Update</button>
				</div>
			</form:form>
		</div>
	</div>
	<script type="text/javascript">
		var answerBtn = '${que.answerButton}';
		var queType = '${que.questionType}';
		var correctOpt = ${que.correctAnswer};
		for (var i = 0; i < correctOpt.length; i++) {
			document.getElementById("correctAnswer" + correctOpt[i]).checked = true;
		}
		if (answerBtn == 'radio') {
			document.getElementById("radioButton").checked = true;
		} else {
			document.getElementById("checkButton").checked = true;
		}
		document.getElementById("questionType").value = queType;
	</script>
	<script src="<c:url value="/resources/js/question.js"/>"></script>
</body>
</html>