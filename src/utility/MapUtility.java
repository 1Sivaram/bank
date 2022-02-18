package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import info.AccountInfo;
import info.CustomerInfo;
import myException.CustomException;
import validateclass.Checker;

public class MapUtility 
{

	public void putCustomerDetails(Map<Integer,CustomerInfo> customerData,CustomerInfo customerObj,int customerId) throws CustomException
	{
		Checker.nullCheck(customerObj);
		customerData.put(customerId,customerObj);
	}
	
	public CustomerInfo getCustomerDetails(Map<Integer,CustomerInfo> customerData,int customerId)throws CustomException
	{
		CustomerInfo customerObj = customerData.get(customerId);
		if(customerObj!=null && customerObj.getStatus())
		{
			return customerObj;
		}
		throw new CustomException("Your account is De-Activated or No data Found");
		
	}
	
	public void putAccountDetails(Map<Integer,Map<Integer,AccountInfo>> accountData,AccountInfo accountObj,int accountId) throws CustomException
	{
		Checker.nullCheck(accountObj);
		int customerId=accountObj.getCustomerId();
		Map<Integer,AccountInfo> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			mapObj=new HashMap<>();
			accountData.put(customerId, mapObj);
		}
		mapObj.put(accountId,accountObj);
	}
	
	public Map<Integer,AccountInfo> getAllCustomerAccounts(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId)
	{
		return accountData.get(customerId);
	}
	
	public AccountInfo getAccountDetails(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId,int accountId)throws CustomException
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

	public void setAccountState(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId,int accountId,boolean flag) throws CustomException
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
	
	public List<AccountInfo> getActiveAccounts(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId) throws CustomException
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
	
	public void setCustomerState(Map<Integer,CustomerInfo> customerData,int customerId,boolean flag) throws CustomException
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
	
	public boolean deposit(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo account=getAccountDetails(accountData,customerId,accountId);
		account.setBankBalance(account.getBankBalance()+amount);
		return true;
	}
	
	public boolean withdraw(Map<Integer,Map<Integer,AccountInfo>> accountData,int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo account=getAccountDetails(accountData,customerId,accountId);
		double balance=account.getBankBalance();
		if(balance>amount)
		{
			account.setBankBalance(balance-amount);
			return true;
		}
		throw new CustomException("Insufficient Balance");
	}
}
