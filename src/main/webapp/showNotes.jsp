<%@page import="com.User.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.Dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
UserDeatails user4 = (UserDeatails) session.getAttribute("userDet");
if (user4 == null) {
    response.sendRedirect("login.jsp");
    session.setAttribute("Login-error", "Please Login");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
    <%@ include file="all_component/navbar.jsp"%>


<%
String updatemesg=(String)session.getAttribute("updateMsg");
if(updatemesg!=null){%>
<div class="alert alert-success" role="alert"><%=updatemesg%></div>
	<% 
	session.removeAttribute("updateMsg");
}
 %>
 
 <%
String wrongMsg=(String)session.getAttribute("wrongMsg");
if(wrongMsg!=null){%>
<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
	<% 
	session.removeAttribute("wrongMsg");
}
 %>

    <div class="container">
        <h2 class="text-center">All Notes:</h2>
        <div class="row">
            <div class="col-md-12">
                <%
                if (user4 != null) {
                    PostDao dao = new PostDao(DBConnect.getCOnn());
                    List<Post> list = dao.getData(user4.getId());
                    for (Post po : list) {
                %>
                <div class="card mt-3">
                    <img alt="" src="img/paper.png" class="card-img-top mat-2 max-auto"
                        style="max-width: 100px">

                    <div class="card-body p-4">

                        <h5 class="card-title"><%= po.getTitle() %></h5>
                        <p><%= po.getContent() %>.</p>

                        <p>
                            <b class="text-success">Published By: <%= user4.getName() %></b><br>
                            <b class="text-primary"></b>
                        </p>
                        <p>
                            <b class="text-success">Published Date: <%= po.getPdate() %></b><br>
                            <b class="text-primary"></b>
                        </p>

                        <div class="container text-center mt-2">
                            <a href="deleteServlet?note_id=<%= po.getId() %>" class="btn btn-danger">Delete</a>
                            <a href="edit.jsp?note_id=<%= po.getId() %>" class="btn btn-primary">Edit</a>
                        </div>
                    </div>
                </div>
                <%
                    }
                }
                %>
            </div>
        </div>
    </div>
</body>
</html>
