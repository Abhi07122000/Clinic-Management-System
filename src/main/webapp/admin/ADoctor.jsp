<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor's Registration</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
	<%@include file="navbar.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor's Registration</p>
						
						<form action="../addDoctor" method="post">
							
							<div class="mb-3">
								<label class="form-label">Doctor's Name</label> <input required
									name="name" type="text" class="form-control"
									placeholder="Enter Doctor's Full Name">
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input required
									name="age" type="text" class="form-control"
									placeholder="Enter Doctor's Age">
							</div>
							<div class="mb-3">
							<label class="form-label">Specialisation</label>
								<select class="form-select" aria-label="Default select example"
									name="specialisation">
									<option selected>Select Doctor's Specialisation</option>
									<option value="Physicians">Physicians</option>
									<option value="Dermatalogist">Dermatalogist</option>
									<option value="Cardiologists">Cardiologists</option>
									<option value="Surgeon">Surgeon</option>
									<option value="Dentist">Dentist</option>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Experience in Year</label> <input required
									name="experience" type="text" class="form-control"
									placeholder="Enter Doctor's Experience in Years">
							</div>
							<div class="mb-3">
							<label class="form-label">Availability</label>
								<select class="form-select" aria-label="Default select example"
									name="availability">
									<option selected>Select Doctor's Availability</option>
									<option value="Yes">Yes</option>
									<option value="No">No</option>
									<option value="Not Sure">Not Sure</option>
								</select>
							</div>

							<button type="submit" class="btn bg-success text-white col-md-4 offset-md-4">Register</button>
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>