<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Patient</title>
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
			<div class="col-md-10 offset-md-1 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 fw-bold text-center text-success">Your Appointment's</p>
						<table class="table ">
							<thead class="thead-dark">
								<tr>
									<th scope="col">id</th>
									<th scope="col">Full Name</th>
									<th scope="col">Age</th>
									<th scope="col">Gender</th>
									<th scope="col">Addresss</th>
									<th scope="col">Ailment</th>
									<th scope="col">Doctor Details</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Contact Details</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("patientObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
								List<Appointment> list = dao.getAllAppointmentById(user.getId());
								for (Appointment ap : list) {
									dao2.getDoctorById(ap.getDoctorID());
								%>
								<tr>
									<th><%=ap.getId()%></th>
									<th><%=ap.getName()%></th>
									<th><%=ap.getAge()%></th>
									<th><%=ap.getGender()%></th>
									<th><%=ap.getAddress()%></th>
									<th><%=ap.getAilment()%></th>
									<th><%=ap.getDoctorID()%></th>
									<th><%=ap.getDate()%></th>
									<th><%=ap.getContactno()%></th>
									
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {%> 
										<a href="#" class="btn btn-warning" >Pending</a> 
										<%} else {%>
											<%=ap.getStatus()%> <%
 										}%>
									</td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>