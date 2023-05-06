<%@ page import="com.dao.DoctorDao"%>

<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.Doctor"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fix your Appointment</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-5">
		<div class="row">
			<div class="col-md-4 p-5 ">
				
					<div class="card-body">
						<p class="fs-1 text-center">Fix your Appointment here</p>
					</div>
				
			</div>
			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Appointment Details</p>

						<form action="../addAppointment" method="post">
						
						<input type = "hidden" name = "userid" value="${patientObj.id}">														

							<div class="mb-3">
								<label class="form-label">Patient's Name</label> <input required
									name="name" type="text" class="form-control"
									placeholder="Enter your Full Name">
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input required name="age"
									type="text" class="form-control" placeholder="Enter your Age">
							</div>
							<div class="mb-3">
								<label class="form-label">Gender</label> <select
									class="form-select" aria-label="Default select example"
									name="gender">
									<option selected>Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="Not to Specify">Not to Specify</option>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input required
									name="address" type="text" class="form-control"
									placeholder="Enter your Address">
							</div>
							<div class="mb-3">
								<label class="form-label">Ailment</label> <select
									class="form-select" aria-label="Default select example"
									name="ailment">
									<option selected>Select your ailment</option>
									<option value="Fever">Fever</option>
									<option value="Dermatalogy">Dermatalogy</option>
									<option value="Cardiology">Cardiology</option>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Select Doctor</label> <select
									class="form-select" aria-label="Default select example"
									name="doctorID">
									<option selected>Select Doctor</option>
									<%
									DoctorDao dao = new DoctorDao(DBConnect.getConn());
									List<Doctor> list = dao.getAllDoctor();
									for (Doctor d : list) {
									%>
									<option value= "<%=d.getId() %>" ><%=d.getName()%> (<%=d.getSpecialisation()%>)</option>
									<%
									}
									%>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Date of Appointement</label> <input
									required name="date" type="date" class="form-control"
									placeholder="Select from here">
							</div>
							<div class="mb-3">
								<label class="form-label">Contact Details</label> <input
									required name="contactno" type="text" class="form-control"
									placeholder="Enter your Contact Number">
							</div>
							
							<button type="submit"
								class="btn bg-success text-white col-md-4 offset-md-4">Register</button>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>