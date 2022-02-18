package logic;
import info.*;
import myException.CustomException;
import validateclass.Checker;
import java.util.*;
import org.json.simple.*;
import myfile.FileCreationClass;
import com.google.gson.*;

public class JSon 
{
	
		FileCreationClass file=new FileCreationClass();
		JSONObject customerData=new JSONObject();
		JSONObject accountData=new JSONObject();
		JSONObject	keyValues=new JSONObject();
		Gson json=new Gson();

		private int customerId=0;
		private int accountId=0;
		
		
		public void fetchDetails() throws CustomException
		{
			keyValues=readKey();
			if(keyValues!=null)
			{
				customerData=readCustomer();
				if(customerData!=null)
				{
					String keyString=(String) keyValues.get("customerId");
					customerId=Integer.parseInt(keyString);
				}
				accountData=readAccount();
				if(accountData!=null)
				{
					String keyString=(String) keyValues.get("accountId");
					accountId=Integer.parseInt(keyString);
				}
			}
		}
		
		private int generateAccountId()
		{
			String data=Integer.toString(accountId+1);
			keyValues.put("accountId",data);
			return accountId++;
		}
		
		
		private int generateCustomerId()
		{
			String data=Integer.toString(customerId+1);
			keyValues.put("customerId", data);
			return customerId++;
		}
		
		public void putCustomerDetails(CustomerInfo customerObj) throws CustomException
		{
			Checker.nullCheck(customerObj);
			int customerId=generateCustomerId();
			String data=json.toJson(customerObj);
			customerData.put(String.valueOf(customerId),data);
		}
		
		private void putCustomerDetails(int customerId,CustomerInfo customerObj) throws CustomException
		{
			Checker.nullCheck(customerObj);
			String data=json.toJson(customerObj);
			customerData.put(String.valueOf(customerId),data);
		}
		
		public CustomerInfo getCustomerDetails(int customerId)throws CustomException
		{
			String data = (String) customerData.get(String.valueOf(customerId));
			CustomerInfo customerObj=json.fromJson(data, CustomerInfo.class);
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
			JSONObject jsonObj=(JSONObject) accountData.get(String.valueOf(customerId));
			if(jsonObj==null)
			{
				jsonObj=new JSONObject();
				accountData.put(String.valueOf(customerId), jsonObj);
			}
			String data=json.toJson(accountObj);
			jsonObj.put(String.valueOf(accountId),data);
		}
		
		private void putAccountDetails(int customerId,int accountId,AccountInfo accountObj) throws CustomException
		{
			JSONObject jsonObj=(JSONObject) accountData.get(String.valueOf(customerId));
			String data=json.toJson(accountObj);
			jsonObj.put(String.valueOf(accountId),data);
		}
		
		public JSONObject getAllCustomerAccounts(int customerId)
		{
			return (JSONObject) accountData.get(String.valueOf(customerId));
		}
		
		public AccountInfo getAccountDetails(int customerId,int accountId)throws CustomException
		{
			JSONObject jsonObj=(JSONObject) accountData.get(String.valueOf(customerId));
			if(jsonObj==null)
			{
				throw new CustomException("No data found for the given Customer-Id");
			}
			String data=(String)jsonObj.get(String.valueOf(accountId));
			AccountInfo accountObj=(AccountInfo) json.fromJson(data, AccountInfo.class);
			if(accountObj!=null && accountObj.getStatus())
			{
				return accountObj;
			}
			throw new CustomException("Your account is De-Activated or No data Found");
			
		}

		public void setAccountState(int customerId,int accountId,boolean flag) throws CustomException
		{
			JSONObject jsonObj=(JSONObject) accountData.get(String.valueOf(customerId));
			if(jsonObj!=null)
			{
				String data=(String)jsonObj.get(String.valueOf(accountId));
				AccountInfo accountObj=(AccountInfo) json.fromJson(data, AccountInfo.class);
				if(accountObj!=null)
				{
					accountObj.setStatus(flag);
					putAccountDetails(customerId,accountId,accountObj);
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
			JSONObject jsonObj=(JSONObject) accountData.get(String.valueOf(customerId));
			if(jsonObj==null)
			{
				throw new CustomException("No data found for the given Customer-Id");
			}

			for(Object key:jsonObj.keySet())
			{
				//System.out.println("Hello null");
				String data=(String)jsonObj.get(key);
				AccountInfo accountObj=(AccountInfo) json.fromJson(data, AccountInfo.class);
				if(accountObj.getStatus())
				{
					//System.out.println("Hello not null");
					listObj.add(accountObj);
				}
			}
			return listObj;
		}
		
		public void setCustomerState(int customerId,boolean flag) throws CustomException
		{
			String data=(String)customerData.get(String.valueOf(customerId));
			CustomerInfo customerObj=(CustomerInfo) json.fromJson(data, CustomerInfo.class);
			if(customerObj!=null)
			{
				customerObj.setStatus(flag);
				putCustomerDetails(customerId,customerObj);
			}
			else
			{
				throw new CustomException("No data found for the given Customer-Id");
			}
			
		}
		
		public boolean deposit(int customerId,int accountId,double amount)throws CustomException
		{
			AccountInfo accountObj=getAccountDetails(customerId,accountId);
			accountObj.setBankBalance(accountObj.getBankBalance()+amount);
			putAccountDetails(customerId,accountId,accountObj);
			return true;
		}
		
		public boolean withdraw(int customerId,int accountId,double amount)throws CustomException
		{
			AccountInfo accountObj=getAccountDetails(customerId,accountId);
			double balance=accountObj.getBankBalance();
			if(balance>amount)
			{
				accountObj.setBankBalance(balance-amount);
				putAccountDetails(customerId,accountId,accountObj);
				return true;
			}
			throw new CustomException("Your balance is lower than the amount you want to withdraw");
		}
		
		public double getBalance(int customerId,int accountId)throws CustomException
		{
			AccountInfo accountObj=getAccountDetails(customerId,accountId);
			return accountObj.getBankBalance();
		}
	
		public void storeCustomer()throws CustomException
		{
			file.createJSONFile("CustomerDetails.json", customerData);
		}
		
		public JSONObject readCustomer()throws CustomException
		{
			return file.readJSONFile("CustomerDetails.json");
		}
		
		public void storeAccount()throws CustomException
		{
			file.createJSONFile("AccountDetails.json", accountData);
		}
		
		public JSONObject readAccount()throws CustomException
		{
			return file.readJSONFile("AccountDetails.json");
		}
		
		public void storeKey()throws CustomException
		{
			file.createJSONFile("KeyDetails.json", keyValues);
		}
		
		public JSONObject readKey()throws CustomException
		{
			return file.readJSONFile("KeyDetails.json");
		}
		
}