package logic.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
import myException.CustomException;
import utility.MapUtility;

public class CacheLayer
{
	Map<Integer,CustomerInfo> customerData=new HashMap<>();
	Map<Integer,Map<Integer,AccountInfo>> accountData=new HashMap<>();
	
	MapUtility util=new MapUtility();
	
	public void loadAccountDetails(Map<Integer,Map<Integer,AccountInfo>> accountDetails)
	{
		accountData.putAll(accountDetails);
	}
	
	public void loadCustomerDetails(Map<Integer,CustomerInfo> customerDetails)
	{
		customerData.putAll(customerDetails);
	}
	
	public boolean putCustomerDetails(int customerId,CustomerInfo customer)throws CustomException
	{
		util.putCustomerDetails(customerData,customer,customerId);
		return true;
	}
	
	public boolean putAccountDetails(int accountId,AccountInfo account)throws CustomException
	{
		util.putAccountDetails(accountData,account,accountId);
		return true;
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		return util.getCustomerDetails(customerData,customerId);
	}
	
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		return util.getAccountDetails(accountData,customerId, accountId);
	}

	public boolean setCustomerState(int customerId,boolean flag) throws CustomException
	{
		util.setCustomerState(customerData,customerId, flag);
		return true;
	}
	
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		util.setAccountState(accountData,customerId, accountId, flag);
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
		return util.deposit(accountData, customerId, accountId, amount);
	}
	
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		return util.withdraw(accountData, customerId, accountId, amount);
	}
	
	public List<AccountInfo> getActiveAccounts(int customerId) throws CustomException
	{
		return util.getActiveAccounts(accountData, customerId);
	}
}
