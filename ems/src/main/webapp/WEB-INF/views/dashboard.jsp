<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<script src="<c:url value="/resources/vendor/chart.js/Chart.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/dashboard.css"/>" type="text/css" />
</head>

<body>
	<div class="shadow p-3 mb-5 bg-white rounded">
		<nav class="navbar navbar-expand-lg navbar-expand-md navbar-expand-sm">
			<a class="nav-link" href="#" role="button"> <i id="searchIcon"
				class="material-icons">search</i> <path fill-rule="evenodd"
					d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
				<path fill-rule="evenodd"
					d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
				</svg>
			</a> <a class="nav-link" href="#" role="button"> <i
				class="fas fa-th-large"></i>
			</a> <img id="logoImage" src="<c:url value="/resources/image/logo.png"/>" />
			<ul class="navbar-nav ml-auto">
				<li><a class="nav-link" href="#" aria-haspopup="true"
					aria-expanded="false"> <i id="chatIcon" class="material-icons">chat_bubble</i>
						<i id="chatBadge" class="fas fa-circle"></i>
				</a></li>
				<li><a class="nav-link" href="#" aria-haspopup="true"
					aria-expanded="false"> <i id="emailIcon" class="material-icons">email</i>
						<i id="emailBadge" class="fas fa-circle"></i>
				</a></li>
				<li class="nav-item dropdown no-arrow"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
						class="img-profile rounded-circle"
						src="<c:url value="/resources/image/my_image.jpg"/>" />
				</a>
					<div
						class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="logout">Logout</a> <a
							class="dropdown-item" href="#">My Account</a>
					</div></li>
			</ul>
		</nav>
	</div>

	<nav class="navbar navbar-expand-lg navbar-expand-md navbar-expand-sm">
		<a class="nav-link" href="#" role="button"> <img
			class="dashboard-img"
			src="<c:url value="/resources/image/dashboard.svg"/>" /> <span
			id="dashboardText">Dashboard</span>
		</a> <a class="nav-link" href="#" role="button"> <i
			class="material-icons management-option-img">widgets</i> <span
			id="managementOption">Question Type</span>
		</a> <a class="nav-link" href="#" role="button"> <img
			class="add-question-img"
			src="<c:url value="/resources/image/bullseye-grey.svg"/>" /> <span
			id="addQuestion">Add Questions</span>
		</a> <a class="nav-link" href="#" role="button"> <i
			class="fas fa-table"></i> <span id="studentDetails">Student
				Details</span>
		</a> <a class="nav-link" href="#" role="button"> <svg width="1em"
				height="1em" viewBox="0 0 16 16" class="report-img"
				fill="currentColor" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd"
					d="M4 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V5.707A1 1 0 0 0 13.707 5L10 1.293A1 1 0 0 0 9.293 1H4zm5 1v3a1 1 0 0 0 1 1h3L9 2z" />
        </svg> <span id="reportText">Report</span>
		</a>
	</nav>

	<div class="container-fluid">

		<div class="row">
			<div class="col-xl-4 col-md-8 mb-4">
				<div class="card">
					<div class="row">
						<div class="col-auto">
							<img class="total-students-img"
								src="<c:url value="/resources/image/user.svg"/>" />
						</div>
						<div class="col">
							<div class="h5 mb-0">
								<c:out value="${totalStudents}"></c:out>
							</div>
							<span id="totalStudents">Total Registered Students</span>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xl-4 col-md-8 mb-4">
				<div class="card">
					<div class="row">
						<div class="col-auto">
							<img class="total-questions-img"
								src="<c:url value="/resources/image/bullseye-white.svg"/>" />
							</svg>
						</div>
						<div class="col">
							<div class="h5 mb-0">
								<c:out value="${totalQuestions}"></c:out>
							</div>
							<span id="totalQuestions">Total Questions Added</span>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xl-4 col-md-8 mb-4">
				<div class="card">
					<div class="row">
						<div class="col-auto">
							<i class="material-icons total-pass-img">thumb_up</i>
						</div>
						<div class="col">
							<div class="h5 mb-0">
								<c:out value="${totalPass}"></c:out>
							</div>
							<span id="totalPass">Total Pass Students</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xl-4 col-md-4 mb-4">
				<div class="card">
					<div class="h5 mb-0">
						Pass/Failed Students
						<div class="h6 mb-0">Total Pass Failed Students Count</div>
					</div>
					<div class="student-donut-chart">
						<canvas id="studentDonutChart"></canvas>
					</div>
				</div>
			</div>

			<div class="col-xl-8 col-md-8 mb-8">
				<div class="card">
					<div class="h5 mb-0">Yearly Pass/Failed Student</div>
					<div class="student-bar-chart">
						<canvas id="studentBarChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"> 
		var labelArray = ${donutLabelArray};
		var valueArray = ${donutValueArray};
		
		var passValueArray = ${passValueArray};
		var failedValueArray = ${failedValueArray};
		var totalValueArray = ${totalValueArray};
		
		
	</script>
	<script src="<c:url value="/resources/js/donutchart.js"/>"></script>
	<script src="<c:url value="/resources/js/barchart.js"/>"></script>
</body>
</html>
