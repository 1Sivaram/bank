package logic;

import java.util.Map;
import connectivity.BankDataBase;
import info.AccountInfo;
import info.CustomerInfo;
import info.UserDetails;
import myException.CustomException;
import persistencelayer.PersistenceLayer;

public class DBLogic implements PersistenceLayer
{
	BankDataBase dataBase=new BankDataBase();
	
	public boolean create()throws CustomException
	{
		dataBase.createTable("create table if not exists customerInfo (customerId int not null auto_increment,customerName varchar(30),address varchar(100),mobile bigint,status boolean default true,primary key(customerId));"); 
		dataBase.createTable("create table if not exists accountInfo (accountId int not null auto_increment,customerId int not null,branchName varchar(30),bankBalance int,status boolean default true,primary key(accountId),foreign key (customerId) references customerInfo(customerId));");
		return true;
	}
	
	public CustomerInfo putCustomerDetails(CustomerInfo customer)throws CustomException
	{
		String customerName=customer.getCustomerName();
		String address=customer.getAddress();
		long mobile=customer.getMobile();
		int customerId=dataBase.insertRecord("insert into customerInfo(customerName,address,mobile) values('"+ customerName +"','"+ address +"',"+ mobile+");");
		customer.setCustomerId(customerId);
		return customer;
	}
	public AccountInfo putAccountDetails(AccountInfo account)throws CustomException
	{
		int customerId=account.getCustomerId();
		String branchName=account.getBranchName();
		double bankBalance=account.getBankBalance();
		int accountId=dataBase.insertRecord("insert into accountInfo(customerId,branchName,bankBalance) values("+ customerId +",'"+ branchName +"',"+ bankBalance +");");
		account.setAccountId(accountId);
		return account;
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		return dataBase.selectCustomerRecord("select * from customerInfo where customerId="+customerId+";");
	}
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		return dataBase.selectAccountRecord("select * from accountInfo where accountId="+ accountId +" and customerId="+ customerId +";");   
	}
	
	public boolean setCustomerState(int customerId,boolean flag) throws CustomException
	{
		dataBase.updateRecord("update customerInfo set status="+flag+" where customerId="+customerId+";");
		return true;
	}
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		dataBase.updateRecord("update accountInfo set status="+ flag +" where accountId="+ accountId +" and customerId="+ customerId +";");
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
//		AccountInfo accountObj=getAccountDetails(customerId,accountId);
//		double balance=accountObj.getBankBalance();
//		double number=balance+amount;
		dataBase.updateRecord("update accountInfo set bankBalance=bankBalance+"+amount+" where accountId="+ accountId +" and customerId="+ customerId +";");
		return true;
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
//		AccountInfo accountObj=getAccountDetails(customerId,accountId);
//		double balance=accountObj.getBankBalance();
//		double number=balance-amount;
		dataBase.updateRecord("update accountInfo set bankBalance=bankBalance-"+amount +" where accountId="+ accountId +" and customerId="+ customerId +";");
		return true;
	}
	
//	public Map<String,Integer> validatePassword(int userId,String password)throws CustomException
//	{
//		return dataBase.validatePassword("select * from  UserDetails where userId="+ userId +";",password);
//	}
	
	public Map<Integer,CustomerInfo> readCustomerDetails()throws CustomException
	{
		return dataBase.readCustomer();
	}
	public Map<Integer,Map<Integer,AccountInfo>> readAccountDetails()throws CustomException
	{
		return dataBase.readAccount();
	}
	
	public UserDetails getUserDetails(int userId)throws CustomException
	{
		String query="select * from  UserDetails where userId="+ userId +";";
		return dataBase.selectUserDetails(query);
	}
	
	public void updateAccountDetails(int accountId, AccountInfo accountObj) throws CustomException
	{
		String query="update accountInfo set customerId="+accountObj.getCustomerId()+", branchName='"+accountObj.getBranchName()+"', "
				+ "bankBalance="+accountObj.getBankBalance()+" where accountId="+accountId+";";
		dataBase.updateRecord(query);
	}
	
	public void updateCustomerDetails(int customerId, CustomerInfo customerObj) throws CustomException
	{
		String query="update customerInfo set customerName='"+customerObj.getCustomerName()+"', address='"+customerObj.getAddress()+"', "
				+ "mobile="+customerObj.getMobile()+" where customerId="+customerId+";";
		dataBase.updateRecord(query);
	}
	
	public int getCustomerId(int accountId)throws CustomException
	{
		String query="select * from accountInfo where accountId="+ accountId+";";
		return dataBase.getCustomerId(query);
	}
	
	public int getAccountId()
	{
		return dataBase.getAccountId();
	}
	
	public int getCustomerId()
	{
		return dataBase.getCustomerId();
	}
	
	public void putUserDetails(UserDetails userObj)throws CustomException
	{
		dataBase.insertRecord("insert into UserDetails(password,roleId,customerId) values('"+ userObj.getPassword() +"',"+userObj.getRoleId()+","+userObj.getCustomerId()+");");
	}
	
}