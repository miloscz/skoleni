<%@page import="org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
	$("#login-box").mouseenter(function(){
		$("#login-box").css("background","#fff");
	});
</script>
</head>
<body>
<style>
	#login-box, #admin-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #99CC99;
	-webkit-border-radius: 2px;
	-moz-border-radius: 3px;
	border: 2px solid #000;
}
	h1{
		color: #99CC99;
		text-align: center;
	}
</style>

<h1>Login</h1>
<form action="login.jsp" method="post" id="login-box">
 
		  <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		  </table>
</form>

<form action="admin/admin.jsp" method="post" id="admin-box">
	<input name=submit type="submit" value="Administration"/>
</form>

</body>
</html>