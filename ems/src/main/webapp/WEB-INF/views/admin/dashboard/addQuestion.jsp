<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	border: 1px solid black;
	display: inline-block;
	position: relative;
	top: 2px;
	margin-right: 7px;
}

[type="radio"]:checked+span:before {
	content: "\2611";
	position: absolute;
	top: -5px;
	left: -3px;
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
</style>
</head>
<body>
	<div class="container">
		<div class="add-question-form">
			<form action="addQuestionForm" method="get">
				<div class="form-group">
					<label>Question</label> <input type="text" class="form-control"
						id="question" name="question">
				</div>
				<div class="form-group">
					<label>Multiple Choice Answer</label>
					<div class="form-check  form-check-inline">
						<input class="form-check-input" type="radio" name="answerButton"
							id="radioButton" onclick="getAnswerButton(this.value)"
							value="radio" checked> <label class="form-check-label">Radio
							Buttons</label>
					</div>
					<div class="form-check  form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="answerButton"
							id="checkButton" onclick="getAnswerButton(this.value)"
							value="checkbox"><span></span>Check Boxes
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="answer-option">
						<p id="options">
							Options: <input id="option1" class="form-control" type="text"
								name="questionOption" placeholder="option 1"> <input
								id="option2" class="form-control" type="text"
								name="questionOption" placeholder="option 2">
						</p>
					</div>
					<div class="text-center">
						<input type="button" id="addOption" value="Add Options"
							class="btn btn-primary">
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
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>

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
								<th scope="col">Edit</th>
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
													name="answerButtonTable" value="${option.count}" id="correctAnswer${option.count}">
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
									<td><a role="button"
										href="${pageContext.request.contextPath}/addQuestion/report/${que.id}">Edit</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/question.js"/>"></script>
</body>
</html>