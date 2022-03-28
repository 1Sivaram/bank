<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="info.CustomerInfo"%>
 <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerdetails</title>
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
<h4><a href="addcustomer.jsp">Add Customer</a></h4>
<h4><a href="activatecustomer.jsp">Activate Customer</a></h4>
<table class="table1">
<tr>
	<th>Customer-Id</th>
	<th>Customer-Name</th>
	<th>Address</th>
	<th>Mobile-No </th>
	<th>Status</th>
</tr>

<%
	List<CustomerInfo> list=(List<CustomerInfo>) request.getAttribute("CustomerList");
	Iterator<CustomerInfo> iter=list.iterator();
	while(iter.hasNext())
	{
		CustomerInfo customerObj=(CustomerInfo)iter.next();
	%>
	<tr>
	<td><a href="addcustomer.jsp?customerId=<%=customerObj.getCustomerId()%>"><% out.print(customerObj.getCustomerId()); %></a></td>
	<td><%out.print(customerObj.getCustomerName()); %></td>
	<td><%out.print(customerObj.getAddress()); %></td>
	<td><%out.print(customerObj.getMobile()); %></td>
	<td><a href="DeActivate?customerId=<%=customerObj.getCustomerId()%>" >DeActivate</a></td>
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