package logic;
import info.*;
import myException.CustomException;
import validateclass.Checker;
import java.util.*;
import java.util.Map.Entry;

public class BankLogic 
{
	private int customerId=0;
	private int accountId=100;
	Map<Integer,CustomerInfo> customerData=new HashMap<>();
	Map<Integer,Map<Integer,AccountInfo>> accountData=new HashMap<>();
	
	
	private int generateAccountId()
	{
		return accountId++;
	}
	
	private int generateCustomerId()
	{
		return customerId++;
	}
	
	public void putCustomerDetails(CustomerInfo customerObj) throws CustomException
	{
		Checker.nullCheck(customerObj);
		int customerId=generateCustomerId();
		customerData.put(customerId,customerObj);
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		CustomerInfo customerObj = customerData.get(customerId);
		if(customerObj!=null && customerObj.getStatus())
		{
			return customerObj;
		}
		throw new CustomException("Your account is De-Activated or No data Found");
		
	}
	
	public void putAccountDetails(AccountInfo accountObj) throws CustomException
	{
		Checker.nullCheck(accountObj);
		int customerId=accountObj.getCustomerId();
		int accountId=generateAccountId();
		Map<Integer,AccountInfo> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			mapObj=new HashMap<>();
			accountData.put(customerId, mapObj);
		}
		mapObj.put(accountId,accountObj);
	}
	
	public Map<Integer,AccountInfo> getAllCustomerAccounts(int customerId)
	{
		return accountData.get(customerId);
	}
	
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		Map<Integer,AccountInfo> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			throw new CustomException("No data found for the given Customer-Id");
		}
		AccountInfo accountObj=mapObj.get(accountId);
		if(accountObj!=null && accountObj.getStatus())
		{
			return accountObj;
		}
		throw new CustomException("Your account is De-Activated or No data Found");
		
	}

	public void setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		Map<Integer,AccountInfo> mapObj=accountData.get(customerId);
		if(mapObj!=null)
		{
			AccountInfo accountObj=mapObj.get(accountId);
			if(accountObj!=null)
			{
				accountObj.setStatus(flag);
			}
			else
			{
				throw new CustomException("No data found for the given Account-Id");
			}
		}
		else
		{
			throw new CustomException("No data found for the given Customer-Id");
		}
	}
	
	public List<AccountInfo> getActiveAccounts(int customerId) throws CustomException
	{
		List<AccountInfo> listObj=new ArrayList<>();
		Map<Integer,AccountInfo> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			throw new CustomException("No data found for the given Customer-Id");
		}
		for(Entry <Integer,AccountInfo> entry:mapObj.entrySet())
		{
			AccountInfo accountObj=entry.getValue();
			if(accountObj.getStatus())
			{
				listObj.add(accountObj);
			}
		}
		return listObj;
	}
	
	public void setCustomerState(int customerId,boolean flag) throws CustomException
	{
		CustomerInfo customerObj=customerData.get(customerId);
		if(customerObj!=null)
		{
			customerObj.setStatus(flag);
		}
		else
		{
			throw new CustomException("No data found for the given Customer-Id");
		}
		
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo account=getAccountDetails(customerId,accountId);
		account.setBankBalance(account.getBankBalance()+amount);
		return true;
	}
	
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo account=getAccountDetails(customerId,accountId);
		double balance=account.getBankBalance();
		if(balance>amount)
		{
			account.setBankBalance(balance-amount);
			return true;
		}
		throw new CustomException("Insufficient Balance");
	}
	
	public double getBalance(int customerId,int accountId)throws CustomException
	{
		AccountInfo account=getAccountDetails(customerId,accountId);
		return account.getBankBalance();
	}
	
	
	
	
}
