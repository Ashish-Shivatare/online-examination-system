<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:ital,wght@0,300;0,600;0,618;0,680;0,793;1,577&display=swap"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/registration.css"/>"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form:form action="registrationForm" method="post"
			modelAttribute="student">
			<div class="form-group">
				<h4 id="signUp">Student Sign Up</h4>
			</div>

			<div class="form-group">
				<input name="name" placeholder="Name" class="form-control" />
				<form:errors path="name" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="email" type="text" placeholder="Email"
					class="form-control" />
				<form:errors path="email" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="mobileNo" type="text" placeholder="Mobile No"
					class="form-control" />
				<form:errors path="mobileNo" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="higherEducation" type="text"
					placeholder="Higher Education" class="form-control" />
				<form:errors path="higherEducation" cssClass="error" />
			</div>

			<div class="form-group">
				<div class="form-check  form-check-inline">
					<label class="form-check-label"> <input name="gender"
						type="radio" class="form-check-input" checked /><span>Male</span>
					</label>
				</div>

				<div class="form-check  form-check-inline">
					<label class="form-check-label"> <input name="gender"
						type="radio" class="form-check-input" /><span>Female</span>
					</label>
				</div>
				<form:errors path="gender" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="dob" type="text" placeholder="Date of Birth"
					class="form-control" />
				<form:errors path="dob" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="address" type="text" placeholder="Address"
					class="form-control" />
				<form:errors path="address" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="city" type="text" placeholder="City"
					class="form-control" />
				<form:errors path="city" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="country" type="text" placeholder="Country"
					class="form-control" />
				<form:errors path="country" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="panCard" type="text" placeholder="Pan Card"
					class="form-control" />
				<form:errors path="panCard" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="higherEducationCertificate" type="text"
					placeholder="Higher Education Certificate" class="form-control" />
				<form:errors path="higherEducationCertificate" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="registrationDate" type="text"
					placeholder="Registration Date" class="form-control" />
				<form:errors path="registrationDate" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="password" type="password" placeholder="Password"
					class="form-control" />
				<form:errors path="password" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="confirmPassword" type="Password"
					placeholder="Confirm Password" class="form-control" />
				<form:errors path="confirmPassword" cssClass="error" />
			</div>

			<div id="checkbox" class="form-group">
				<label><input name="agree" type="checkbox" value="true" /><span></span>
					I agree to all </label><span id="terms">Terms</span>
				<form:errors path="agree" cssClass="error" />
			</div>

			<div class="form-group">
				<button class="btn btn-primary btn-block btn-lg">SIGN UP</button>
			</div>
			<div class="form-group">
				<h6 id="account">
					Already have an account?<a href="studentLogin"><span
						id="signIn"> Sign In</span></a>
				</h6>
			</div>
		</form:form>
	</div>
</body>
</html>
