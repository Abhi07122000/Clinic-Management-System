package com.reporter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporterLogout")
public class ReporterLogout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpSession session = req.getSession();
		// session.removeAttribute("adminObj");
		// session.setAttribute("succMsg", "Logout Succesfully");
		//resp.sendRedirect("reporter_login.jsp");
		
		req.getRequestDispatcher("reporter_login.jsp").forward(req, resp);


	}

}
