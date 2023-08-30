<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
UserDeatails user1=(UserDeatails)session.getAttribute("userDet");
if(user1==null){
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login");
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="all_component/navbar.jsp"%>
		<h1 class="text-center">Add Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotesServlet" method="post">
						<div class="form-group">
						<%
						UserDeatails us=(UserDeatails)session.getAttribute("userDet");
						if(us!=null){%>
							<input type="hidden" value="<%=us.getId()%>" name="uid">
						<% }
						%>
						
							<label for="exampleInputEmail1">Enter title</label>
							<input type="text" name="title" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="form-control" class="form-control" name="content" required="required"></textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="all_component/footer.jsp"%>
</body>
</html>
