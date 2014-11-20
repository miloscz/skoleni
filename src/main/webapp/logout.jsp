<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LogOut</title>
</head>
<body>
<%
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.invalidate();
        %>
        <h1 style="text-align: center; color: #66FF66 " >Logout was done successfully.</h1>
        
        <script type="text/javascript">
        	window.setInterval(function(){
        		window.location = "index.jsp"
        	}, 2000);
        </script>

</body>
</html>