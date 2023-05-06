package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@WebServlet("/addAppointment")
public class AddAppointment extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int userID = Integer.parseInt(req.getParameter("userid"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String gender = req.getParameter("gender");
			String address = req.getParameter("address");
			String ailment = req.getParameter("ailment");
			int doctorID = Integer.parseInt(req.getParameter("doctorID"));
			String date = req.getParameter("date" );
			int contactno = Integer.parseInt(req.getParameter("contactno"));
			String status = req.getParameter("status");
			
			Appointment a = new Appointment(userID,name,age,gender,address,ailment,doctorID,date,contactno,"pending");
			
			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean f = dao.addAppointment(a);
			
			if(f) {
				session.setAttribute("success_msg", "Registered Succesfully");
				//resp.sendRedirect("admin_login.jsp");
				resp.sendRedirect("patient/Pindex.jsp");
			}else {
				System.out.println("Cant register");
				req.setAttribute("errorMessage", "Invalid user or password");
				req.getRequestDispatcher("patient_login.jsp").forward(req, resp);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
