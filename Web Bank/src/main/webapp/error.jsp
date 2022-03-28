<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
<h3 style=color:red;text-align:center>Something went Wrong</h3>
<% 
	if(exception!=null)
	{
		%>
	<p><%out.print(exception.getMessage());
	exception.printStackTrace();%></p>
	<% }%>
<p style=color:black;text-align:center;padding:20px; ><%out.print(request.getAttribute("error"));%></p>
</body>
</html>