<%@page import="cz.unicorn.mongo.rest.DbUtil"%>
<%@page import="cz.unicorn.mongo.rest.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="5;url=index.jsp"> 
<title>VoteAction</title>

<style>
p {color:#000000}
body {background-color: #c9c9c9;}
.blok {background-color: #FFFFFF; width:400px}
</style>
<% 
String id = request.getParameter("id");  
DbUtil db= DBConnect.getInstance();
db.addEvaluation(id);
String jmeno=db.getCandidateObj(id).getName();
 %>
</head>
<body>
<div align=center>
<div class=blok>
<p>Diky hlas!
<%=jmeno  %>.<br><a href="index.jsp">Zpet</a>
</p></div></div>
</body>
</html>