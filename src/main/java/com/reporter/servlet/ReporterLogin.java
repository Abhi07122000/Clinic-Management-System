package com.reporter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/reporterLogin")
public class ReporterLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			//HttpSession session = req.getSession();
			
			UserDao dao = new UserDao(DBConnect.getConn());
			User user = dao.Rlogin(email, password);

			if (user != null){
				// session.setAttribute("adminObj", user);
				resp.sendRedirect("reporter/Rindex.jsp");
			} else {
				//resp.sendRedirect("admin_login.jsp");
				//System.out.println("Invalid UserName and password");
				//PrintWriter out = resp.getWriter();
				//out.print("Enter Valid details");
				
				req.setAttribute("errorMessage", "Invalid user or password");
				req.getRequestDispatcher("reporter_login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
