<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page errorPage ="error.jsp"%>
   <%@ page import="java.util.*" %>
   <%@ page import="info.AccountInfo" %>
   <%@ page import="logic.ApiLayer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>activate_account</title>
<link rel="stylesheet" type="text/css" href="adminhomepage.css">
</head>
<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<jsp:include page="menu.jsp"/>
<form action="Activate" method="post"></form>
<h2 style=text-align:center>De-Activated Account Details</h2>
<table class="table1">
<tr>
	<th>Account-Id</th>
	<th> Customer-Id</th>
	<th>Branch Name</th>
	<th>Balance </th>
	<th>Status</th>
</tr>
<%
	ApiLayer logic=(ApiLayer) request.getServletContext().getAttribute("api");
	List<AccountInfo> list=(List<AccountInfo>)logic.getAccountList(false); 
	Iterator<AccountInfo> iter=list.iterator();
	while(iter.hasNext())
	{
		AccountInfo accountObj=(AccountInfo)iter.next();
	%>
<tr>
<td><%out.print(accountObj.getAccountId()); %></td>
<td><%out.print(accountObj.getCustomerId()); %></td>
<td><%out.print(accountObj.getBranchName()); %></td>
<td><%out.print(accountObj.getBankBalance()); %></td>
<td><a href="Activate?accountId=<%=accountObj.getAccountId()%>&customerId=<%=accountObj.getCustomerId()%>" >Activate</a></td>
</tr>
<%
	}
%>
</table>
<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
</body>
</html>