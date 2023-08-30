package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.PostDao;
import com.Db.DBConnect;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer noteid = Integer.parseInt(request.getParameter("note_id"));
		PostDao dao = new PostDao(DBConnect.getCOnn());
		boolean isdelete = dao.deleteNote(noteid);
		HttpSession session = null;
		if (isdelete) {
			session = request.getSession();
			session.setAttribute("deleteMsg", "Notes Delete Succssfully..!!");
			response.sendRedirect("showNotes.jsp");
		} else {
			session = request.getSession();
			session.setAttribute("wrongMsg", "Something  Wrong on Server");
			response.sendRedirect("showNotes.jsp");
		}
	}

}
