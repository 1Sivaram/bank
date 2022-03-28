<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page errorPage ="error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="info.CustomerInfo"%>
<%@ page import="logic.ApiLayer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>activate_customer</title>
<link rel="stylesheet" type="text/css" href="adminhomepage.css">
</head>
<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<jsp:include page="menu.jsp"/><br>
<h2 style=text-align:center>De-Activated Customer Details</h2>
<table class="customerTable">
<tr>
	<th>Customer-Id</th>
	<th>Customer-Name</th>
	<th>Address</th>
	<th>Mobile-No </th>
	<th>Status</th>
</tr>

<%
	ApiLayer logic=(ApiLayer) request.getServletContext().getAttribute("api");
	List<CustomerInfo> list=(List<CustomerInfo>) logic.getCustomerList(false);
	//out.print(map);
	Iterator<CustomerInfo> iter=list.iterator();
	while(iter.hasNext())
	{
		CustomerInfo customerObj=(CustomerInfo)iter.next();
	%>
	<tr>
	<td><% out.print(customerObj.getCustomerId()); %></td>
	<td><%out.print(customerObj.getCustomerName()); %></td>
	<td><%out.print(customerObj.getAddress()); %></td>
	<td><%out.print(customerObj.getMobile()); %></td>
	<td><a href="Activate?customerId=<%=customerObj.getCustomerId()%>" >Activate</a></td>
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