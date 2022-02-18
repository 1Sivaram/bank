package connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import myException.CustomException;

public class DBConnectivity
{	
	public void createTable(String query) throws CustomException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();)
		{
			statement.execute(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int insertRecord(String query) throws CustomException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();)
		{
			int number=statement.executeUpdate(query);
			return number;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int updateRecord(String query) throws CustomException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();)
		{
			int number=statement.executeUpdate(query);
			return number;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int deleteRecord(String query) throws CustomException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();)
		{
			int number=statement.executeUpdate(query);
			return number;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,TableInfo> selectRecord(String query) throws CustomException
	{
		Map<Integer,TableInfo> map=new HashMap<>();
		
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(query))
		{
			while (result.next())
			{
				TableInfo info=new TableInfo();
				info.setStudentId(result.getInt("studentId")); 
				info.setStudentName(result.getString("studentName"));
				info.setAge(result.getInt("age"));
				info.setAddress(result.getString("address"));
				map.put(info.getStudentId(), info);
			}
			return map;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int insertPrepared(String value,String condition)throws CustomException
	{
		String query="insert into Student values(?) where studentId=?;";
		Connection connect;
		try
		{
			connect = Connectivity.CONNECT.getConnect();
			try(PreparedStatement preStatement=connect.prepareStatement(query))
			{
				preStatement.setString(1, value);
				preStatement.setString(2, condition);
				return preStatement.executeUpdate();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int deletePrepared(String condition)throws CustomException
	{
		String query="delete from Student where studentId=?;";
		//String tableName="Student";
		Connection connect;
		try
		{
			connect = Connectivity.CONNECT.getConnect();
			try(PreparedStatement preStatement=connect.prepareStatement(query))
			{
				preStatement.setString(1, condition);
				return preStatement.executeUpdate();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int updatePrepared(String value,int key)throws CustomException
	{
		String query="update Student set studentName=? where studentId=?;";
		//String tableName="Student";
		Connection connect;
		try
		{
			connect = Connectivity.CONNECT.getConnect();
			try(PreparedStatement preStatement=connect.prepareStatement(query))
			{
				preStatement.setString(1, value);
				preStatement.setInt(2, key);
				return preStatement.executeUpdate();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public String selectPrepared(String value,int key) throws CustomException
	{
		String query="select ? from Student where studentId=?;";
		Connection connect;
		try
		{
			connect = Connectivity.CONNECT.getConnect();
			try(PreparedStatement preStatement=connect.prepareStatement(query))
			{
				preStatement.setString(1,value);
				preStatement.setInt(2, key);
				try(ResultSet result=preStatement.executeQuery();)
				{
					if(result.next())
					{
						return result.getString(value);
					}
						return "EmptyString";
				}
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}

}
