<%@page import="com.User.Post"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.Dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
UserDeatails user1 = (UserDeatails) session.getAttribute("userDet");
if (user1 == null) {
    response.sendRedirect("login.jsp");
    session.setAttribute("Login-error", "Please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
<%
Integer noteid = Integer.parseInt(request.getParameter("note_id"));

PostDao dao = new PostDao(DBConnect.getCOnn());
Post p = dao.getDataById(noteid);
%>
    <div class="container-fluid">
        <%@ include file="all_component/navbar.jsp"%>
        <h1 class="text-center">Edit Your Notes</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="NotesEditServlet" method="post">
                        <input type="hidden" value="<%=noteid%>" name="noteid">

                        <div class="form-group">
                            <% 
                            UserDeatails us = (UserDeatails) session.getAttribute("userDet");
                            if (us != null) {
                            %>
                            <input type="hidden" value="<%=us.getId()%>" name="uid">
                            <%
                            }
                            %>

                            <label for="exampleInputEmail1">Enter title</label>
                            <input type="text" name="title" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" required="required" value="<%=p.getTitle() %>">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputContent">Enter Content</label>
                            <textarea rows="9" cols="50" class="form-control" name="content"
                                required="required"><%=p.getContent() %></textarea>
                        </div>

                        <div class="container text-center">
                            <button type="submit" class="btn btn-primary">Update Notes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="all_component/footer.jsp"%>
</body>
</html>
