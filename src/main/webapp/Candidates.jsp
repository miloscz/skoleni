<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%//@page import ="interfaces.IDBHandler" %>
    <%//@page import ="backend.DBHandler" %>
    <%@page import = "org.entities.Candidate" %>
    <%@page import = "java.util.List" %>
    <%@page import = "java.util.ArrayList" %>
    <% //IDBHandler handler = DBHandler.getInstance(); %>
    <% List<Candidate> listCandidates = new ArrayList<Candidate>();
    	listCandidates.add(new Candidate("Lana", "Del Rey", 32, 45, 30, 23, 185, 55, 0));
    %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <% request.setAttribute("list", listCandidates);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Miss Candidates</title>
</head>
<body>
      <table style="background-color: olive; font-family: Georgia; padding: 3px, 3px">
      	<tr>
      		<td>Name: ${candidate.firstName} ${candidate.surname}</td>
      	</tr>
      	<tr>
      		<td>Age: ${candidate.age}, Height: ${candidate.heigth}, Weight: ${candidate.weight}</td>
      	</tr>
      	<tr>
      		<td>Chest: ${candidate.chest}, Waist: ${candidate.waist}, Hips: ${candidate.hips}</td>
      	</tr>
      	<tr>
      		<td>Votes: <h2>${candidate.votes}</h2></td>
      	</tr>
      </table>  
</body>
</html>