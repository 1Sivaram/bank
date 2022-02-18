package task1;
import task2.Test;
import task3.Input;

public class TestRunner
{
public static void main(String [] args)
{	
	String inputString=" ";
	String inputString1=" ";
	
	int number=0;
	char letter=' ';
	char [] charArray={};
	Test testObj=new Test();
	
	/*String myName=null;
	try
	{
	testObj.getLength(myName);
	}
	catch (Exception e)
	{
	System.out.println(e.getMessage());
	}*/
	Input inputObj=new Input();
	inputObj.options();
	
	System.out.println("Enter your Choice ");
	int choice=inputObj.getInt();
	switch(choice)
	{
	case 0:
		try
		{
		//testObj.getLength(myName);
		int num=testObj.getLength(args[0]);
		System.out.println(num);
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 1:
		try
		{
		System.out.println("Enter a String that you want to change into char array");
		inputString=inputObj.getString();
		charArray=testObj.changeToChar(inputString);
		for(char c : charArray)
		{
		System.out.println(c);
		}
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 2:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a position where you want to find a character(from back)");
		number=inputObj.getInt();
		//inputString=null;
		System.out.println(testObj.penultimate(inputString,number));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 3:	
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a letter to find the number of occurence it made on a above string");
		letter=inputObj.getChar();
		System.out.println(testObj.occur(inputString,letter));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 4:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a letter to find the gratest position of the given String");
		letter=inputObj.getChar();
		System.out.println(testObj.position(inputString,letter));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 5:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("How many letters you want to print(from the back)?");
		number=inputObj.getInt();
		System.out.println(testObj.printFromBack(inputString,number));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 6:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("How many letters you want to print(from the front)?");
		number=inputObj.getInt();
		System.out.println(testObj.printFromFront(inputString,number));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 7:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a sub-String you want to replace with");
		inputString1=inputObj.getSubString();
		System.out.println(testObj.replaces(inputString,inputString1));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 8:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a String you want to check with whether a string starts with");
		inputString1=inputObj.getSubString();
		System.out.println(testObj.StartCheck(inputString,inputString1));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 9:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a String you want to check with whether a string ends with");
		inputString1=inputObj.getSubString();
		System.out.println(testObj.EndCheck(inputString,inputString1));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 10:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println(testObj.convertUpper(inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 11:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println(testObj.convertLower(inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 12:
		try
		{
		System.out.println("Enter a String you want to reverse");
		inputString=inputObj.getString();
		System.out.println(testObj.reverseString(inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 13: 
		try
		{
		System.out.println("Enter a String");
		System.out.println(inputObj.getString());
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 14:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println(testObj.multiple(inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 15:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		String [] stringArray=testObj.stringToArray(inputString);
		for(String s:stringArray)
		{
		System.out.println(s);
		}
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 16:
		try
		{
		System.out.println("Enter a array size");
		number=inputObj.getInt();
		System.out.println("Enter a String");
		String [] stringArray=inputObj.getStringArray(number);
		System.out.println("Enter a symbol you want to join the array with");
		inputString=inputObj.getString();
		System.out.println(testObj.mergeString(stringArray,inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 17:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a String you want to compare with(case sensitive)");
		inputString1=inputObj.getSubString();
		System.out.println(testObj.equal(inputString,inputString1));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 18:
		try
		{
		System.out.println("Enter a String");
		inputString=inputObj.getString();
		System.out.println("Enter a String you want to compare with(non case sensitive)");
		inputString1=inputObj.getSubString();
		System.out.println(testObj.ignoreEquals(inputString,inputString1));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	case 19:
		try
		{
		System.out.println("Enter a String with spaces front and back");
		inputString=inputObj.getString();
		System.out.println(testObj.noSpace(inputString));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		break;
	
	default:
		System.out.println("Enter valid choice");
		break;
	}
	inputObj.closeResources();
	
}
}

