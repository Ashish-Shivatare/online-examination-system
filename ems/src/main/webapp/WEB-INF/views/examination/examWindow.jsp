<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Window</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/examwindow.css"/>" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="col exam-center-heading">
			<h1>
				<b>Online Examination Center Name</b>
			</h1>
			<h5 id="address">Address :</h5>
			<h3>
				<b>Exam For-</b>
			</h3>
		</div>

		<hr id="firstLine" />
		<hr id="secondLine" />

		<div class="col date-time">
			<div class="d-flex">
				<div class="mr-auto p-2">
					<h4 id="date">Date: <c:out value="${date}" /></h4>
				</div>
				<div class="p-2">
					<h4 id="time">
						Time: <span id="examTimer"></span> Min
					</h4>
				</div>
			</div>

			<div id="questionNo" class="d-flex">
				<div class="mr-auto p-2">
					<h4>
						<b>Question <span id="questionNumber"><c:out value="${questionNumber}" /></span></b>
					</h4>
				</div>
			</div>

			<div class="d-flex">
				<div class="mr-auto p-2">
					<h4 id="question">
						<c:out value="${que.question}" />
					</h4>
				</div>
			</div>

			<div id="options" class="d-flex">
				<div class="mr-auto p-2">
					<div class="question-option">
						<c:forEach var="opt" items="${que.questionOption}"
							varStatus="myIndex">
							<div id="allOptions" class="h4 mb-0">
								<label><input
									type="<c:out value="${que.answerButton}" />"
									name="selectedAnswer" value="${myIndex.count}" /><span
									class="${que.answerButton}"></span><c:out value="${opt}" /></label>
							</div>
						</c:forEach>
					</div>
				</div>
				
				<div class="p-2">
					<button type="button" id="nextButton" class="btn next-button">Next</button>
				</div>
			</div>

		</div>
		<div class="col show-question">
			<h6 id="showQuestion">Showing question <span id="showQuestionNo"><c:out value="${questionNumber}" /></span> of <c:out value="${totalQuestions}" /></h6>
		</div>
	</div>
	<script type="text/javascript"> var queId = ${que.id}; var queOptions = '${que.questionOption}'; var queType = '${que.questionType}'; 
	</script>
	<script src="<c:url value="/resources/js/nextquestion.js"/>"></script>
	<script src="<c:url value="/resources/js/exam.js"/>"></script>
</body>
</html>