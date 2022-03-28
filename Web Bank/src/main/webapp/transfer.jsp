<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="logic.ApiLayer,java.util.*,info.AccountInfo" %>
     <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transfer</title>
<link rel="stylesheet" type="text/css" href="transfer.css" >
<script type="text/javascript" src="transfer.js"></script>
</head>

<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<div>
<jsp:include page="menu.jsp"></jsp:include>
<% String value=request.getParameter("username");
%>
<form action="TransferMoney?data=<%=value %>" method="post" onsubmit="return checkForm()">
<h2>Transfer Money</h2><br>
<label for="from">From Account</label>
<%if(value.equals("customer"))
	{
	%>
<select id="from" name="fromAccountId" style="margin-left:30px;">
<%
		int customerId=(Integer)session.getAttribute("session");
		ApiLayer logic=(ApiLayer) application.getAttribute("api");
		List<AccountInfo> listObj=(List <AccountInfo>)logic.getActiveAccounts(customerId);
		Iterator<AccountInfo> iter=listObj.iterator();
		while(iter.hasNext())
		{
			AccountInfo accountObj=iter.next();
	%>
<option><%out.print(accountObj.getAccountId());%></option>
<%} %>
</select><br>
	<%}
	else
	{%>
<input  type="number" id="from" name="fromAccountId" >
<%} %>
<br>
<label for="to">To Account</label>
<input type="number" id="to" name="toAccountId" ><br>
<label for="amount">Transfer Amount</label>
<input type="number" id="amount" name="amount" ><br>
<input class="resutButton" type="reset" value="Reset">
<input class="submitButton" type="submit" value="Submit">
</form>
</div>
</body>
</html>