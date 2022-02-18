package runnerFile;
import java.io.*;
import java.util.Properties;
import task3.Input;
import myException.CustomException;
import myfile.FileCreationClass;
import properties.PropertiesClass;
import constructortask.ConstructorTask;


public class FileRunner 
{
	FileCreationClass fcObj=new FileCreationClass();
	PropertiesClass objProperties=new PropertiesClass();
	Input objInput=new Input();
	
	private File getFile() throws CustomException
	{
		System.out.println("Enter a name for a File");
		String fileName=objInput.getString();
		File fileObj=fcObj.createFile(fileName);
		return fileObj;
	}
	
	private void writeInFile(File fileObj)throws CustomException
	{
			System.out.println("How many string you want to add into the file");
			int size=objInput.getInt();
			for(int index=0;index<size;index++)
			{
				System.out.println("Enter a string you want to write on a file");
				String inputString=objInput.getString();
				fcObj.appendToFile(fileObj, inputString);
			}
			System.out.println("Successfully written into the file");
	}
	
	private void case1()
	{
		try
		{
			File fileObj=getFile();
			writeInFile(fileObj);
		}
		catch(CustomException exc)
		{
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}
		catch(Exception e) 
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
		}
	}
	
	private Properties loadInProperties()throws CustomException
	{
		
		Properties myProp=objProperties.createProperty();
		System.out.println("Enter a Size");
		int size=objInput.getInt();
		for(int index=0;index<size;index++)
		{
			System.out.println("Enter a Key");
			String key=objInput.getString();
			System.out.println("Enter a value");
			String value=objInput.getString();
			objProperties.loadValues(myProp, key, value);
		}
		System.out.println("Successfully loaded values in Properties");
		return myProp;
	}
	
	private void case2()
	{
		try
		{
			Properties myProp=loadInProperties();
			File fileObj=getFile();
			objProperties.storeValues(myProp, fileObj);
			System.out.println("Successfully stored the values inside the File");
		}
		catch(CustomException exc)
		{
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}
	
	private void case3()
	{
		try
		{
			Properties myProp=objProperties.createProperty();
			System.out.println("Enter the name of the file which you want to fetch the data");
			String fileName=objInput.getString();
			myProp=objProperties.readValues(myProp,fileName);
			System.out.println(myProp);
			System.out.println("Successfully readed the file");
		}
		catch(CustomException exc)
		{
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}
	
	private String pathCreate()throws CustomException
	{
		System.out.println("Enter a Path name for creating a directory");
		String pathName=objInput.getString();
		fcObj.makeDirectory(pathName);
		System.out.println("path successfully created");
		return pathName;
	}
	private File fileWithPath(String pathName)throws CustomException
	{
		System.out.println("Enter a File name");
		String fileName=objInput.getString();
		File fileObj=fcObj.createFileWithPath(pathName, fileName);
		System.out.println("File successfully created");
		return fileObj;
	}
	
	private void case4()
	{
		try
		{
			String pathName=pathCreate();
			File fileObj=fileWithPath(pathName);
			writeInFile(fileObj);
			Properties myProp=loadInProperties();
			File secondFile=fileWithPath(pathName);
			objProperties.storeValues(myProp,secondFile);
			case3();
		}
		catch(CustomException exc)
		{
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}
	
	private void case5()
	{
		System.out.println("Enter your name ");
		String name=objInput.getString();
		ConstructorTask fcObj1=new ConstructorTask(name);
		System.out.println(fcObj1);
	}
	
	public static void main(String[] args) 
	{
		Input objInput=new Input();
		FileRunner runnerObj=new FileRunner();
		System.out.println("Enter your choice");
		int choice=objInput.getInt();
		switch(choice)
		{
		case 0:
			System.out.println("Exit");
			break;
			
		case 1:
			runnerObj.case1();
			break;

		case 2:
			runnerObj.case2();
			break;
			
		case 3:
			runnerObj.case3();
			break;

		case 4:
			runnerObj.case4();
			break;
			
		case 5:
			runnerObj.case5();
			break;
			
		default:
			System.out.println("Enter your valid choice");
			break;
		}
	}
}
