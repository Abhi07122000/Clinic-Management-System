<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Registration</p>
						<!--  			<c:if test="${not empty suc_msg }">
							<p class="text-center text-success fs-3">${suc_msg}</p>
							<c:remove var="suc_msg" scope = "session"/>
						</c:if>
						<c:if test="${not empty error_msg }">
							<p class="text-center text-danger fs-3">${error_msg}</p>
							<c:remove var="error_msg" scope = "session"/>
						</c:if>  -->
						<form action="user_register" method="post">
							<div class="mb-3">
							<select class="form-select" aria-label="Default select example" name = "role">
								<option selected>Select your position</option>
								<option value="patient">Patient</option>
								<option value="reporter">Reporter</option>
								<option value="admin">Admin</option>
							</select>
							</div>  

							<div class="mb-3">
								<label class="form-label">Full Name</label> <input required
									name="fullname" type="text" class="form-control"
									placeholder="Enter Full Name">
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input required
									name="email" type="email" class="form-control"
									placeholder="Enter Email Address">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control"
									placeholder="Enter Password">
							</div>

							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>
						<br>Don't have an account?<a href="signup.jsp"
							class="text-decoration-none"> Create One</a>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>