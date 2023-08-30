package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.PostDao;
import com.Db.DBConnect;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		PostDao dao = new PostDao(DBConnect.getCOnn());
		boolean isNote = dao.addNotes(title, content, uid);
		if (isNote) {
			System.out.println("data inserted Succesfully");
			response.sendRedirect("showNotes.jsp");
		} else {
			System.out.println("Data not inserted");
		}
	}

}
