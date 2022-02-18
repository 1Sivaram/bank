package logichashmap;
import list.ListLogicLayer;
import java.util.*;
import myException.NullCheckCustomException;


public class HashMapLogicLayer
{
	ListLogicLayer listObj=new ListLogicLayer();
	
	public void nullCheck(Map <Object,Object>myMapObj)throws NullCheckCustomException
	{
		if(myMapObj==null)
		{
			throw new NullCheckCustomException("HashMap can't be Null");
		}
	}
	
	
	public Map <Object,Object> getHashMap()
	{
		Map <Object,Object> myMapObj=new HashMap<Object,Object>();
		return myMapObj;
	}

	
	public int getSize(Map <Object,Object>myMapObj)throws NullCheckCustomException//1st
	{
		nullCheck(myMapObj);
		int size=myMapObj.size();
		return size;
	}
	
	
	public Map <Object,Object> addValues(Map <Object,Object>myMapObj,Object key,Object value)throws NullCheckCustomException//2nd,3rd,4th,5th,6th,7th
	{
		nullCheck(myMapObj);
		myMapObj.put(key,value);
		return myMapObj;
	}
	
	
	/*public Map <Object,Object> addValues(Map <Object,Object>myMapObj,Object [] key,Object [] value)throws NullCheckCustomException//2nd,3rd,4th,5th,6th
	{
		nullCheck(myMapObj);
		listObj.nullCheck(key);
		listObj.nullCheck(value);
		int length=key.length;
		for(int index=0;index<length;index++)
		{
			addValues(myMapObj,key[index],value[index]);
		}
		return myMapObj;
	}*/
	
	
	public boolean checkKey(Map <Object,Object>myMapObj,Object key)throws NullCheckCustomException//8th
	{
		nullCheck(myMapObj);
		boolean output=myMapObj.containsKey(key);
		return output;
	}
	
	
	public boolean checkValue(Map <Object,Object>myMapObj,Object value)throws NullCheckCustomException//9th
	{
		nullCheck(myMapObj);
		boolean output=myMapObj.containsValue(value);
		return output;
	}
	
	
	/*public Map <Object,Object> replaceValue(Map <Object,Object>myMapObj,Object [] key,Object [] replaceValues)throws NullCheckCustomException//10th
	{
		nullCheck(myMapObj);
		listObj.nullCheck(key);
		listObj.nullCheck(value);
		int length=key.length;
		for(int index=0;index<length;index++)
		{
			replaceValue(myMapObj,key[index],replaceValues[index]);//16th
		}
		return myMapObj;
	}*/
	
	
	public Object getValue(Map <Object,Object>myMapObj,Object key)throws NullCheckCustomException//11th,12th
	{
		nullCheck(myMapObj);
		Object dummyObj=myMapObj.get(key);
		return dummyObj;
	}
	
	
	public Object getDefaultValue(Map <Object,Object>myMapObj,Object key,String defaultString)throws NullCheckCustomException//13th
	{
		nullCheck(myMapObj);
		Object dummyObj=myMapObj.getOrDefault(key,defaultString);
		return dummyObj;
	}
	
	
	public Map <Object,Object> removeKey(Map <Object,Object>myMapObj,Object key)throws NullCheckCustomException//14th
	{
		nullCheck(myMapObj);
		myMapObj.remove(key);
		return myMapObj;
	}
	
	
	public Map <Object,Object> removeKeyWithValue(Map <Object,Object>myMapObj,Object key,Object value)throws NullCheckCustomException//15th
	{
		nullCheck(myMapObj);
		myMapObj.remove(key,value);
		return myMapObj;
	}
	
	
	public Map <Object,Object> replaceValue(Map <Object,Object>myMapObj,Object key,Object replaceValue)throws NullCheckCustomException//16th
	{
		nullCheck(myMapObj);
		myMapObj.replace(key,replaceValue);
		return myMapObj;
	}
	
	
	public Map <Object,Object> replaceOldValue(Map <Object,Object>myMapObj,Object key,Object oldValue,Object newValue)throws NullCheckCustomException//17th
	{
		nullCheck(myMapObj);
		myMapObj.replace(key,oldValue,newValue);
		return myMapObj;
	}
	
	
	public Map <Object,Object> copyMap(Map <Object,Object>myMapObj,Map <Object,Object> outputObj)throws NullCheckCustomException//18th
	{
		nullCheck(myMapObj);
		nullCheck(outputObj);
		outputObj.putAll(myMapObj);
		return outputObj;
	}
	
	
	public void printMap(Map <Object,Object>myMapObj)throws NullCheckCustomException//19th
	{
		nullCheck(myMapObj);
		for(Object key:myMapObj.keySet())
		{
			Object value=getValue(myMapObj,key);
			System.out.println("Key : "+key+" Value: "+value);
		}
	}
	
	
	public Map <Object,Object> clearMap(Map <Object,Object>myMapObj)throws NullCheckCustomException//20th
	{
		nullCheck(myMapObj);
		myMapObj.clear();
		return myMapObj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
