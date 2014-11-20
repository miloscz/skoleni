<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String name = request.getParameter("username"); %>
<% String password = request.getParameter("password"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=session.getAttribute("username").toString()%></title>
</head>
<body>

<div><p style="text-align: center; font-size: 2em;"><%=session.getAttribute("username").toString()%></p></div>

<form action="logout.jsp" method="post" id="logout">
	<input style ="margin: 50px, auto" name="submit" type="submit" value="logout" />
</form>
</body>
</html>