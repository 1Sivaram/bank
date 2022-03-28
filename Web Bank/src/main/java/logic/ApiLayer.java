package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import info.AccountInfo;
import info.CustomerInfo;
import info.UserDetails;
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
		try 
		{
			//System.out.println("hi");
			fetchDetails();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
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
		//System.out.println(interfaceObj.readCustomerDetails());
		cache.loadCustomerDetails(interfaceObj.readCustomerDetails());
		//System.out.println(interfaceObj.readAccountDetails());
		cache.loadAccountDetails(interfaceObj.readAccountDetails());
		
		cache.setId(interfaceObj.getCustomerId(), interfaceObj.getAccountId());
	}
	
	public boolean createStorage()throws CustomException
	{
		return interfaceObj.create();
	}
	
	public boolean putCustomerDetails(CustomerInfo customer)throws CustomException
	{
		customer=interfaceObj.putCustomerDetails(customer);
		createUserId(customer);
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
		//AccountInfo account=cache.getAccountDetails(customerId, accountId);
		if(100000>amount)
		{
			interfaceObj.deposit(customerId,accountId,amount);
			cache.deposit(customerId,accountId,amount);
			return true;
		}
		throw new CustomException("Deposit amount must be less than 100000(one lakh)");
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		AccountInfo account=cache.getAccountDetails(customerId, accountId);
		if(account.getBankBalance()>amount)
		{
			interfaceObj.withdraw(customerId,accountId,amount);
			cache.withdraw(customerId,accountId,amount);
			return true;
		}
		throw new CustomException("You don't have sufficient money to make a transaction");
		
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
	
	public Map<Integer,AccountInfo> getCustomerAccounts(int customerId)throws CustomException
	{
		return cache.getCustomerAccounts(customerId);
	}
	
	public double getBalance(int customerId, int accountId)throws CustomException
	{
		AccountInfo account=getAccountDetails(customerId,accountId);
		return account.getBankBalance();
	}
	
	public UserDetails getUserDetails(int userId)throws CustomException
	{
		
		return interfaceObj.getUserDetails(userId);
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> readAccountDetails()throws CustomException
	{
		return interfaceObj.readAccountDetails();
	}
	
	public int getAccountId()
	{
		return cache.getAccountId();
	}
	
	public int getCustomerId()
	{
		return cache.getCustomerId();
	}
	
	public int getCustomerId(int accountId)throws CustomException
	{
		return interfaceObj.getCustomerId(accountId);
	}
	
	public List<AccountInfo> getAccountList(boolean flag)throws CustomException
	{
		List<AccountInfo> list=new ArrayList<>();
		Map<Integer,Map<Integer,AccountInfo>> mapObj=cache.readAccountDetails();
		
		for(Integer customerId:mapObj.keySet())
		{
			Map<Integer,AccountInfo> accountMap=mapObj.get(customerId);
			for(Integer accountId:accountMap.keySet())
			{
				AccountInfo accountObj=accountMap.get(accountId);
				if(accountObj.getStatus()==flag)
				{
					list.add(accountObj);
				}
			}
		}
		return list;
	}
	
	public List<CustomerInfo> getCustomerList(boolean flag)throws CustomException
	{
		Map<Integer,CustomerInfo> customerMap=cache.readCustomerDetails();
		List<CustomerInfo> customerList=new ArrayList<>();
		for(Integer key:customerMap.keySet())
		{
			CustomerInfo customerObj=customerMap.get(key); 
			if(customerObj.getStatus()==flag)
			{
				customerList.add(customerObj);
			}
		}
		return customerList;
	}

	public void updateAccountDetails(int accountId, AccountInfo accountObj) throws CustomException
	{
		interfaceObj.updateAccountDetails(accountId, accountObj);
		cache.putAccountDetails(accountId,accountObj);
	}

	public void updateCustomerDetails(int customerId, CustomerInfo customerObj) throws CustomException
	{
		interfaceObj.updateCustomerDetails(customerId, customerObj);
		cache.putCustomerDetails(customerId,customerObj);
	}
	
	public List<String> getBranchArray()
	{
		List<String> branch=new ArrayList<>();
		branch.add("Koyampuththoor");
		branch.add("Chennai");
		branch.add("Madurai");
		branch.add("Trichy");
		branch.add("Salem");
		return branch;
	}
	
	public void createUserId(CustomerInfo customerObj)throws CustomException
	{
		String temp=customerObj.getCustomerName();
		String mob=String.valueOf(customerObj.getMobile());
		String pas=temp.substring(0,3)+mob.substring(0,3);
		
		UserDetails user=new UserDetails();
		user.setPassword(pas);
		user.setRoleId(1);
		user.setCustomerId(customerObj.getCustomerId());
		interfaceObj.putUserDetails(user);
	}
	
}