<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page errorPage ="error.jsp"%>
    <%@ page import="logic.ApiLayer" %>
    <%@ page import="info.CustomerInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add customer</title>
<link rel="stylesheet" type="text/css" href="addcustomer.css">
<script type="text/javascript" src="validate.js"></script>
</head>

<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<jsp:include page="menu.jsp"/>

<script type="text/javascript">
function checkForm()
{
	var customerName=document.getElementById("cname").value;
	var address=document.getElementById("address").value;
	var mobile=document.getElementById("mobile").value;
	if(customerName==""||customerName==null)
		{
			alert("please fill customerName field");
			return false;
		}
	else if(address==""||address==null)
	{
		alert("please fill address field");
		return false;
	}
	
	if(mobile==""||mobile==null||)
	{
		alert("please fill branch field");
		return false;
	}
	
	if(mobile.length!=10)
	  {
		 alert("Phone number should be 10 digits");
	 	 return false;
	  }
}
</script>

<% if(request.getParameter("customerId")==null)
{
	//out.print(request.getParameter("customerId"));
	%>
<div class="addcustomer">
<form action="AddCustomerServlet" method="post" onsubmit="return checkForm()">
	<h3>Add Customer</h3>
	<label for="cname">CustomerName</label><br>
	<input type="text" id="cname" name="customerName" onchange="check('cname')" required><br>
	<label for="address">Address</label><br>
	<input type="text" id="address" name="address" onchange="checkText('address')" required><br>
	<label for="mobile">Mobile No</label><br>
	<input type="text" id="mobile" name="mobile" required><br>
	<input class="resutButton" type="reset" id="reset" value="Reset">
	<input class="submitButton" type="submit" id="submit" value="Submit"> 
</form>
</div>
<% } 
else
{
	//int accountId=Integer.parseInt(request.getParameter("accountId"));
	int customerId=Integer.parseInt(request.getParameter("customerId"));
	ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
	CustomerInfo customer=logic.getCustomerDetails(customerId);
%>
<div class="addcustomer">
<form action="AddCustomerServlet?customerId=<%=customerId%>" method="post" onsubmit="return checkForm()">
	<h3>Update Customer</h3>
	<label for="cname">CustomerName</label><br>
	<input type="text" id="cname" name="customerName" value=<%=customer.getCustomerName() %> onchange="check('cname')"><br><br>
	<label for="address">Address</label><br>
	<input type="text" id="address" name="address" value=<%=customer.getAddress()%> onchange="checkText('address')"><br><br>
	<label for="mobile">Mobile No</label><br>
	<input type="text" id="mobile" name="mobile" value=<%=customer.getMobile()%>><br>
	<input class="resutButton" type="reset" id="reset" value="Reset"> 
	<input class="submitButton" type="submit" id="submit" value="Submit">
</form>
</div>
<%} %>
</body>
<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
</html>