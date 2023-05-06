package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String name = req.getParameter("name");
			int age = Integer.valueOf(req.getParameter("age"));
			String specialisation = req.getParameter("specialisation");
			int experience = Integer.valueOf(req.getParameter("experience"));
			String availability = req.getParameter("availability" );
			int id = Integer.parseInt(req.getParameter("id"));
			
			Doctor d = new Doctor(id,name,age,specialisation,experience,availability);
			
			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			boolean f = dao.updateDoctorDetais(d);
			
			if(f) {
				//session.setAttribute("suc_msg", "Registered Succesfully");SuccessfullyLogin.jsp
				//resp.sendRedirect("admin_login.jsp");
				resp.sendRedirect("admin/viewDoctor.jsp");
			}else {
				System.out.println("Cant register");
				req.setAttribute("errorMessage", "Invalid user or password");
				req.getRequestDispatcher("admin_login.jsp").forward(req, resp);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
