<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page errorPage ="error.jsp"%>
   <%@ page import="java.util.*" %>
   <%@ page import="info.AccountInfo" %>
   <%@ page import="javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="adminhomepage.css">
<title>admin</title>
</head>

<body>
<jsp:include page="menu.jsp"></jsp:include>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<div>
<form action="DeActivate" method="post"><br>
<h4><a href="addaccount.jsp">Add Account</a></h4>
<h4><a href="activateaccount.jsp">Activate Account</a></h4>
<table class="table1">
<tr>
	<th>Account-Id</th>
	<th> Customer-Id</th>
	<th>Branch Name</th>
	<th>Balance </th>
	<th>Status</th>
</tr>
<%
	List<AccountInfo> list=(List<AccountInfo>)request.getAttribute("AccountList");  
	Iterator<AccountInfo> iter=list.iterator();
	while(iter.hasNext())
	{
		AccountInfo accountObj=(AccountInfo)iter.next();
	%>
<tr>
<td><a href="addaccount.jsp?accountId=<%=accountObj.getAccountId()%>&customerId=<%=accountObj.getCustomerId()%>"><%out.print(accountObj.getAccountId()); %></a></td>
<td><%out.print(accountObj.getCustomerId()); %></td>
<td><%out.print(accountObj.getBranchName()); %></td>
<td><%out.print(accountObj.getBankBalance()); %></td>
<td><a href="DeActivate?accountId=<%=accountObj.getAccountId()%>&customerId=<%=accountObj.getCustomerId()%>" >Deactivate</a></td>
</tr>
<%
	}
	%>
</table>
</form>
</div>
<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
</body>
</html>