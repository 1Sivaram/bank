package connectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
import info.UserDetails;
import myException.CustomException;
import utility.MapUtility;

public class BankDataBase
{	
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
			statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			try(ResultSet result=statement.getGeneratedKeys();)
			{
				result.next();
				return result.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	public void updateRecord(String query) throws CustomException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		try(Statement statement=connection.createStatement();)
		{
			statement.executeUpdate(query);
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
		try(Statement statement = connection.createStatement();
				ResultSet result=statement.executeQuery(query);)
		{
			 CustomerInfo customerInfo=new CustomerInfo();
			 while(result.next())
			 {
				 customerInfo.setCustomerName(result.getString("customerName"));
				 customerInfo.setAddress(result.getString("Address"));
				 customerInfo.setMobile(result.getLong("Mobile"));
				 customerInfo.setCustomerId(result.getInt("customerId"));
				 customerInfo.setStatus(result.getBoolean("status"));
			 }
			 return customerInfo;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	public AccountInfo selectAccountRecord(String query)throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement();
				ResultSet result=statement.executeQuery(query);)
		{
			AccountInfo accountInfo=new AccountInfo();
			while(result.next())
			{
				accountInfo.setAccountId(result.getInt("accountId"));
				accountInfo.setCustomerId(result.getInt("customerId"));
				accountInfo.setBranchName(result.getString("branchName"));
				accountInfo.setBankBalance(result.getDouble("bankBalance"));
				accountInfo.setStatus(result.getBoolean("status"));
			 }
			 return accountInfo;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	public Map<Integer,CustomerInfo> readCustomer() throws CustomException
	{
		Map<Integer,CustomerInfo> customerData=new HashMap<>();
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement())
		{
			 String sql="select * from customerInfo;";
			try(ResultSet result=statement.executeQuery(sql);)
			{
				 while(result.next())
				 {
					 CustomerInfo customerInfo=new CustomerInfo();
					 customerInfo.setCustomerName(result.getString("customerName"));
					 customerInfo.setAddress(result.getString("Address"));
					 customerInfo.setMobile(result.getLong("Mobile"));
					 customerInfo.setCustomerId(result.getInt("customerId"));
					 customerInfo.setStatus(result.getBoolean("status"));
					 customerId=result.getInt("customerId");
					 utility.putCustomerDetails(customerData, customerInfo, customerId);
				 }
			}
			 return customerData;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> readAccount() throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		Map<Integer,Map<Integer,AccountInfo>> accountData=new  HashMap<>();
		try(Statement statement = connection.createStatement())
		{
			String sql="select * from accountInfo;";
			try(ResultSet result=statement.executeQuery(sql);)
			{
				while(result.next())
				{
					 AccountInfo accountInfo=new AccountInfo();
					 accountInfo.setCustomerId(result.getInt("customerId"));
					 accountInfo.setBranchName(result.getString("branchName"));
					 accountInfo.setBankBalance(result.getDouble("bankBalance"));
					 accountInfo.setStatus(result.getBoolean("status"));
					 accountInfo.setAccountId(result.getInt("accountId"));
					 accountId=result.getInt("accountId");
					 utility.putAccountDetails(accountData, accountInfo, accountId);
				 }
			}
			 return accountData;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	
	public UserDetails selectUserDetails(String query)throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement();
			ResultSet result=statement.executeQuery(query);)
		{
			UserDetails userInfo=new UserDetails();
			while(result.next())
			{
				 userInfo.setUserId(result.getInt(1));
				 userInfo.setPassword(result.getString(2));
				 userInfo.setRoleId(result.getInt(3));
				 userInfo.setCustomerId(result.getInt(4));
			 }
			 return userInfo;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	public int getAccountId()
	{
		return accountId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}

	public int getCustomerId(String query)throws CustomException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		try(Statement statement = connection.createStatement();
			ResultSet result=statement.executeQuery(query);)
		{
			result.next();
			//System.out.println(result.getInt(2));
			return result.getInt(2);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException("A problem occured on the Server. Please try again later.");
		}
	}
	
	
//	public Map<String, Integer> validatePassword(String query,String password) throws CustomException
//	{
//		Connection connection = Connectivity.CONNECT.getConnect();
//		try(Statement statement = connection.createStatement();
//				ResultSet result=statement.executeQuery(query);)
//		{
//			 Map <String, Integer> map=new HashMap<String, Integer>();
//			 while(result.next())
//			 {
//				 if(password.equals(result.getString(2)))
//				 {
//					 map.put("customerId",result.getInt(4));
//					 map.put("roleId",result.getInt(3));
//				 }
//			 }
//			 return map;
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			throw new CustomException(e);
//		}
//	}
	
//	public int getCustomerId()
//	{
//		return customerId;
//	}
//	
	
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