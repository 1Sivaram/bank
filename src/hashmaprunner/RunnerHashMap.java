package hashmaprunner;
import task3.Input;
import logichashmap.HashMapLogicLayer;
import java.util.*;
import myException.NullCheckCustomException;

public class RunnerHashMap
{
public static void main(String [] args)
{
	HashMapLogicLayer mapLogicObj=new HashMapLogicLayer();
	Input inputObj=new Input();
	int choice=inputObj.getInt();
	
	String key="";
	String value="";
	int size=0;
	
	switch(choice)
	{
		case 0:
			System.out.println("Exit");
			break;
		
		case 1:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
		
		case 2:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 3:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a Integer for Key : ");
				int intKey=inputObj.getInt();
				System.out.println("Enter a Integer for Value: ");
				int intValue=inputObj.getInt();
				mapLogicObj.addValues(tempObj,intKey,intValue);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 4:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a String for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a Integer for Value: ");
				int intValue=inputObj.getInt();
				mapLogicObj.addValues(tempObj,key,intValue);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 5:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			Object [] dummyObj={inputObj,tempObj,mapLogicObj};
			size=dummyObj.length;
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a String for Key : ");
				key=inputObj.getString();
				System.out.println("Putting the custom made Object for a given key ");
				mapLogicObj.addValues(tempObj,key,dummyObj[index]);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 6:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a String for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				if(index==0)
				{
					value=null;
				}
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 7:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a String for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				if(index==0)
				{
					key=null;
				}
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 8:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Enter a Key you want to check whether its exists or not(inside the Map) ");
			String checkKey=inputObj.getString();
			boolean output=mapLogicObj.checkKey(tempObj,checkKey);
			System.out.println("Does the Key exist inside the Map? : "+output);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 9:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Enter a Value you want to check whether its exists or not(inside the Map) ");
			String checkValue=inputObj.getString();
			boolean output=mapLogicObj.checkValue(tempObj,checkValue);
			System.out.println("Does the Value exist inside the Map? : "+output);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 10:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			for(Object keyString:tempObj.keySet())
			{
				System.out.println("Enter a new value for this Key : "+keyString);
				String newValue=inputObj.getString();
				mapLogicObj.replaceValue(tempObj,keyString,newValue);
			}
			System.out.println("Printing the Map after changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 11:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Enter a Key to get a value ");
			String inputKey=inputObj.getString();
			Object output=mapLogicObj.getValue(tempObj,inputKey);
			System.out.println("Value for a given Key : "+output);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 12:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Enter a Key to get a value ");
			String inputKey=inputObj.getString();
			Object output=mapLogicObj.getValue(tempObj,inputKey);
			System.out.println("Value for a given Key : "+output);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 13:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Enter a String for a Map to have default value ");
			String defaultString=inputObj.getString();
			System.out.println("Enter a Key to get a value ");
			String inputKey=inputObj.getString();
			Object output=mapLogicObj.getDefaultValue(tempObj,inputKey,defaultString);
			System.out.println("Value for a given Key : "+output);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 14:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			System.out.println("Enter a Key that you want to remove it from the Map ");
			String removeKey=inputObj.getString();
			mapLogicObj.removeKey(tempObj,removeKey);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 15:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			System.out.println("Enter a Key and the value of a key that you want to remove from the Map");
			key=inputObj.getString();
			value=inputObj.getString();
			mapLogicObj.removeKeyWithValue(tempObj,key,value);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 16:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			System.out.println("Enter a Key that you want to replace the value from the Map");
			key=inputObj.getString();
			System.out.println("Enter a new value for this key : "+key);
			String replaceValue=inputObj.getString();
			mapLogicObj.replaceValue(tempObj,key,replaceValue);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 17:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			System.out.println("Enter a Key and its value that you want to replace the value from the Map");
			key=inputObj.getString();
			value=inputObj.getString();
			System.out.println("Enter a new value for this key : "+key);
			String replaceValue=inputObj.getString();
			mapLogicObj.replaceOldValue(tempObj,key,value,replaceValue);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 18:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the first HashMap");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			Map <Object,Object> secondTempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(secondTempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(secondTempObj);
			size=mapLogicObj.getSize(secondTempObj);
			System.out.println("Length of HashMap is :"+size);
			
			secondTempObj=mapLogicObj.copyMap(tempObj,secondTempObj);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(secondTempObj);
			size=mapLogicObj.getSize(secondTempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 19:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Output");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		case 20:
			try
			{
			Map <Object,Object> tempObj=mapLogicObj.getHashMap();
			System.out.println("Enter a size for an array");
			size=inputObj.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string for Key : ");
				key=inputObj.getString();
				System.out.println("Enter a string for Value: ");
				value=inputObj.getString();
				mapLogicObj.addValues(tempObj,key,value);
			}
			System.out.println("Printing the Map before changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);
			
			tempObj=mapLogicObj.clearMap(tempObj);
			System.out.println("Printing the Map After changes");
			mapLogicObj.printMap(tempObj);
			size=mapLogicObj.getSize(tempObj);
			System.out.println("Length of HashMap is :"+size);	
			}
			catch(NullCheckCustomException myExc)
			{
				System.out.println(myExc.getMessage());
			}
			catch(Exception exc)
			{
				System.out.println("Exception occured");
			}
			break;
			
		default:
			System.out.println("Enter your valid choice");
			break;
	}
	
}
}
