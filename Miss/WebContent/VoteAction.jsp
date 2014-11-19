<%@page import="Kand.Kand.db.DbUtil"%>
<%@page import="Kand.Kand.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
DbUtil db= DBConnect.getInstance();
String id=request.getParameter("id");
try{
db.addEvaluation(id);
}
catch (Exception e){
	
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hlasovani</title>
</head>
<body>
Dekujeme za hlas pro divku <%=id %>
</body>
</html>