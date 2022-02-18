package logic;

import java.util.Map;
import connectivity.BankDataBase;
import info.AccountInfo;
import info.CustomerInfo;
import myException.CustomException;
import persistencelayer.PersistenceLayer;

public class DBLogic implements PersistenceLayer
{
	BankDataBase dataBase=new BankDataBase();
	
	public boolean create()throws CustomException
	{
		dataBase.createTable("create table customerInfo (customerId int not null auto_increment,customerName varchar(30),address varchar(100),mobile int,status tinyint,primary key(customerId));"); 
		dataBase.createTable("create table accountInfo (accountId int not null auto_increment,customerId int not null,brachName varchar(30),bankBalance int,status tinyint,primary key(accountId),references customerInfo(customerId));");
		return true;
	}
	
	public CustomerInfo putCustomerDetails(CustomerInfo customer)throws CustomException
	{
		String customerName=customer.getCustomerName();
		String address=customer.getAddress();
		long mobile=customer.getMobile();
		boolean status=customer.getStatus();
		dataBase.insertRecord("insert into customerInfo values("+ customerName +","+ address +","+ mobile +","+ status +");");
		return customer;
	}
	public AccountInfo putAccountDetails(AccountInfo account)throws CustomException
	{
		int customerId=account.getCustomerId();
		String brachName=account.getBrachName();
		double bankBalance=account.getBankBalance();
		boolean status=account.getStatus();
		dataBase.insertRecord("insert into accountInfo values("+ customerId +","+ brachName +","+ bankBalance +","+ status +");");
		return account;
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		return dataBase.selectCustomerRecord("select * from customerInfo where customerId="+customerId+";");
	}
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		return dataBase.selectAccountRecord("select * from  accountInfo where accountId="+ accountId +"and customerId="+ customerId +";");
	}

	
	public boolean setCustomerState(int customerId,boolean flag) throws CustomException
	{
		dataBase.updateRecord("update customerInfo set status="+flag+"where customerId="+customerId+";");
		return true;
	}
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		dataBase.updateRecord("update accountInfo set status="+ flag +"where accountId="+ accountId +"customerId="+ customerId +";");
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo accountObj=getAccountDetails(customerId,accountId);
		amount=accountObj.getBankBalance()+amount;
		dataBase.updateRecord("update accountInfo set bankBalance=bankBalance +"+amount+"where accountId="+ accountId +"customerId="+ customerId +";");
		return true;
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo accountObj=getAccountDetails(customerId,accountId);
		amount=accountObj.getBankBalance()-amount;
		dataBase.updateRecord("update accountInfo set bankBalance=bankBalance +"+amount +"where accountId="+ accountId +"customerId="+ customerId +";");
		return true;
	}
	
	public Map<Integer,CustomerInfo> readCustomerDetails()throws CustomException
	{
		return dataBase.readCustomer();
	}
	public Map<Integer,Map<Integer,AccountInfo>> readAccountDetails()throws CustomException
	{
		return dataBase.readAccount();
	}
	
	public int getCustomerId()
	{
		return dataBase.getCustomerId();
	}
	public int getAccountId()
	{
		return dataBase.getAccountId();
	}
	
}
