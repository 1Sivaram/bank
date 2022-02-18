package connectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
import myException.CustomException;
import utility.MapUtility;

public class BankDataBase
{	
	Map<Integer,CustomerInfo> customerData=new HashMap<>();
	Map<Integer,Map<Integer,AccountInfo>> accountData=new  HashMap<>();
	MapUtility utility=new MapUtility();
	
	private int customerId;
	private int accountId;
	
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

	public CustomerInfo selectCustomerRecord(String query)throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement())
		{
			 ResultSet result=statement.executeQuery(query);
			 while(result.next())
			 {
				 CustomerInfo customerInfo=new CustomerInfo();
				 customerInfo.setCustomerName(result.getString("customerName"));
				 customerInfo.setAddress(result.getString("Address"));
				 customerInfo.setMobile(result.getLong("Mobile"));
				 customerInfo.setCustomerId(result.getInt("customerId"));
				 customerInfo.setStatus(result.getBoolean("status"));
				 return customerInfo;
			 }
			 return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public AccountInfo selectAccountRecord(String query)throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement())
		{
			 ResultSet result=statement.executeQuery(query);
			 while(result.next())
			 {
				 AccountInfo accountInfo=new AccountInfo();
				 accountInfo.setCustomerId(result.getInt("customerId"));
				 accountInfo.setBrachName(result.getString("branchName"));
				 accountInfo.setBankBalance(result.getDouble("bankBalance"));
				 accountInfo.setAccountId(result.getInt("accountId"));
				 accountInfo.setStatus(result.getBoolean("status"));
				 return accountInfo;
			 }
			 return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,CustomerInfo> readCustomer() throws CustomException
	{
		
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement())
		{
			 String sql="select * from CustomerInfo;";
			 ResultSet result=statement.executeQuery(sql);
			
			 while(result.next())
			 {
				 CustomerInfo customerInfo=new CustomerInfo();
				 customerInfo.setCustomerName(result.getString("customerName"));
				 customerInfo.setAddress(result.getString("Address"));
				 customerInfo.setMobile(result.getLong("Mobile"));
				 customerId=result.getInt("customerId");
				 utility.putCustomerDetails(customerData, customerInfo, customerId);
			 }
			 return customerData;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> readAccount() throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			String sql="select * from AccountInfo;";
			ResultSet result=statement.executeQuery(sql);
			 
			while(result.next())
			{
				 AccountInfo accountInfo=new AccountInfo();
				 accountInfo.setCustomerId(result.getInt("customerId"));
				 accountInfo.setBrachName("branchName");
				 accountInfo.setBankBalance(result.getDouble("balance"));
				 accountInfo.setStatus(result.getBoolean("status"));
				 accountId=result.getInt("accountId");
				 utility.putAccountDetails(accountData, accountInfo, accountId);
			 }
			
			 return accountData;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public int getAccountId()
	{
		return accountId;
	}
	
}

//public int insertPrepared(String value,String condition)throws CustomException
//{
//	String query="insert into Student values(?) where studentId=?;";
//	Connection connect;
//	try
//	{
//		connect = Connectivity.CONNECT.getConnect();
//		try(PreparedStatement preStatement=connect.prepareStatement(query))
//		{
//			preStatement.setString(1, value);
//			preStatement.setString(2, condition);
//			return preStatement.executeUpdate();
//		}
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}

//public int deletePrepared(String condition)throws CustomException
//{
//	String query="delete from Student where studentId=?;";
//	//String tableName="Student";
//	Connection connect;
//	try
//	{
//		connect = Connectivity.CONNECT.getConnect();
//		try(PreparedStatement preStatement=connect.prepareStatement(query))
//		{
//			preStatement.setString(1, condition);
//			return preStatement.executeUpdate();
//		}
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}

//public int updatePrepared(String value,int key)throws CustomException
//{
//	String query="update Student set studentName=? where studentId=?;";
//	//String tableName="Student";
//	Connection connect;
//	try
//	{
//		connect = Connectivity.CONNECT.getConnect();
//		try(PreparedStatement preStatement=connect.prepareStatement(query))
//		{
//			preStatement.setString(1, value);
//			preStatement.setInt(2, key);
//			return preStatement.executeUpdate();
//		}
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}

//public String selectPrepared(String value,int key) throws CustomException
//{
//	String query="select ? from Student where studentId=?;";
//	Connection connect;
//	try
//	{
//		connect = Connectivity.CONNECT.getConnect();
//		try(PreparedStatement preStatement=connect.prepareStatement(query))
//		{
//			preStatement.setString(1,value);
//			preStatement.setInt(2, key);
//			try(ResultSet result=preStatement.executeQuery();)
//			{
//				if(result.next())
//				{
//					return result.getString(value);
//				}
//					return "EmptyString";
//			}
//		}
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}

//public int deleteRecord(String query) throws CustomException
//{
//	Connection connection=Connectivity.CONNECT.getConnect();
//	try(Statement statement=connection.createStatement();)
//	{
//		int number=statement.executeUpdate(query);
//		return number;
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}

//public Map<Integer,TableInfo> selectRecord(String query) throws CustomException
//{
//	Map<Integer,TableInfo> map=new HashMap<>();
//	
//	Connection connection=Connectivity.CONNECT.getConnect();
//	try(Statement statement=connection.createStatement();
//		ResultSet result=statement.executeQuery(query))
//	{
//		while (result.next())
//		{
//			TableInfo info=new TableInfo();
//			info.setStudentId(result.getInt("studentId")); 
//			info.setStudentName(result.getString("studentName"));
//			info.setAge(result.getInt("age"));
//			info.setAddress(result.getString("address"));
//			map.put(info.getStudentId(), info);
//		}
//		return map;
//	}
//	catch (SQLException e) 
//	{
//		e.printStackTrace();
//		throw new CustomException(e);
//	}
//}
