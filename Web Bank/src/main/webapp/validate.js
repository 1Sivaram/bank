function check(id)
{
  var data = document.getElementById(id);
  data.value = data.value.replaceAll(/[^ @!a-zA-Z0-9.]/g,"");
  data.value = data.value.trim();
  return true;
}

function checkText(id)
{
  var data = document.getElementById(id);
  data.value = data.value.replaceAll(/[^ /a-zA-Z.]/g,"");
  data.value = data.value.trim();
}

function negativeNeglect(id)
{
  var data = document.getElementById(id);
  if(Math.sign(data.value)==(-1))
  {
 	 alert("Invalid sign (negative sign)");
  	return false;
  }
}
	
function lengthCheck(id)
{
	var data = document.getElementById(id);
  if(data.value.length!=10)
  {
	 alert("Phone number should be 10 digits");
 	 return false;
  }
}