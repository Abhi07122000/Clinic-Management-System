package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int doctorID = Integer.parseInt(req.getParameter("doctorID"));
			String comment = req.getParameter("comment");
			
			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			
			if(dao.updateCommentStatus(id, doctorID, comment)) {
				session.setAttribute("successMsg", "Comment Updated");
				resp.sendRedirect("admin/suggestDoctor.jsp");
			}else {
				session.setAttribute("errorMsg", "Comment Not Updated");
				resp.sendRedirect("admin_login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
