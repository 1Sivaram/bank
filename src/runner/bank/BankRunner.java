package runner.bank;

import info.*;
import task3.Input;
import logic.ApiLayer;
import myException.CustomException;

public class BankRunner 
{
	ApiLayer logic=new ApiLayer(false);
	Input input=new Input();
	
	private void details()
	{
		
		 CustomerInfo customerObj0= new CustomerInfo();
		 customerObj0.setCustomerName("A");
		 customerObj0.setAddress("1/2-abc");
		 customerObj0.setMobile(123456789);
		 
		 CustomerInfo customerObj1 = new CustomerInfo();
		 customerObj1.setCustomerName("B");
		 customerObj1.setAddress("1/2-def");
		 customerObj1.setMobile(123654987);
		 
		 CustomerInfo customerObj2 = new CustomerInfo();
		 customerObj2.setCustomerName("C");
		 customerObj2.setAddress("1/2-ghi");
		 customerObj2.setMobile(789654123);
		 
		 CustomerInfo customerObj3 = new CustomerInfo();
		 customerObj3.setCustomerName("D");
		 customerObj3.setAddress("1/2-jkl");
		 customerObj3.setMobile(456789123);
		
		 try
		 {
			 logic.putCustomerDetails(customerObj0);
			 logic.putCustomerDetails(customerObj1);
			 logic.putCustomerDetails(customerObj2);
			 logic.putCustomerDetails(customerObj3);
		 }
		 catch(CustomException e)
		 {
			 e.getMessage();
			 e.printStackTrace();
		 }
	}
	
