package com.bank;

import java.util.ArrayList;
import java.util.List;

public class BankManagementSystem {

	private List<Account> accounts;
	
	
	
	
	public  List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	public BankManagementSystem(List<Account> accountsList)
	{
		accounts = new ArrayList<>();
	}

	

	
	public double withdrawalTXN(String accountNumber, double amount)
	{
		Account account = returnAccountByAccNum(accountNumber); ;

		if (checkAccount(accountNumber))
		{

				return account.withdrawalTXN(amount);
			
		}
		return account.withdrawalTXN(amount);
	}
	
	public double depositTXN(String accountNumber, Double amt) {
		Account account =returnAccountByAccNum(accountNumber);
		if (!(account.equals(null)))
		{
			if (checkAccount(account))
			{
				return account.depositTXN(amt);			
			}
		}
		
		return account.depositTXN(amt);	

		
	}
	
	
	
	private boolean checkAccount (Account account)
	{
		for (Account acc : accounts)
		{
			if (acc.equals(account))
			{
				return true;
			}
			
		}
		return false;
		
	}
	
	private boolean checkAccount(String accountNumber) {
	
		for (int i =0; i<accounts.size() ; i++)
		{
			if (accounts.get(i).getAccountNumber().equals(accountNumber))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public Account returnAccountByAccNum(String accountNumber)
	{
		for (int i = 0; i< accounts.size(); i++)
		{
			if (accounts.get(i).getAccountNumber().equals(accountNumber))
			{
				return accounts.get(i);
			}
		}
		return null;
	}

	public String toString() {
		return "BankManagementSystem [accounts=" + accounts + "]";
	}


	
	
	
	
	
	
}
