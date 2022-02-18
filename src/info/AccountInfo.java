package info;

import java.io.Serializable;

public class AccountInfo implements Serializable
{
	private int accountId;
	private int customerId;
	private String brachName;
	private double bankBalance;
	private boolean status=true;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getBrachName() {
		return brachName;
	}
	public void setBrachName(String brachName) {
		this.brachName = brachName;
	}
	public double getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	@Override
	public String toString() 
	{
		return "customerId = "+customerId + ", brachName = " + brachName + ", bankBalance = " + bankBalance;
	}

}
