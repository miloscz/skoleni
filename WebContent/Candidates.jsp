<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="interfaces.IDBHandler" %>
    <%@page import ="backend.DBHandler" %>
    <%@page import = "org.entities.Candidate" %>
    <%@page import = "java.util.List" %>
    <%@page import = "java.util.ArrayList" %>
    <% IDBHandler handler = DBHandler.getInstance(); %>
    <% List<Candidate> listCandidates = handler.getCandidates();%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <% request.setAttribute("list", listCandidates);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Miss Candidates</title>
</head>
<body>
<h2>ahoj</h2>
	<c:forEach items="${list}" var="candidate" >
      
        <h1>${candidate.surname}</h1>  

	</c:forEach>
</body>
</html>