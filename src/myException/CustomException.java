package myException;


public class CustomException extends Exception
{
	public CustomException(String message) 
	{
		super(message);
	}

	public CustomException(Exception ioe) 
	{
		super(ioe);	
	}
}
