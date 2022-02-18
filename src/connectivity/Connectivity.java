package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import myException.CustomException;

enum Connectivity 
{
	CONNECT;
	private Connection connect=null;
	public Connection getConnect() throws CustomException
	{
		if(connect==null)
		{
		String url="jdbc:mysql://localhost:3306/StudentDetails";
		String uName="root";
		String uPassword="vallaK@6";
		try
		{
			connect=DriverManager.getConnection(url,uName,uPassword);
			return connect;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
		}
		else
		{
			return connect;
		}
	}
	public void closeConnect()
	{
		try
		{
			if(connect!=null)
			{
				connect.close();
			}
		}
		catch(SQLException e){}
	}
}