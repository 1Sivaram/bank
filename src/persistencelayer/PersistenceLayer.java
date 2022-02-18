package persistencelayer;

import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
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
	
//	public int getCustomerId();
//	public int getAccountId();
}
