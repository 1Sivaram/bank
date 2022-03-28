package validateclass;
import java.io.File;

import myException.CustomException;

public class Checker 
{
	static public void nullCheck(String dummy)throws CustomException
	{
		if(dummy==null||dummy.isEmpty())
		{
			throw new CustomException("Object can't be Null");
		}
	}
	
	
	static public void nullCheck(Object dummy)throws CustomException
	{
		if(dummy==null)
		{
			throw new CustomException("Object can't be Null");
		}
	}
	
	
	static public void nullCheckFile(Object dummy)throws CustomException
	{
		if(dummy==null)
		{
			throw new CustomException("File can't be Null");
		}
	}
	
	
	public void nullCheckDirectory(File fileObj)throws CustomException
	{
		if(!(fileObj.isDirectory()))
		{
			throw new CustomException("Directory does not Exist");
		}
	}
}
