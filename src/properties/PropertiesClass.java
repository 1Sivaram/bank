package properties;
import java.util.*;
import java.io.*;
import myException.CustomException;
import validateclass.Checker;


public class PropertiesClass 
{
	Checker checkObj=new Checker();
	
	public Properties createProperty()
	{
		Properties objProperties=new Properties();
		return objProperties;
	}
	
	//2nd
	public Properties loadValues(Properties objProperties,String key,String value) throws CustomException
	{
		Checker.nullCheck(objProperties);
		checkObj.nullCheck(value);
		checkObj.nullCheck(key);
		objProperties.setProperty(key, value);
		return objProperties;
	}
	
	//2nd
	public void storeValues(Properties objProperties,File fileObj) throws CustomException
	{
		checkObj.nullCheck(objProperties);
		checkObj.nullCheckFile(fileObj);
		try(BufferedWriter objWriter=new BufferedWriter(new FileWriter(fileObj)))
		{
			objProperties.store(objWriter, "Writting in a file");
		}
		catch(IOException ioe)
		{
			throw new CustomException(ioe);
		}
	}
	
	//3rd
	public Properties readValues(Properties objProperties,String fileName) throws CustomException
	{
		checkObj.nullCheck(objProperties);
		checkObj.nullCheck(fileName);
		try(BufferedReader objReader=new BufferedReader(new FileReader(fileName)))
		{
			objProperties.load(objReader);
			if(objProperties.isEmpty())
			{
				throw new CustomException("File is Empty");
			}
			return objProperties;
		}
		catch(IOException ioe)
		{
			throw new CustomException(ioe);
		}
		
	}
	
}
