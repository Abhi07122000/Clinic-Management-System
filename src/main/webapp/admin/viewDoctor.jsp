<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%@ page import="com.dao.DoctorDao"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.Doctor"%>
<%@ page import="java.util.List"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor's Details</p>
						<table class="table table-bordered border-primary table-secondary">
							<thead class="thead-dark">
								<tr>
									<th scope="col">id</th>
									<th scope="col">Name</th>
									<th scope="col">Age</th>
									<th scope="col">Specialisation</th>
									<th scope="col">Experience</th>
									<th scope="col">Availability</th>
									<th scope="col">Operations</th>
								</tr>
							</thead>
							<tbody>

								<%
								DoctorDao dao = new DoctorDao(DBConnect.getConn());
								List<Doctor> list = dao.getAllDoctor();
								for (Doctor d : list) {
								%>
								<tr>
									<td><%=d.getId()%></td>
									<td><%=d.getName()%></td>
									<td><%=d.getAge()%></td>
									<td><%=d.getSpecialisation()%></td>
									<td><%=d.getExperience()%></td>
									<td><%=d.getAvailability()%></td>
									
									<td><a href ="editDoctor.jsp?id=<%=d.getId()%>"
										class = "btn  btn-primary">Edit</a>
										<a href= "../deleteDoctor?id=<%=d.getId()%>"
										class = "btn btn-danger">Delete</a>
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