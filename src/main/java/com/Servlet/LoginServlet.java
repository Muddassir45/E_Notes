package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Db.DBConnect;
import com.User.UserDeatails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		UserDeatails us = new UserDeatails();
		us.setEmail(email);
		us.setPasssword(password);
		UserDao dao = new UserDao(DBConnect.getCOnn());
		UserDeatails user = dao.loginUser(us);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userDet", user);
			response.sendRedirect("home.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "invalid UsearName and Password");
			response.sendRedirect("login.jsp");
		}
	}

}
