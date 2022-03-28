<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page errorPage ="error.jsp"%>
    <%@ page import="logic.ApiLayer,info.AccountInfo,java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="menu.css" >
<title>menu</title>
</head>

<body>

<%
String value=String.valueOf(session.getAttribute("session"));
ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
if(value==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
else if(value.equals("session"))
{
	%>
<div class="menu">
  <a class="aid" href="customerdetails.jsp">
  <%
  	request.setAttribute("CustomerList",logic.getCustomerList(true));
  %>Customer</a>
  <a class="aid" href="adminhomepage.jsp"><%request.setAttribute("AccountList", logic.getAccountList(true));
  %>Account</a>
  <a class="aid" href="transfer.jsp?username=admin&">
  <%
  	request.setAttribute("AccountList", logic.getAccountList(true));
  %>Transfer Money</a>
  <a class="logout" href="bank_login">LogOut</a>
</div>
<%
} 
else
{%>
		<div class="menu">
		<a class="aid" href="userhomepage.jsp"><%
			int customerId=(int) session.getAttribute("session");
			Map <Integer,AccountInfo> map=logic.getCustomerAccounts(customerId);
			request.setAttribute("AccountMap",map); %>Home</a>
		<a class="aid" href="transfer.jsp?username=customer">Transfer-Money</a>
		<a class="logout" href="bank_login">LogOut</a>
	</div>
<%} %>

<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%}%>
</body>
</html>