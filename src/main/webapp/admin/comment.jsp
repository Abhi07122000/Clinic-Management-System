<%@page import="com.entity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page import="com.dao.DoctorDao"%>
<%@ page import="com.entity.Doctor"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Patient</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AppointmentDao dao = new AppointmentDao(DBConnect.getConn());

						Appointment ap = dao.getAppointmentById(id);
						%>
						<form class="row" action="../updateStatus" method="post">
							<div class="col-md-6">
								<label>Patient Name</label> <input type="text" readonly
									value="<%=ap.getName() %>" class="form-control">
							</div>

							<div class="col-md-6">
								<label>Age</label> <input type="text" value="<%=ap.getAge()%>"
									readonly class="form-control">
							</div>


							<div class="col-md-6">
								<br> <label>Mob No</label> <input type="text" readonly
									value="<%=ap.getContactno() %>" class="form-control">
							</div>

							<div class="col-md-6">
								<br> <label>Ailment</label> <input type="text" readonly
									value="<%=ap.getAilment() %>" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Select Doctor</label> <select
									class="form-select" aria-label="Default select example"
									>
									<option selected>Select Doctor</option>
									<%
									DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
									List<Doctor> list = dao2.getAllDoctor();
									for (Doctor d : list) {
									%>
									<option value= "<%=d.getId() %>" ><%=d.getName()%> (<%=d.getSpecialisation()%>)</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="col-md-12">
								<br> <label>Comment</label>
								<textarea required name="comment" class="form-control"
									cols=""></textarea>
							</div>

							<input type="hidden" name="id" value="<%=ap.getId()%>"> <input
								type="hidden" name="doctorID" value="<%=ap.getDoctorID() %>">

							<button class=" mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>