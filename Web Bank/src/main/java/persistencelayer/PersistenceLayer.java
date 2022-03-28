package persistencelayer;

import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
import info.UserDetails;
import myException.CustomException;

public interface PersistenceLayer 
{
	public boolean create()throws CustomException;
	
	public CustomerInfo putCustomerDetails(CustomerInfo customer)throws CustomException	;
	public AccountInfo putAccountDetails(AccountInfo account)throws CustomException;
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException;
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException;
	
	public boolean setCustomerState(int customerId,boolean flag) throws CustomException;
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException;
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException;
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException;	
	
	public Map<Integer,CustomerInfo> readCustomerDetails()throws CustomException;
	public Map<Integer,Map<Integer,AccountInfo>> readAccountDetails()throws CustomException;
	
	//public Map<String,Integer> validatePassword(int userId,String password)throws CustomException;

	public UserDetails getUserDetails(int userId)throws CustomException;
	
	public int getAccountId();
	public int getCustomerId();

	public int getCustomerId(int accountId) throws CustomException;
	public void updateAccountDetails(int accountId, AccountInfo accountObj) throws CustomException;

	public void updateCustomerDetails(int customerId, CustomerInfo customerObj)throws CustomException;

	public void putUserDetails(UserDetails userObj)throws CustomException;
	
}