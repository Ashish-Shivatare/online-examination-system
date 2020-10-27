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
.container {
	padding: 50px;
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