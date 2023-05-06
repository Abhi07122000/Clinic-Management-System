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
<%@ page import="com.dao.DoctorDao"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.Doctor"%>
</head>
<body>
	<%@include file="navbar.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor's Detail</p>
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDao dao = new DoctorDao(DBConnect.getConn());
						Doctor d = dao.getDoctorById(id);				
						%>
											
						
						<form action="../updateDoctor" method="post">
							
							<div class="mb-3">
								<label class="form-label">Doctor's Name</label> <input required
									name="name" type="text" class="form-control"
									value="<%=d.getName()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input required
									name="age" type="text" class="form-control"
									value = "<%=d.getAge() %>">
							</div>
							<div class="mb-3">
							<label class="form-label">Specialisation</label>
								<select class="form-select" aria-label="Default select example"
									name="specialisation">
									<option selected><%= d.getSpecialisation() %></option>
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
									value = "<%= d.getExperience() %>">
							</div>
							<div class="mb-3">
							<label class="form-label">Availability</label>
								<select class="form-select" aria-label="Default select example"
									name="availability">
									<option selected><%= d.getAvailability() %></option>
									<option value="Yes">Yes</option>
									<option value="No">No</option>
									<option value="Not Sure">Not Sure</option>
								</select>
							</div>
							<input type = "hidden" name = "id" value = "<%= d.getId() %>">
							<button type="submit" class="btn bg-success text-white col-md-4 offset-md-4">Update</button>
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>