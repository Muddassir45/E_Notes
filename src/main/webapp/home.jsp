<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
UserDeatails user3 = (UserDeatails) session.getAttribute("userDet");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all_component/allcss.jsp" %>
</head>
<body>
<%@ include file="all_component/navbar.jsp" %>
<div class="container-fluid">
<div class="card py-5">
<div class="card-body text-center">
<img alt="" src="img/paper.png" class="img-fluid mx-auto" style="max-width: 300px;">
<h1>START THINKING YOUR NOTES</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
</div>
</div>
</div>
<%@ include file="all_component/footer.jsp" %>
</body>
</html>
