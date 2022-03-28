<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="info.AccountInfo"%>
<%@ page import="java.util.HashMap"%>
 <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer</title>
<link rel="stylesheet" type="text/css" href="userhomepage.css">
</head>

<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
	<jsp:include page="menu.jsp"></jsp:include>
	<form action="" method="post">
		<table class="table1">
			<tr>
				<th>Account-No</th>
				<th>Branch Name</th>
				<th>Balance</th>
			</tr>

			<%
			Map<Integer, AccountInfo> mapObj = (Map<Integer, AccountInfo>) request.getAttribute("AccountMap");
			for (Map.Entry<Integer,AccountInfo> entry:mapObj.entrySet()) 
			{
				AccountInfo account =entry.getValue();
			%>
			<tr>
				<td><% 
					out.print(account.getAccountId());
				%></td>
				<td><% 
					out.print(account.getBranchName());
				%></td>
				<td><% 
					out.print(account.getBankBalance());
				%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
	
	<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
</body>
</html>