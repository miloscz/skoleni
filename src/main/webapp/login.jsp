<%@page import="login.SimpleLogin"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login?action</title>
</head>
<body>
	<%
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username==null || password==null){
        	response.sendRedirect("error.jsp");
        }else{
        	SimpleLogin login = new SimpleLogin();
            if((login.simpleLogin(username, password))==true)
                {
                session.setAttribute("username", username);
                response.sendRedirect("Candidates.jsp");
                }
            else
                response.sendRedirect("error.jsp");	
        }
        
        %>	
</body>
</html>