	private void putAccountDetails()
	{
		AccountInfo accountObj0= new AccountInfo();
		accountObj0.setCustomerId(0);
		accountObj0.setBrachName("Karaikudi");
		accountObj0.setBankBalance(123654);
		//logic.putAccountValues(accountObj0);
		
		
		AccountInfo accountObj1= new AccountInfo();
		accountObj1.setCustomerId(1);
		accountObj1.setBrachName("Kovai");
		accountObj1.setBankBalance(456789);
		//logic.putAccountValues(accountObj1);
		
		
		AccountInfo accountObj2= new AccountInfo();
		accountObj2.setCustomerId(2);
		accountObj2.setBrachName("Madurai");
		accountObj2.setBankBalance(102030);
		//logic.putAccountValues(accountObj2);
		
		
		AccountInfo accountObj3= new AccountInfo();
		accountObj3.setCustomerId(3);
		accountObj3.setBrachName("PMK");
		accountObj3.setBankBalance(100030);
		//logic.putAccountValues(accountObj3);
		
		
		AccountInfo accountObj4= new AccountInfo();
		accountObj4.setCustomerId(2);
		accountObj4.setBrachName("Madurai");
		accountObj4.setBankBalance(10230);
		//logic.putAccountValues(accountObj4);
		
		
		AccountInfo accountObj5= new AccountInfo();
		accountObj5.setCustomerId(3);
		accountObj5.setBrachName("Kovai");
		accountObj5.setBankBalance(302060);
		//logic.putAccountValues(accountObj5);
		
		
		AccountInfo accountObj6= new AccountInfo();
		accountObj6.setCustomerId(1);
		accountObj6.setBrachName("PMK");
		accountObj6.setBankBalance(159753);
		//logic.putAccountValues(accountObj6);
		
		
		AccountInfo accountObj7= new AccountInfo();
		accountObj7.setCustomerId(1);
		accountObj7.setBrachName("Karaikudi");
		accountObj7.setBankBalance(1478523);
		//logic.putAccountValues(accountObj7);
		
		try
		{
		logic.putAccountDetails(accountObj0);
		logic.putAccountDetails(accountObj1);
		logic.putAccountDetails(accountObj2);
		logic.putAccountDetails(accountObj3);
		logic.putAccountDetails(accountObj4);
		logic.putAccountDetails(accountObj5);
		logic.putAccountDetails(accountObj6);
		logic.putAccountDetails(accountObj7);
		}
		catch(CustomException e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	private void putInfo(int size)
	{
		for(int i=0;i<size;i++)
		{
			CustomerInfo customerObj=new CustomerInfo();
			
			System.out.println("Enter a name for Customer");
			customerObj.setCustomerName(input.getString());
			System.out.println("Enter the Address");
			customerObj.setAddress(input.getString());
			System.out.println("Enter a Mobile Number");
			customerObj.setMobile(input.getLong());
			
			try
			{
				logic.putCustomerDetails(customerObj);
			}
			catch(CustomException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
		}
	}
	
	private void putAccountInfo(int size)
	{
		for(int i=0;i<size;i++)
		{
			AccountInfo accountObj=new AccountInfo();
			System.out.println("CustomerId");
			accountObj.setCustomerId(input.getInt());
			System.out.println("Enter a name for Branchname");
			accountObj.setBrachName(input.getString());
			System.out.println("Balance");
			accountObj.setBankBalance(input.getLong());
			try
			{
				logic.putAccountDetails(accountObj);
			}
			catch(CustomException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
		}
	}
	
	private void getInfo()
	{
		System.out.println("Enter the Customer customerId :");
		int customerId=input.getInt();
		try {
			System.out.println(logic.getCustomerDetails(customerId));
		} catch (CustomException e) 
		{
			e.getMessage();
			e.printStackTrace();
		}
	}
	
//	private void getAccountInfo()
//	{
//		System.out.println("Enter the Account customerId :");
//		int customerId=input.getInt();
//		System.out.println(logic.accountInfo(customerId));
//	}
	
	private void getCustomerAccount()
	{
		System.out.println("Enter the customer customerId :");
		int customerId=input.getInt();
		try {
			System.out.println(logic.getActiveAccounts(customerId));
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void getAccount()
	{
		System.out.println("Enter the customer customerId :");
		int customerId=input.getInt();
		System.out.println("Enter the Account customerId :");
		int acId=input.getInt();
		try {
			System.out.println(logic.getAccountDetails(customerId,acId));
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void changeAccount()
	{
		System.out.println("Enter customer Id");
		int customerId=input.getInt();
		System.out.println("Enter Account no");
		int accountId=input.getInt();
		System.out.println("Enter 0 for account DeActivation"+"\n"
				+"Enter 1 for account Activation");
		int number=input.getInt();
		boolean state=false;
		if(number==1)
		{
			state=true;
		}
		try {
			logic.setAccountState(customerId,accountId,state);
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("Success");
	}
	
//	private void getActiveAccount()
//	{
//		System.out.println("Enter customer Id");
//		int customerId=input.getInt();
//		try {
//			System.out.println(logic.getActiveAccounts(customerId));
//		} catch (CustomException e) {
//			e.getMessage();
//			e.printStackTrace();
//		}
//	}
	
	private void changeCustomer()
	{
		System.out.println("Enter customer Id");
		int customerId=input.getInt();
		System.out.println("Enter 0 for account DeActivation"+"\n"
				+"Enter 1 for account Activation");
		int number=input.getInt();
		boolean state=false;
		if(number==1)
		{
			state=true;
		}try {
			logic.setCustomerState(customerId,state);
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("Success");
	}
	
	private void withdraw()
	{
		System.out.println("Enter customer Id");
		int customerId=input.getInt();
		System.out.println("Enter Account no");
		int accountId=input.getInt();
		System.out.println("Enter a amount for withdrawl");
		double number=input.getDouble();
		try {
			System.out.println(logic.withdraw(customerId,accountId,number));
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void deposit()
	{
		System.out.println("Enter customer Id");
		int customerId=input.getInt();
		System.out.println("Enter Account no");
		int accountId=input.getInt();
		System.out.println("Enter a amount for deposit");
		double number=input.getDouble();
		try {
			System.out.println(logic.deposit(customerId,accountId,number));
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void balance()
	{
		System.out.println("Enter customer Id");
		int customerId=input.getInt();
		System.out.println("Enter Account no");
		int accountId=input.getInt();
		try {
			System.out.println(logic.getBalance(customerId,accountId));
		} catch (CustomException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		BankRunner runner = new BankRunner();
		
		Input input=new Input();
		
		boolean flag=true;
//		
//		runner.details();
//		runner.putAccountDetails();
//		runner.case12();
		
		while(flag)
		{
			System.out.println("Enter your choice");
			int choice=input.getInt();
			switch(choice)
			{
				case 0:
					flag=false;
					System.out.println("Exit");
					break;
					
				case 111:
					runner.details();
					runner.putAccountDetails();
					break;
					
				case 1:
					System.out.println("How many details you want to add?");
					int size=input.getInt();
					runner.putInfo(size);
					break;
					
				case 2:
					System.out.println("How many details you want to add?");
					int num=input.getInt();
					runner.putAccountInfo(num);
					break;	
					
				case 3:
					runner.getInfo();
					break;
				
				case 4:
					runner.getCustomerAccount();
					break;		
					
				case 5:
					runner.changeAccount();
					break;
					
				case 6:
					runner.create();
					break;
				
				case 7:
					runner.changeCustomer();
					break;
					
				case 8:
					runner.getAccount();
					break;
					
				case 9:
					runner.balance();
					break;
					
				case 10:
					runner.deposit();
					break;
					
				case 11:
					runner.withdraw();
					break;
					
				case 14:
					runner.case14();
					break;
					
				default:
					System.out.println("Enter a valid Choice");
					break;
			}
			
		}
	}

	private void create() 
	{
		try {
			System.out.println(logic.createStorage());
		} catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}

	private void case14() 
	{
		try {
			logic.fetchDetails();
		} catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	

	
}
