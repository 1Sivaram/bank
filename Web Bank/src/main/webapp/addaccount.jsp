<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page errorPage ="error.jsp"%>
    <%@ page import="logic.ApiLayer,java.util.*" %>
    <%@ page import="info.AccountInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add account</title>
<link rel="stylesheet" type="text/css" href="addaccount.css">
<script type="text/javascript" src="validate.js"></script>
</head>

<body>
<script type="text/javascript">
function checkForm()
{
	//alert('hlo');
	var customerId=document.getElementById("cid").value;
	var branch=document.getElementById("branch").value;
	var balance=document.getElementById("balance").value;
	//var errorMess=document.getElementById("errorText");
	//alert(errorMess);
	if(customerId==null||custoemrId=""||customerId<=0||customerId>1000)
	{
		alert("Invalid customerId field data");
		return false;
	}
	else if(branch==""||branch==null)
	{
		alert("please fill branch field");
		return false;
	}
	else if(balance==""||balance==null)
	{
		alert("please fill branch field");
		return false;
	}
	else if(balance<=0||balance.length()>6)
	{
		alert("Invalid balance data");
		return false;
	}
	
}

</script>


<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
		dispatch.forward(request, response);
	}
	%>
<jsp:include page="menu.jsp"/>
<% 
if(request.getParameter("accountId")==null)
{
%>
<div class="addaccount">
<form action="AddAccountServlet" method="post" onsubmit="return checkForm()">
	<h3>Add Account</h3><br>
	<label for="cid">Customer Id</label><br>
	<input type="number" id="cid" name="customerId"><br>
	<label for="branch" >Branch Name</label>
	<select id="branch" name="branchName" style="margin-left:50px;">
	<% 	ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
		List<String> branch=logic.getBranchArray();	
		Iterator<String> iter=branch.iterator();
		while(iter.hasNext())
		{
			String branchName=iter.next();
		%>
		<option><%out.print(branchName); %></option>
		<%} %>
	</select>
	<br><br>
	<label for="balance">Bank Balance</label><br>
	<input type="number" id="balance" name="bankBalance"><br>
	<input class="resutButton" type="reset" value="Reset"> 
	<input class="submitButton" type="submit" value="Submit">
</form>

</div>
<% } 
else
{
	int accountId=Integer.parseInt(request.getParameter("accountId"));
	int customerId=Integer.parseInt(request.getParameter("customerId"));
	ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
	AccountInfo account=logic.getAccountDetails(customerId, accountId);
%>
<div class="addaccount">
<form action="AddAccountServlet?accountId=<%=accountId%>" method="post" onsubmit="return checkForm()">
	<h3>Update Account</h3><br>
	<label for="cid">Customer Id</label><br>
	<input type="text" id="cid" name="customerId" value=<%=account.getCustomerId() %> readonly><br>
	<label for="branch">Branch Name</label><br>
	<input type="text" id="branch" name="branchName" value=<%=account.getBranchName()%> onchange="checkText('branch')"><br>
	<label for="balance">Bank Balance</label><br>
	<input type="number" id="balance" name="bankBalance" value=<%=account.getBankBalance() %>><br>
	<h3 id="errorText"></h3>
	<input class="resutButton" type="reset" value="Reset"> 
	<input class="submitButton" type="submit" value="Submit">
	
</form>
</div>
<%} %>

</body>
<% if(request.getAttribute("error")!=null)
		{%>
		<p style=color:red;text-align:center;background-color:white;><%out.print(request.getAttribute("error")); %></p>
		<%} %>
</html>