package myfile;
import java.io.*;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import myException.CustomException;
import validateclass.Checker;

public class FileCreationClass 
{
	
	public File createFile (String name) throws CustomException
	{
		Checker.nullCheck(name);
		try 
		{
		File fileObj=new File(name);
		if(fileObj.createNewFile())
		{
			return fileObj;
		}
			throw new CustomException("File already Exists");
		}
		catch(IOException ioe)
		{
			throw new CustomException(ioe);	
		}
	}
	
	
	public File createFileWithPath (String pathName,String fileName) throws CustomException
	{
		Checker.nullCheck(pathName);
		Checker.nullCheck(fileName);
		try 
		{
		File fileObj=new File(pathName,fileName);
		if(fileObj.createNewFile())
		{
			return fileObj;
		}
		throw new CustomException("File already Exists");
		}
		catch(IOException ioe)
		{
			throw new CustomException(ioe);
		}
		
	}

	
	public void writeToFile (File fileObj,String inputString) throws CustomException//1st task
	{
		Checker.nullCheckFile(fileObj);
		Checker.nullCheck(inputString);
		try (BufferedWriter bwObj = new BufferedWriter(new FileWriter(fileObj))) 
		{
				bwObj.write(inputString);
				bwObj.newLine();
		}
		catch (IOException ioe)
		{
			throw new CustomException(ioe);
		}
	}
	
	//1st
	public void appendToFile (File fileObj,String inputString) throws CustomException//1st task
	{
		Checker.nullCheck(fileObj);
		Checker.nullCheck(inputString);
		try (BufferedWriter bwObj = new BufferedWriter(new FileWriter(fileObj,true))) 
		{	
			bwObj.write(inputString);
			bwObj.newLine();
		}
		catch (IOException ioe)
		{
			throw new CustomException(ioe);
		}
	}
	
	//4th
	public void makeDirectory(String pathName)throws CustomException
	{
		Checker.nullCheck(pathName);
		File fileObj=new File(pathName);
		if(!fileObj.mkdir())
		{
			throw new CustomException("Path already Exists");
		}
	}
	
	public void createJSONFile(String name,JSONObject jObj)throws CustomException
	{
		try(FileWriter writer=new FileWriter(name))
		{
			writer.write(jObj.toJSONString());
		}
		catch (IOException ioe)
		{
			throw new CustomException(ioe);
		}
	}
	
	public JSONObject readJSONFile(String name)throws CustomException
	{
		
		try(FileReader reader=new FileReader(name))
		{
			JSONParser parser=new JSONParser();
			JSONObject jObj=(JSONObject) parser.parse(reader);
			return jObj;
		}
		catch (IOException ioe)
		{
			throw new CustomException(ioe);
		} catch (ParseException e) {
			throw new CustomException(e);
		}
	}
	
}

 