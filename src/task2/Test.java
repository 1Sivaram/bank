package task2;

public class Test
{

	public String printString(String str)
	{
		return str;
	}

	public void nullCheckString(String inputString) throws Exception
	{
		if(inputString==null||inputString.isEmpty())
		{
			throw new Exception("Enter valid inputs (String is null or Empty)");
		}
	}
	public void nullCheckStringArray(String [] inputString) throws Exception
	{
		for(String dummy:inputString)
		{
			nullCheckString(dummy);
		}
	}

	public void numCheck(int num,int num1) throws Exception
	{
		if(num1<0||num <= num1)
		{
			throw new Exception("Enter valid inputs");
		}
		
	}

	public int getLength(String inputString) throws Exception
	{

		nullCheckString(inputString);
		int length=inputString.length();
		return length;
	}


	public char[] changeToChar(String inputString) throws Exception//2nd task
	{
		nullCheckString(inputString);
		char [] charArray=inputString.toCharArray();
		return charArray;
	}


	public char penultimate(String inputString,int position) throws Exception//3rd task
	{
		nullCheckString(inputString);
		int length=getLength(inputString);
		numCheck(length,position);
		char letter=inputString.charAt(length-position-1);
		return letter;
	}


	public int occur(String inputString,char letter) throws Exception//4th task
	{
		int num=0;
		nullCheckString(inputString);
		char [] characterArray=changeToChar(inputString);
		for(char temp:characterArray)
		{
			if(letter==temp)
			{  
				num++;
			}
		}
		return num;
	}


	public int position(String inputString,char letter) throws Exception//5th task
	{
		nullCheckString(inputString);
		int num=inputString.lastIndexOf(letter);
		return num;
	}


	public String printFromBack(String inputString,int position) throws Exception//6th task
	{
		nullCheckString(inputString);
		int length=getLength(inputString);
		numCheck(length,position);
		String sub=inputString.substring(length-position);
		return sub;
	}


	public String printFromFront(String inputString, int position) throws Exception//7th task
	{
		nullCheckString(inputString);
		numCheck(getLength(inputString),position);
		String sub=inputString.substring(0,position);
		return sub;
	}



	public String replaces(String inputString,String replaceString) throws Exception//8th task
	{
		nullCheckString(inputString);
		nullCheckString(replaceString);
		int num=getLength(replaceString);
		numCheck(getLength(inputString),num);
		String sub=inputString.substring(0,num);
		inputString=inputString.replace(sub,replaceString);
		return inputString;
	}



	public boolean StartCheck(String inputString,String startString) throws Exception//9th task
	{
		nullCheckString(inputString);
		nullCheckString(startString);
		boolean boo=inputString.startsWith(startString);
		return boo;
	}



	public boolean EndCheck(String inputString,String endString) throws Exception//10th task
	{
		nullCheckString(inputString);
		nullCheckString(endString);
		boolean boo=inputString.endsWith(endString);
		return boo;
	}



	public String convertUpper(String inputString) throws Exception//11th task
	{
		nullCheckString(inputString);
		inputString=inputString.toUpperCase();
		return inputString;
	}



	public String convertLower(String inputString) throws Exception//12th task
	{
		nullCheckString(inputString);
		inputString=inputString.toLowerCase();
		return inputString;
	}



	public String reverseString(String inputString) throws Exception//13th task
	{
		String sub="";
		nullCheckString(inputString);
		int length=getLength(inputString);
		for(int num=length-1;num>-1;num--)
		{
			sub=sub+inputString.charAt(num);
		}
		return sub;
	}

	public String multiple(String inputString) throws Exception//15th task
	{
		nullCheckString(inputString);
		String sub=inputString.replace(" ","");
		return sub;
	}


	public String[] stringToArray(String inputString) throws Exception//16th task
	{
		nullCheckString(inputString);
		String [] sub=inputString.split(" ");
		return sub;
	}


	public String mergeString(String [] stringArray,String symbol) throws Exception//17th task
	{
		nullCheckString(symbol);
		nullCheckStringArray(stringArray);
		String sub=String.join(symbol,stringArray);
		return sub;
	}


	public boolean equal(String FirstInputString,String SecondInputString) throws Exception//18 task
	{
		nullCheckString(FirstInputString);
		nullCheckString(SecondInputString);
		boolean boo=FirstInputString.equals(SecondInputString);
		return boo;
	}

	public boolean ignoreEquals(String FirstInputString,String SecondInputString) throws Exception//19 task
	{
		nullCheckString(FirstInputString);
		nullCheckString(SecondInputString);
		boolean boo=FirstInputString.equalsIgnoreCase(SecondInputString);
		return boo;
	}



	public String noSpace(String inputString) throws Exception//20th task
	{
		nullCheckString(inputString);
		inputString=inputString.trim();
		return inputString;
	}

}



