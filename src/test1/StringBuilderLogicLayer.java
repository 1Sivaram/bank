package test1;
import task2.Test;

public class StringBuilderLogicLayer
{
	StringBuilder builderObj=new StringBuilder();
	Test testObj=new Test();
	
	private void nullCheckStringBuilder(StringBuilder tempObj)throws Exception
	{
		if(tempObj==null)
		{
			throw new Exception("The input is null");
		}
	}
	
	private void numCheck(int number) throws Exception
	{
		if(number<10)
		{
			throw new Exception("Enter a valid input (string must have minimum 10 character)");
		}
	}
	
	
	private void numCheck(int numOne,int numTwo,int length) throws Exception
	{
		if(numOne>length||numTwo>length)
		{
			throw new Exception("Enter a valid input");
		}
	}

	public StringBuilder getStringBuilderWithoutArgs()
	{
		StringBuilder builderObj=new StringBuilder();
		return builderObj;
	}
	
	
	public StringBuilder getStringBuilder(String inputString)
	{
		StringBuilder builderObj=new StringBuilder(inputString);
		return builderObj;
	}
	
	
	public StringBuilder doAppend(StringBuilder tempObj,String inputString) throws Exception
	{
		nullCheckStringBuilder(tempObj);
		testObj.nullCheckString(inputString);
		tempObj.append(inputString);
		return tempObj;
	}
	
	public StringBuilder doAppend(StringBuilder tempObj,String []stringArray)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		testObj.nullCheckStringArray(stringArray);
		for(String dummy:stringArray)
		{
			doAppend(tempObj,dummy);
			doAppend(tempObj," ");
		}
		return tempObj;
	}
	
	
	public StringBuilder doAppend(StringBuilder tempObj,String []stringArray,char symbol)throws Exception
	{
		doAppend(tempObj,stringArray);
		replaceSymbol(tempObj,symbol);
		return tempObj;
	}
	
	
	public StringBuilder doAppendTwice(String inputString,String inputSubString)throws Exception
	{
		testObj.nullCheckString(inputString);
		testObj.nullCheckString(inputSubString);
		StringBuilder builderObj=new StringBuilder();
		doAppend(builderObj,inputString);
		doAppend(builderObj," ");
		doAppend(builderObj,inputSubString);
		return builderObj;
	}
	


	public int getLength(StringBuilder tempObj) throws Exception//1st task
	{
		nullCheckStringBuilder(tempObj);
		int length=tempObj.length();
		return length;
	}
	
	
	public StringBuilder appendSymbol(StringBuilder tempObj,String stringArray[],String symbol) throws Exception
	{
		nullCheckStringBuilder(tempObj);
		testObj.nullCheckString(symbol);
		testObj.nullCheckStringArray(stringArray);
		for(String dummy:stringArray)
		{
			doAppend(tempObj,symbol);
			doAppend(tempObj,dummy);
		}
		return tempObj;
	}
	
	
	public StringBuilder insertString(String inputString,String inputSubString,String inputSubString1)throws Exception
	{
		testObj.nullCheckString(inputString);
		testObj.nullCheckString(inputSubString);
		testObj.nullCheckString(inputSubString1);
		builderObj=doAppendTwice(inputString,inputSubString);
		int length=testObj.getLength(inputString)+1;
		builderObj.insert(length,inputSubString1+" ");
		return builderObj;
	}
	
	
	public StringBuilder deleteString(String inputString,String inputSubString)throws Exception
	{
		testObj.nullCheckString(inputString);
		testObj.nullCheckString(inputSubString);
		builderObj=doAppendTwice(inputString,inputSubString);
		int length=testObj.getLength(inputString)+1;
		builderObj.delete(0,length);
		return builderObj;
	}
	
		
	public StringBuilder reverseString(StringBuilder tempObj)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		tempObj.reverse();
		return tempObj;
	}	
	
		
	public StringBuilder deletePosition(StringBuilder tempObj,int start,int end)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		numCheck(getLength(tempObj));
		numCheck(start,end,getLength(tempObj));
		tempObj.delete(start,end);
		return tempObj;
	}
	
		
	public StringBuilder replacePosition(StringBuilder tempObj,String inputString,int start,int end)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		numCheck(getLength(tempObj));
		testObj.nullCheckString(inputString);
		numCheck(start,end,getLength(tempObj));
		int length=testObj.getLength(inputString);
		if(end-start!=length||start >= end)
		{
			throw new Exception("Enter a valid positions");
		}
		tempObj.replace(start,end,inputString);
		return tempObj;
	}
		
		
	public int getIndexFirst(StringBuilder tempObj,String symbol)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		int index=tempObj.indexOf(symbol);
		return index;
	}
	
	
	public int getIndexLast(StringBuilder tempObj,String symbol)throws Exception
	{
		nullCheckStringBuilder(tempObj);
		int index=tempObj.lastIndexOf(symbol);
		return index;
	}	


	public StringBuilder replaceSymbol(StringBuilder tempObj,char symbol)throws Exception	
	{
		nullCheckStringBuilder(tempObj);
		int length=getLength(tempObj);
		for(int index=0;index<length-1;index++)
		{
			if(tempObj.charAt(index)==' ')
			{
				tempObj.setCharAt(index,symbol);
			}
		}
		return tempObj;
	}



				
}
