<%@page import="cz.unicorn.mongo.rest.DbUtil"%>
<%@page import="java.util.List"%>
<%@page import="cz.unicorn.mongo.rest.Candidate"%>
<%@page import="cz.unicorn.mongo.rest.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Miss Plus4U 2014</title>
<style>
p {color:blue}
body {background-color: #c9c9c9;}
table {border-style: groove;}
.candidate div {width: 300px;}
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

	<table>
		<tr>
		<td>
		<%=missPage %><%
		for(int i=1;i<=missPages;i++){
			%>
		<a href="?page=<%=i %>"><%=i %></a>
		<% 
		}
		
		
		%>
		
		</td>
		</tr>
		<tr>
			<%
				for (Candidate miss : LC) {
			%>
			<td>
				<div id="candidate" align=center>
					Divka cislo:
					<%=miss.getId()%><br> <img id="img"
						src="http://www.oceanbluemagazine.com/wpimages/wpfa7e4e56_06.png"
						width="100px" height="200px"> <br>Jmeno:
					<%=miss.getName()%>
					<br>Vyska:
					<%=miss.getHeight()%>
					<br>Vaha:
					<%=miss.getWeight()%>
					<br>
					<form action="VoteAction.jsp" method="get">
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
</body>
</html>