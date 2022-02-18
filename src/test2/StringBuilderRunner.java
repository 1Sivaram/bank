package test2;
import test1.StringBuilderLogicLayer;
import task3.Input;

public class StringBuilderRunner
{
public static void main(String args[])
{
	int number=0;
	int start=0;
	int end=0;
	char symbol=' ';
	String inputString="";
	String inputSubString="";
	String subString="";
	String tempString="";
	String stringArray[]={""};
	//StringBuilder tempObj=new StringBuilder();
	StringBuilder tempObj;
	StringBuilderLogicLayer logicObj=new StringBuilderLogicLayer();
	Input inputObj=new Input();
	System.out.println("Enter your Choice ");
	int choice=inputObj.getInt();
	switch(choice)
	{
	case 1:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			inputString=inputObj.getString();
			tempObj=logicObj.doAppend(tempObj,inputString);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
	
	case 2:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String you want the StringBuilder constructor have with");
			inputString=inputObj.getString();
			tempObj=logicObj.getStringBuilder(inputString);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println("Enter a Symbol you want to connect a StringBuilder with");
			inputSubString=inputObj.getString();
			System.out.println("How many string you want to append");
			number=inputObj.getInt();
			stringArray=inputObj.getStringArray(number);
			tempObj=logicObj.appendSymbol(tempObj,stringArray,inputSubString);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println(tempObj);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
	
	case 3:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String");
			inputString=inputObj.getString();
			System.out.println("Enter a Sub String");
			inputSubString=inputObj.getString();
			System.out.println("Enter a String which you want to insert ");
			subString=inputObj.getString();
			tempObj=logicObj.insertString(inputString,inputSubString,subString);
			System.out.println(tempObj);
			
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;	
		
	case 4:	
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(2 strings)");
			stringArray=inputObj.getStringArray(2);
			tempObj=logicObj.doAppend(tempObj,stringArray);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			tempObj=logicObj.deleteString(inputString,inputSubString);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;	
		
	case 5:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(3)");
			stringArray=inputObj.getStringArray(3);
			tempObj=logicObj.doAppend(tempObj,stringArray);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println("Enter a symbol");
			symbol=inputObj.getChar();
			tempObj=logicObj.replaceSymbol(tempObj,symbol);
			System.out.println(tempObj);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
		
	case 6:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(3)");
			stringArray=inputObj.getStringArray(3);
			tempObj=logicObj.doAppend(tempObj,stringArray);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			tempObj=logicObj.reverseString(tempObj);
			System.out.println(tempObj);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
		
	case 7:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(minimum of 10 characters)");
			inputString=inputObj.getString();
			tempObj=logicObj.getStringBuilder(inputString);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println("Enter the starting position");
			start=inputObj.getInt();
			System.out.println("Enter the ending position");
			end=inputObj.getInt();
			tempObj=logicObj.deletePosition(tempObj,start,end);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;	
		
	case 8:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(minimum of 10 characters)");
			inputString=inputObj.getString();
			tempObj=logicObj.getStringBuilder(inputString);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a String Builder : "+number);
			System.out.println("Enter the starting position");
			start=inputObj.getInt();
			System.out.println("Enter the ending position");
			end=inputObj.getInt();
			System.out.println("Enter a sub String you want to replace with");
			inputSubString=inputObj.getString();
			tempObj=logicObj.replacePosition(tempObj,inputSubString,start,end);
			System.out.println(tempObj);
			number=logicObj.getLength(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
		
	case 9:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(3)");
			stringArray=inputObj.getStringArray(3);
			tempObj=logicObj.doAppend(tempObj,stringArray);
			System.out.println(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println("Enter a symbol");
			symbol=inputObj.getChar();
			tempObj=logicObj.replaceSymbol(tempObj,symbol);
			System.out.println(tempObj);
			tempString=Character.toString(symbol);
			number=logicObj.getIndexFirst(tempObj,tempString);
			System.out.println("Position of a symbol(First Occurence) "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;	
		
	case 10:
		try
		{
			tempObj=logicObj.getStringBuilderWithoutArgs();
			System.out.println("Enter a String(3)");
			stringArray=inputObj.getStringArray(3);
			tempObj=logicObj.doAppend(tempObj,stringArray);
			System.out.println(tempObj);
			System.out.println("Length of a StringBuilder : "+number);
			System.out.println("Enter a symbol");
			symbol=inputObj.getChar();
			tempObj=logicObj.replaceSymbol(tempObj,symbol);
			System.out.println(tempObj);
			tempString=Character.toString(symbol);
			number=logicObj.getIndexLast(tempObj,tempString);
			System.out.println("Position of a symbol(Last Occurence) "+number);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
		
	case 11:
		System.out.println("Exit");
		break;
		
	case 12:
		try
		{
		tempObj=logicObj.getStringBuilderWithoutArgs();
		int len=logicObj.getLength(tempObj);
		System.out.println(len);
		System.out.println("Enter a size for an array");
		number=inputObj.getInt();
		System.out.println("Enter a multiple Strings for an array");
		stringArray=inputObj.getStringArray(number);
		//tempObj=logicObj.doAppend(tempObj,stringArray);
		//System.out.println(tempObj);
		System.out.println("Enter a Symbol");
		symbol=inputObj.getChar();
		tempObj=logicObj.doAppend(tempObj,stringArray,symbol);
		System.out.println(tempObj);
		}
		catch(Exception exObj)
		{
			System.out.println(exObj.getMessage());
		}
		break;
		
	default:
		System.out.println("Enter valid Choice");
		break;
	}
}
}




