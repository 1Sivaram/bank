package list;
import java.util.*;
import task2.Test;

public class ListLogicLayer
{
	Test testObj=new Test();

public void nullCheck(List listObj) throws Exception
{
	if (listObj==null)
	{
		throw new Exception("List can't be Null");
	}
}


public void nullCheck(Object [] dummy)throws Exception
	{
		if(dummy==null)
		{
			throw new Exception("HashMap can't be Null");
		}
	}


public void printList(List listObj)throws Exception//7th task
{
	nullCheck(listObj);
	Iterator iteratorObj=listObj.iterator();
	while(iteratorObj.hasNext())
	{
		System.out.println(iteratorObj.next());
	}
}


public List getArrayList()
{
	List listObj=new ArrayList();
	return listObj;
}


public int getSize(List listObj)throws Exception//1st task
{
	nullCheck(listObj);
	int size=listObj.size();
	return size;
}


public List addList(List listObj,Object dummy)throws Exception//4th task
{
	nullCheck(listObj);
	listObj.add(dummy);
	return listObj;
}


public List addList(List listObj,Object [] obj)throws Exception//2nd,3rd,14th,19th task
{
	nullCheck(listObj);
	nullCheck(obj);
	for(Object dummy:obj)
	{
		addList(listObj,dummy);
	}
	//(Alternative)Collections.addAll(listObj,obj);
	//nullCheckElements(listObj);
	return listObj;
}


public int findIndex(List listObj,String checkString)throws Exception//6th task
{
	nullCheck(listObj);
	//testObj.nullCheckString(checkString);
	int index=listObj.indexOf(checkString);
	return index;
}


public Object findString(List listObj,int index)throws Exception//8th task
{
	nullCheck(listObj);
	testObj.numCheck(getSize(listObj),index);
	Object dummy=listObj.get(index);
	return dummy;
}


public int findLastIndex(List listObj,String checkString)throws Exception//9th task
{
	nullCheck(listObj);
	//testObj.nullCheckString(checkString);
	int index=listObj.lastIndexOf(checkString);
	return index;
}


public List insertString(List listObj,String insertString,int position)throws Exception//10th task
{
	nullCheck(listObj);
	//testObj.nullCheckString(insertString);
	testObj.numCheck(getSize(listObj),position);
	listObj.set(position,insertString);
	return listObj;
}


public List copyList(List listObj,int start,int end) throws Exception//11th task
{
	nullCheck(listObj);
	testObj.numCheck(getSize(listObj),end);
	testObj.numCheck(end,start);
	List copyObj=listObj.subList(start,end);
	return copyObj;	
}


public List addAllList(List outputObj,List listObj)throws Exception//12th,13th task
{
	nullCheck(outputObj);
	nullCheck(listObj);
	outputObj.addAll(listObj);
	return outputObj;
}


public List removeObj(List listObj,Object input)throws Exception//14th task
{
	nullCheck(listObj);
	listObj.remove(input);
	return listObj;
}


public List removeValue(List listObj,int position)throws Exception//15th task
{
	nullCheck(listObj);
	testObj.numCheck(getSize(listObj), position);
	listObj.remove(position);
	return listObj;
}


public List removeList(List listObj,List secondList)throws Exception//17th task
{
	nullCheck(listObj);
	nullCheck(secondList);
	listObj.removeAll(secondList);
	return listObj;
}


public List retainElements(List listObj,List secondList)throws Exception//18th task
{
	nullCheck(listObj);
	nullCheck(secondList);
	listObj.retainAll(secondList);
	return listObj;
}


public List clearList(List listObj)throws Exception//19th task
{
	nullCheck(listObj);
	listObj.clear();
	return listObj;
}


public boolean checkElement(List listObj, String inputString)throws Exception//20th task
{
         nullCheck (listObj);
	//testObj.nullCheckString(inputString);
	boolean output=listObj.contains(inputString);
	return output;
}




}


