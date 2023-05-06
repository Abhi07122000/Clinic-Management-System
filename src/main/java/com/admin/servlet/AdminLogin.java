package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			//String role = req.getParameter("role");

			//HttpSession session = req.getSession();
			
			UserDao dao = new UserDao(DBConnect.getConn());
			User user = dao.login(email, password);

			if (user != null){
				// session.setAttribute("adminObj", user);
				resp.sendRedirect("admin/Aindex.jsp");
			} else {
				//resp.sendRedirect("admin_login.jsp");
				//System.out.println("Invalid UserName and password");
				//PrintWriter out = resp.getWriter();
				//out.print("Enter Valid details");
				
				req.setAttribute("errorMessage", "Invalid user or password");
				req.getRequestDispatcher("admin_login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
