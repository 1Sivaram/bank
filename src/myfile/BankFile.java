package myfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import info.AccountInfo;
import info.CustomerInfo;
import myException.CustomException;
import persistencelayer.PersistenceLayer;
import utility.MapUtility;
import validateclass.Checker;

public class BankFile implements PersistenceLayer
{
	//Map<Integer,CustomerInfo> customerData=new HashMap<>();
	//Map<Integer,Map<Integer,AccountInfo>> accountData=new HashMap<>();
	
	private int customerId=0;
	private int accountId=100;
	
	MapUtility util=new MapUtility();
	
	private int generateAccountId()
	{
		return accountId++;
	}
	
	private int generateCustomerId()
	{
		return customerId++;
	}
	
	public boolean create()throws CustomException
	{
		try 
		{
		File customerFile=new File("CustomerDetails.txt");
		File accountFile=new File("AccountDetails.txt");
		if(customerFile.createNewFile()&&accountFile.createNewFile())
		{
			return true;
		}
			throw new CustomException("File already Exists");
		}
		catch(IOException ioe)
		{
			throw new CustomException(ioe);	
		}
	}
	
	public CustomerInfo putCustomerDetails(CustomerInfo customer)throws CustomException
	{
		Map<Integer,CustomerInfo> customerData=readCustomerDetails();
		int customerId=generateCustomerId();
		util.putCustomerDetails(customerData,customer,customerId);
		writeCustomerDetails(customerData);
		customer.setCustomerId(customerId);
		return customer;
	}
	public AccountInfo putAccountDetails(AccountInfo account)throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountData=readAccountDetails();
		int accountId=generateAccountId();
		util.putAccountDetails(accountData,account,accountId);
		writeAccountDetails(accountData);
		account.setAccountId(accountId);
		return account;
	}
	
	public CustomerInfo getCustomerDetails(int customerId)throws CustomException
	{
		Map<Integer,CustomerInfo> customerData=readCustomerDetails();
		return util.getCustomerDetails(customerData,customerId);
	}
	public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountData=readAccountDetails();
		return util.getAccountDetails(accountData,customerId, accountId);
	}

	
	public boolean setCustomerState(int customerId,boolean flag) throws CustomException
	{
		Map<Integer,CustomerInfo> customerData=readCustomerDetails();
		util.setCustomerState(customerData,customerId, flag);
		return true;
	}
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountData=readAccountDetails();
		util.setAccountState(accountData,customerId, accountId, flag);
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountData=readAccountDetails();
		return util.deposit(accountData, customerId, accountId, amount);
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountData=readAccountDetails();
		return util.withdraw(accountData, customerId, accountId, amount);
	}
	
	private void writeCustomerDetails(Map<Integer,CustomerInfo> customerData)throws CustomException
	{
		try(FileOutputStream streamOut=new FileOutputStream("CustomerDetails.txt");
			ObjectOutputStream objStream=new ObjectOutputStream(streamOut);)
		{
			objStream.writeObject(customerData);
			objStream.writeInt(customerId);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	private void writeAccountDetails(Map<Integer,Map<Integer,AccountInfo>> accountData)throws CustomException
	{
		try(FileOutputStream streamOut=new FileOutputStream("AccountDetails.txt");
			ObjectOutputStream objStream=new ObjectOutputStream(streamOut);)
		{
			objStream.writeObject(accountData);
			objStream.writeInt(accountId);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,CustomerInfo> readCustomerDetails()throws CustomException
	{
		try(FileInputStream streamIn=new FileInputStream("CustomerDetails.txt");
				ObjectInputStream objStream=new ObjectInputStream(streamIn);)
			{
				Map<Integer, CustomerInfo> customerMap=(Map<Integer, CustomerInfo>) objStream.readObject();
				customerId=objStream.readInt();
				if(customerMap==null)
				{
					customerMap=new HashMap<>();
				}
				return customerMap;
			} 
			catch (Exception e) 
			{
				return new HashMap<Integer,CustomerInfo>();
			}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> readAccountDetails()throws CustomException
	{
		try(FileInputStream streamIn=new FileInputStream("AccountDetails.txt");
				ObjectInputStream objStream=new ObjectInputStream(streamIn);)
			{
				Map<Integer, Map<Integer, AccountInfo>> accountMap=(Map<Integer, Map<Integer, AccountInfo>>) objStream.readObject();
				accountId=(int) objStream.readInt();
				if(accountMap==null)
				{
					accountMap=new HashMap<>();
				}
				return accountMap;
			} 
			catch (Exception e) 
			{
				return new HashMap<Integer,Map<Integer,AccountInfo>>();
			}
	}
	
//	public int getCustomerId()
//	{
//		return customerId;
//	}
//	
//	public int getAccountId()
//	{
//		return accountId;
//	}

}
