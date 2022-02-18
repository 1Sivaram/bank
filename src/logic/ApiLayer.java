package logic;

import java.util.List;
import java.util.Properties;
import info.AccountInfo;
import info.CustomerInfo;
import logic.cache.CacheLayer;
import myException.CustomException;
import persistencelayer.PersistenceLayer;

public class ApiLayer 
{
	Properties property=new Properties();
	CacheLayer cache=new CacheLayer();
	PersistenceLayer interfaceObj;
	
	public ApiLayer(boolean flag)
	{
		loadProperty();
		String path="";
		if(flag)
		{
			path=property.getProperty("DBPath");
		}
		else
		{
			path=property.getProperty("FilePath");
		}
		try 
		{
			Class<?> classObj=Class.forName(path);
			Object obj=classObj.getDeclaredConstructor().newInstance();
			interfaceObj=(PersistenceLayer)obj;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void loadProperty()
	{
		property.setProperty("FilePath", "myfile.BankFile");
		property.setProperty("DBPath", "logic.DBLogic");
	}
	
	public void fetchDetails()throws CustomException
	{
		System.out.println(interfaceObj.readCustomerDetails());
		cache.loadCustomerDetails(interfaceObj.readCustomerDetails());
		System.out.println(interfaceObj.readAccountDetails());
		cache.loadAccountDetails(interfaceObj.readAccountDetails());
	}
	
	public boolean createStorage()throws CustomException
	{
		return interfaceObj.create();
	}
	
	public boolean putCustomerDetails(CustomerInfo customer)throws CustomException
	{
		customer=interfaceObj.putCustomerDetails(customer);
		cache.putCustomerDetails(customer.getCustomerId(), customer);
		return true;
	}
	
	public boolean putAccountDetails(AccountInfo account)throws CustomException
	{
		account=interfaceObj.putAccountDetails(account);
		cache.putAccountDetails(account.getAccountId(), account);
		return true;
	}
	
	public boolean setCustomerState(int customerId,boolean flag) throws CustomException
	{
		if(interfaceObj.setCustomerState(customerId, flag))
		{
			cache.setCustomerState(customerId, flag);
		}
		return true;
	}
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		if(interfaceObj.setAccountState(customerId,accountId,flag))
		{
			cache.setAccountState(customerId,accountId,flag);
		}
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
		if(interfaceObj.deposit(customerId,accountId,amount))
		{
			cache.deposit(customerId,accountId,amount);
		}
		return true;
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		if(interfaceObj.withdraw(customerId,accountId,amount))
		{
			cache.withdraw(customerId,accountId,amount);
		}
		return true;
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		return cache.getCustomerDetails(customerId);
	}
	
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		return cache.getAccountDetails(customerId, accountId);
	}
	
	public List<AccountInfo> getActiveAccounts(int customerId) throws CustomException
	{
		return cache.getActiveAccounts(customerId);
	}
	
	public double getBalance(int customerId, int accountId)throws CustomException
	{
		AccountInfo account=getAccountDetails(customerId,accountId);
		return account.getBankBalance();
	}
	
}
