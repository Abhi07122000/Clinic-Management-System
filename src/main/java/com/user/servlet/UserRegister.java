package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String role = req.getParameter("role");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password" );
			
			User u = new User(role,fullname,email,password);
			
			UserDao dao = new UserDao(DBConnect.getConn());
			
			boolean f = dao.register(u);
			
			HttpSession session = req.getSession();
			
			RequestDispatcher dispatcher = null;
			dispatcher = req.getRequestDispatcher(password);
			
			if(f) {
				//session.setAttribute("suc_msg", "Registered Succesfully");SuccessfullyLogin.jsp
				//session.setAttribute("userObj", user);
				resp.sendRedirect("SuccessfullyLogin.jsp");
			}else {
				System.out.println("Cant register");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
