function checkForm()
{
	var from=document.getElementById("from").value;
	var to=document.getElementById("to").value;
	var amount=document.getElementById("amount").value;
	if(from==""||from <= 0)
		{
			/*alert("invalid from account number(or blank)");*/
			console.log("firstif");
			return false;
		}
	else if(to==""||to <= 0)
	{
		/*alert("invalid to account number(or blank)");*/
		console.log("2");
		return false;
	}
	else if(amount==""||amount.length()>6)
	{
		/*alert("amount must not exceed 6 digits(or blank)");*/
		console.log("3");
		return false;
	}
	else if(from==to)
	{
		/*alert("From and To account is same");*/
		console.log("3");
		return false;
	}
	alert(from+" "+to);
	
}