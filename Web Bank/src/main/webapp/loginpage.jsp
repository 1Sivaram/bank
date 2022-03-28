<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>net banking</title>
<link rel="stylesheet" type="text/css" href="loginpage.css">
<script type="text/javascript" src="validate.js"></script>
</head>

<body>
<script type="text/javascript">
function checkForm()
{
	var uname=document.getElementById("uname").value;
	var password=document.getElementById("password").value;
	if(uname<=0||uname>1000)
		{
			alert("Invalid uname field data");
			return false;
		}
	else if(password==""||password==null)
	{
		alert("please fill password field");
		return false;
	}
}
</script>
	<div class="mid login">
		<form action="bank_login" method="post" onsubmit="return checkForm()">
			<h2> User Login </h2>
			<label class="align" for="uname">User Name </label><br>
			<input class="i" type="number" id="uname" placeholder="userid" name="uid"><br> 
			<label class="align" for="password">Password </label> <br>
			<input class="i" type="password" id="password" placeholder="password" name="Password" onchange="check('password')"><br> 
			<input class="btn" type="submit" id="submit" value="Submit"><br><br>
			<input class="btn" type="reset" id="reset" value="Reset">
			<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
		</form>
	</div>
</body>
</html>