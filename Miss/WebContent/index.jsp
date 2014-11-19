<%@page import="java.util.List"%>
<%@page import="Kand.Kand.db.Candidate"%>
<%@page import="Kand.Kand.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='style.css' type='text/css'>
<title>Miss Plus4U 2014</title>
</head>
<%
	DBConnect db = new DBConnect();
	List<Candidate> LC = db.getCandidatesList();
%>
<body>
	<table>
		<tr>
			<%
				for (Candidate miss : LC) {
			%>
			<td>
				<div id="candidate">
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