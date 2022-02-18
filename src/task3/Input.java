package task3;
import java.util.*;

public class Input
{
Scanner scan=new Scanner(System.in);
public String getString()
{
	String inputString="";

	try
	{
	inputString=scan.nextLine();
	if(inputString.isEmpty())
	{
	throw new Exception("String cannot be Empty!");
	}
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
	return inputString;
}

public String getSubString()
{
	String inputString1="";
	try
	{
	inputString1=scan.nextLine();
	if(inputString1.isEmpty())
	{
	throw new Exception("String cannot be EMpty!");
	}
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
	return inputString1;
}

public int getInt()
{
	int number=0;
	try
	{
	number=scan.nextInt();
	scan.nextLine();
	}
	catch(Exception e)
	{
	System.out.println("Enter valid Number");
	}
	return number;
}

public char getChar()
{
	char letter=' ';
	try
	{
	String letterString=scan.nextLine();
	if(letterString.isEmpty()||letterString.length()>1)
	{
	throw new Exception();
	}
	letter=letterString.charAt(0);
	}
	catch(Exception e)
	{
	System.out.println("Enter a valid character");
	}
	return letter;
}

public double getDouble()
{
	double decimal=0.0;
	try
	{
	decimal=scan.nextDouble();
	scan.nextLine();
	}
	catch(Exception e)
	{
	System.out.println("Enter a valid input");
	}
	return decimal;
}

public long getLong()
{
	long number=0;
	try
	{
	number=scan.nextLong();
	scan.nextLine();
	}
	catch(Exception e)
	{
	System.out.println("Enter a valid input");
	}
	return number;
}

public String[] getStringArray(int j)//17th task
{
	String sub1[]={"Garbage Input"};
	try
	{
	if(j>10)
	{
	throw new Exception();
	}
	String [] sub=new String[j];
	for(int i=0;i<j;i++)
	{
	sub[i]=scan.nextLine();
	if(sub[i].isEmpty())
	{
	throw new Exception();
	}}
	return sub;
	}
	catch(Exception e)
	{
	System.out.println("Enter a valid String");
	}
	/*String [] sub=new String[j];
	for(int i=0;i<j;i++)
	{
	sub[i]=scan.nextLine();
	}*/
	return sub1;
}


/*public int[] getIntArray(int size)
{
	int [] intArray=new int[size];
	for(int dummy=0;dummy<size;dummy++)
	{
		intArray[dummy]=getInt();
	}
	return intArray;
}


public double[] getDoubleArray(int size)
{
	double [] doubleArray=new double[size];
	for(int dummy=0;dummy<size;dummy++)
	{
		doubleArray[dummy]=getDouble();
	}
	return doubleArray;
}


public long[] getLongArray(int size)
{
	long [] longArray=new long[size];
	for(int dummy=0;dummy<size;dummy++)
	{
		longArray[dummy]=getLong();
	}
	return longArray;
}*/

public Integer getInteger()
{
	Integer number=getInt();
	return number;
}


public Integer[] getIntegerArray(int size)
{
	//int [] intArray=getIntArray(size);
	Integer [] integerArray=new Integer[size];
	for(int index=0;index<size;index++)
	{
		integerArray[index]=getInt();
	}
	return integerArray;

}

public Double[] getDoubleArray(int size)
{
	//int [] intArray=getIntArray(size);
	Double [] doubleArray=new Double[size];
	for(int index=0;index<size;index++)
	{
		doubleArray[index]=getDouble();
	}
	return doubleArray;
}

public Long[] getLongArray(int size)
{
	//int [] intArray=getIntArray(size);
	Long [] longArray=new Long[size];
	for(int index=0;index<size;index++)
	{
		longArray[index]=getLong();
	}
	return longArray;

}

public void options()
{
	System.out.println("0.Get lenth from a String"+"\n"+"1.Converting the String to Char array"+"\n"+"2.Finding the character in a String"+"\n"+"3.Finding the number of occurence of a single letter in a String"+"\n"+"4.Print the greatest position of a repeated character"+"\n"+"5.Printing the last 5 character in a String"+"\n"+"6.Print the first 3 Letters of given string"+"\n"+"7.replace the first 3 letters in a String"+"\n"+"8.checking the string starts with ent"+"\n"+"9.checking the string ends with le"+"\n"+"10.converting a string to its uppercase"+"\n"+"11.converting a string to its lowercase"+"\n"+"12.reverse a string"+"\n"+"13.accept a line with multiple Strings"+"\n"+"14.concatenate each Strings and print without spaces"+"\n"+"15.accept a line with multiple strings and change the string into an array"+"\n"+"16.accept a multiple string and merge a string with - "+"\n"+"17.checking whether the String is equal or not case sensitive"+"\n"+"18.checking whether the String is equal or not. case Non sensitive"+"\n"+"19.output the string without the spaces");
	
}



public void closeResources()
{
scan.close();
}
}


