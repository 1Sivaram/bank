package runner;
import task3.Input;
import connectivity.DBConnectivity;
import myException.CustomException;

public class DBRunner 
{
	DBConnectivity db=new DBConnectivity();
	Input input=new Input(); 
	
	private void case1()
	{
		//System.out.println("Enter a query for a create");
		String query="create table Student(studentId int,studentName varchar(30),age int,Address varchar(200))";
		try 
		{
			db.createTable(query);
			System.out.println("Table is created");
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void case2()
	{
		System.out.println("Enter a query for insert");
		String query=input.getString();
		try 
		{
			System.out.println(db.insertRecord(query));
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void case3()
	{
		System.out.println("Enter a query for update");
		String query=input.getString();
		try 
		{
			System.out.println(db.updateRecord(query));
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void case4()
	{
		System.out.println("Enter a query for update");
		String query=input.getString();
		try 
		{
			System.out.println(db.deleteRecord(query));
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void case5()
	{
		System.out.println("Enter a query for select");
		String query=input.getString();
		try 
		{
			System.out.println(db.selectRecord(query));
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void closeScanner()
	{
		input.closeResources();
	}
	
	public static void main(String[] args)
	{
		Input input=new Input();
		DBRunner runner=new DBRunner();
		boolean flag=true;
		while(flag)
		{
			System.out.println("Enter your choice");
			int choice=input.getInt();
	
			switch(choice)
			{
			
			case 0:
				flag=false;
				System.out.println("Exit");
				break;
			case 1:
				runner.case1();
				break;
				
			case 2:
				runner.case2();
				break;
				
			case 3:
				runner.case3();
				break;
				
			case 4:
				runner.case4();
				break;
				
			case 5:
				runner.case5();
				break;
				
			case 6:
				runner.closeScanner();
				break;
				
			default:
				System.out.println("Enter a valid choice");
			}
		}
		input.closeResources();
	}
}
