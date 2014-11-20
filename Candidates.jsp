<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@page import ="interfaces.IDBHandler" %>
    <%@page import ="backend.DBHandler" %>
    <%@page import = "org.entities.Candidate" %>
    <%@page import = "java.util.List" %>
    <%@page import = "java.util.ArrayList" %>
    <% DBHandler handler = DBHandler.getInstance(); %>
  	<% List<Candidate> listCandidates = handler.getCandidates(); %>   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <% request.setAttribute("listCandid", listCandidates);%>
     <% if(request.getParameter("submit")!=null){
    	handler.vote(request.getParameter("id"));	 
     }

%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Miss Candidates</title>
</head>
<body>
		<h1>Miss Candidates</h1>
		<c:forEach items="${listCandid}" var="candidate" >
			<table id="candidatesTable">
      	<tr>
      		<td>name: ${candidate.firstName} ${candidate.surname}</td>
      	</tr>
      	<tr>
      		<td>age: ${candidate.age}, height: ${candidate.heigth}, weight: ${candidate.weight}</td>
      	</tr>
      	<tr>
      		<td>chest: ${candidate.chest}, waist: ${candidate.waist}, hips: ${candidate.hips}</td>
      	</tr>
      	<tr>
      		<td>votes: <h2>${candidate.votes}</h2>
					<form  method="post" id="votebutton"> 
						<input name="submit" value="vote" type="submit" />
					<input id="id" name="id" value="${candidate.id}" type="hidden" />
					</form>
			</td>
      	</tr>
      	<br></br>
      </table> 
		</c:forEach> 
</body>
</html>