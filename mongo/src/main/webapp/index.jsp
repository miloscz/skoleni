
<%@page import="cz.unicorn.mongo.rest.DbUtil"%>
<%@page import="java.util.List"%>
<%@page import="cz.unicorn.mongo.rest.Candidate"%>
<%@page import="cz.unicorn.mongo.rest.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Miss Plus4U 2014</title>
<style>
p {color:blue}
body {background-color: #c9c9c9;}
table {border-style: groove; border-collapse: separate;}
.candidate {width: 300px; background-color: white;}
.candidate img {border-style:ridge; border-width:3px ;border-color: #000000;}
.strankovani {width:300px;text-align: right; background-color: white}
</style>
</head>
<%
	DbUtil db= DBConnect.getInstance();
	 db.getCandidatesList();
	
	String missPage = request.getParameter("page");
	if(missPage==null){
		missPage="1";
	}
	
	List<Candidate> LC = db.getCandidatesPage(Integer.valueOf(missPage));
	int missPages=db.getPagesCount();
%>
<body>
<div class="stranka" align=center>
	<table>
		<tr>
		<td class=strankovani>
		Stránka:<%
		for(int i=1;i<=missPages;i++){
			%>
		<a href="?page=<%=i %>"><%=i %> </a>
		<% 
		}
		%>/<%=missPage %>
		
		</td>
		</tr>
		<tr>
			<%
				for (Candidate miss : LC) {
			%>
			<td>
				<div class="candidate" align=center>
					ID dívky:
					<%=miss.getId()%><br> 
					<c:url value="/candidate/getImage" var="image">
						<c:param name="id" value="<%= miss.getId() %>" />
					</c:url>
					<img id="img"
						src='<c:out value="${image}"></c:out>'
						width="262px" height="393)px"> <br>
						
						
						Jméno:
					<%=miss.getName()%>
					<br>Výska:
					<%=miss.getHeight()%>
					<br>Váha:
					<%=miss.getWeight()%>
					<br>Počet hlasů:
					<%=miss.getRating()%>
					<form action="VoteAction.jsp" method="post">
						<input value="<%=miss.getId()%>" name="id" type="hidden">
						<input value="Hlasuj" type="submit">
					</form>


				</div>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	</div>
</body>
</html>