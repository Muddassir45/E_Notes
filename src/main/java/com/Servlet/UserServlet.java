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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDeatails userDetails = new UserDeatails();
		userDetails.setName(name);
		userDetails.setEmail(email);
		userDetails.setPasssword(password);

		UserDao userDao = new UserDao(DBConnect.getCOnn());
		boolean isUserAdded = userDao.addUser(userDetails);
		HttpSession session;
		if (isUserAdded) {
			session = request.getSession();
			session.setAttribute("reg-success", "Reggistration Successfully..");
			response.sendRedirect("register.jsp");
		} else {
			session = request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on Server");
			response.sendRedirect("register.jsp");
		}
	}
}
