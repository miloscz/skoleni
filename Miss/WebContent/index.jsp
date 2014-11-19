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
	//DBConnect db= new DBConnect();
	
	int sum=30;
	int missPerRow=4;
	int rows= (sum/missPerRow)+1;


%>
<body>
<p></p>
<table><tr>
<% for(int i=0;i<=sum;i++)
{
	
	 
	 %>
	   <td>
	   <div id="candidate" >
	   <p>Divka cislo: <%= i %><br>
	   <img  id="img" src="http://www.oceanbluemagazine.com/wpimages/wpfa7e4e56_06.png" width="100px" height="200px">
	    
	    <br>Jmeno:
	    <br>Miry:
	    <br>Vyska:
	    <br>Vaha:
	    <br><form action="VoteAction.jsp" method="get">
	    	<input value="<%=i %>" name="id" type="hidden">
			<input value="Hlasuj" type="submit"></form>
	    </p>
	    
	   </div> 
	    </td>
	</tr>
	 <%
	 
	}

	%>

</table>



</body>
</html>