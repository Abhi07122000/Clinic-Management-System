package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.db.DBConnect;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		boolean f = dao.deleteDoctor(id);
		
		if(f) {
			//session.setAttribute("suc_msg", "Registered Succesfully");SuccessfullyLogin.jsp
			//resp.sendRedirect("admin_login.jsp");
			resp.sendRedirect("admin/viewDoctor.jsp");
		}else {
			System.out.println("Cant register");
			req.setAttribute("errorMessage", "Invalid user or password");
			req.getRequestDispatcher("admin_login.jsp").forward(req, resp);
		}	
	}
	
}
