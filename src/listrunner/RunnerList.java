package listrunner;
import task3.Input;
import list.ListLogicLayer;
import java.util.*;

public class RunnerList
{
	ListLogicLayer listObj=new ListLogicLayer();
	Input inputObj=new Input();
	int size=0;
	int index=0;
	int start=0;
	int end=0;
	String dummyString="";
	String [] stringArray={""};
	Integer [] integerArray={};
	Double [] doubleArray={};
	Long [] longArray={};
	
	private void case1(List tempObj)
	{
		try
		{
			System.out.println("Printing the Output");
			listObj.printList(tempObj);
			size=listObj.getSize(tempObj);
			System.out.println("Length of ArrayList is :"+size);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	private List stringAdd(List tempObj)throws Exception
	{
		System.out.println("Enter a size for an String array");
		size=inputObj.getInt();
		stringArray=inputObj.getStringArray(size);
		tempObj=listObj.addList(tempObj,stringArray);
		return tempObj;
	}
	
	private void case2(List tempObj)
	{
		try
		{
		tempObj=stringAdd(tempObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	private List intAdd(List tempObj)throws Exception
	{
		System.out.println("Enter a size for an Int array");
		size=inputObj.getInt();
		integerArray=inputObj.getIntegerArray(size);
		tempObj=listObj.addList(tempObj,integerArray);
		return tempObj;
	}
	
	private void case3(List tempObj)
	{
		try
		{
			tempObj=stringAdd(tempObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	private void case4(List tempObj)
	{
		try
		{
			 
			tempObj=listObj.addList(tempObj,inputObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	private void case5(List tempObj)
	{
		case2(tempObj);
		case3(tempObj);
		case4(tempObj);
		case1(tempObj);
	}
	
	private void case6(List tempObj)
	{

		try
		{
			tempObj=stringAdd(tempObj);
			System.out.println("Enter a string you want to find the index for");
			dummyString=inputObj.getString();
			index=listObj.findIndex(tempObj,dummyString);
			System.out.println("Index of a given String is : "+index);
			case1(tempObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	private void case7(List tempObj)
	{
		try
		{
		tempObj=stringAdd(tempObj);
		case1(tempObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	
	private void case8(List tempObj)
	{

		try
		{
			tempObj=stringAdd(tempObj);
			System.out.println("Enter a index number to find a String");
			index=inputObj.getInt();
			Object dummy=listObj.findString(tempObj,index);
			System.out.println("String of a given index number is : "+dummy);
			case1(tempObj);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
	}
	
	
	
	
public static void main(String [] args)
{
	RunnerList runnerObj=new RunnerList();
	
	ListLogicLayer listObj=new ListLogicLayer();
	Input inputObj=new Input();
	int size=0;
	int index=0;
	int start=0;
	int end=0;
	String dummyString="";
	String [] stringArray={""};
	Integer [] integerArray={};
	Double [] doubleArray={};
	Long [] longArray={};
	int choice=inputObj.getInt();
	List tempObj=listObj.getArrayList();
	
	switch(choice)
	{
		case 0:
			System.out.println("Exit");
			break;
		
		case 1:
			runnerObj.case1(tempObj);
			break;
		
		case 2:
			runnerObj.case2(tempObj);
			runnerObj.case1(tempObj);
			break;
			
		case 3:
			runnerObj.case3(tempObj);
			runnerObj.case1(tempObj);
			break;
			
		case 4:
			runnerObj.case4(tempObj);
			runnerObj.case1(tempObj);
			break;
			
		case 5:
			runnerObj.case5(tempObj);
			break;
			
		case 6:
			runnerObj.case6(tempObj);
			break;
			
		case 7:
			runnerObj.case7(tempObj);
			break;
			
		case 8:
			runnerObj.case8(tempObj);
			break;
			
		case 9:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a string you want to find the first and last occurence for");
				dummyString=inputObj.getString();
				index=listObj.findIndex(tempObj,dummyString);
				System.out.println("First occurence of a given String is : "+index);
				index=listObj.findLastIndex(tempObj,dummyString);
				System.out.println("Last occurence of a given String is : "+index);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 10:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a string you want to add");
				dummyString=inputObj.getString();
				System.out.println("Enter a position you want to add the string inside the ArrayList");
				index=inputObj.getInt();
				tempObj=listObj.insertString(tempObj,dummyString,index);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 11:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a starting position to copy the ArrayList");
				start=inputObj.getInt();
				System.out.println("Enter a ending position to copy the ArrayList");
				end=inputObj.getInt();
				tempObj=listObj.copyList(tempObj,start,end);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 12:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				List secondObj=listObj.getArrayList();
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				secondObj=listObj.addList(secondObj,stringArray);
				tempObj=listObj.addAllList(tempObj,secondObj);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 13:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				List secondObj=listObj.getArrayList();
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				secondObj=listObj.addList(secondObj,stringArray);
				tempObj=listObj.addAllList(secondObj,tempObj);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 14:
			try
			{
				 
				System.out.println("Enter a size for a Double array");
				size=inputObj.getInt();
				doubleArray=inputObj.getDoubleArray(size);
				tempObj=listObj.addList(tempObj,doubleArray);
				System.out.println("Enter a decimal value you want to remove from the ArrayList");
				Double decimal=inputObj.getDouble();
				tempObj=listObj.removeObj(tempObj,decimal);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 15:
			try
			{
				 
				System.out.println("Enter a size for a Double array");
				size=inputObj.getInt();
				doubleArray=inputObj.getDoubleArray(size);
				tempObj=listObj.addList(tempObj,doubleArray);
				System.out.println("Enter a position you want to remove from the ArrayList");
				index=inputObj.getInt();
				tempObj=listObj.removeValue(tempObj,index);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 17:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a starting position to copy the ArrayList");
				start=inputObj.getInt();
				System.out.println("Enter a ending position to copy the ArrayList");
				end=inputObj.getInt();
				List secondObj=listObj.copyList(tempObj,start,end);
				System.out.println("The copied second ArrayList is ");
				listObj.printList(secondObj);
				tempObj=listObj.removeList(tempObj,secondObj);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 18:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a starting position to copy the ArrayList");
				start=inputObj.getInt();
				System.out.println("Enter a ending position to copy the ArrayList");
				end=inputObj.getInt();
				List secondObj=listObj.copyList(tempObj,start,end);
				System.out.println("The copied second ArrayList is ");
				listObj.printList(secondObj);
				tempObj=listObj.retainElements(tempObj,secondObj);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 19:
			try
			{
				 
				System.out.println("Enter a size for a long array");
				size=inputObj.getInt();
				longArray=inputObj.getLongArray(size);
				tempObj=listObj.addList(tempObj,longArray);
				System.out.println("Printing the long array");
				listObj.printList(tempObj);
				tempObj=listObj.clearList(tempObj);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		case 20:
			try
			{
				 
				System.out.println("Enter a size for an String array");
				size=inputObj.getInt();
				stringArray=inputObj.getStringArray(size);
				tempObj=listObj.addList(tempObj,stringArray);
				System.out.println("Enter a string you want to check whether the ArrayList have it or not");
				dummyString=inputObj.getString();
				boolean output=listObj.checkElement(tempObj,dummyString);
				System.out.println("Does the given String present in the ArrayList? : "+output);
				System.out.println("Printing the Output");
				listObj.printList(tempObj);
				size=listObj.getSize(tempObj);
				System.out.println("Length of ArrayList is :"+size);
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
			}
			break;
			
		default:
			System.out.println("Enter your valid choice");
			break;
	}
	
}
}
