package com.bank;

import java.util.ArrayList;
import java.util.List;

public class BankManagementSystem {

	private static List<Account> accounts;
	
	
	
	
	public static List<Account> getAccounts() {
		return accounts;
	}


	public static void setAccounts(List<Account> accounts) {
		BankManagementSystem.accounts = accounts;
	}


	public BankManagementSystem(List<Account> accountsList)
	{
		accounts = new ArrayList<>();
	}

	
	public static boolean withdrawalTXN(Account account, double amount)
	{
		if (checkAccount(account))
		{
			if ( account.withdrawalTXN(amount) != -1.00)
			{
				return true;
			}
		}
		return false;
	}
	
	public static double withdrawalTXN(String accountNumber, double amount)
	{
		Account account = returnAccountByAccNum(accountNumber); ;

		if (checkAccount(accountNumber))
		{

				return account.withdrawalTXN(amount);
			
		}
		return account.withdrawalTXN(amount);
	}
	
	public static boolean depositTXN (Account account, double amount)
	{
			if ( account.depositTXN(amount) != -1.00)
			{
				return true;
			}
		
		return false;
	}
	
	private static boolean checkAccount (Account account)
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
	
	private static boolean checkAccount(String accountNumber) {
	
		for (int i =0; i<accounts.size() ; i++)
		{
			if (accounts.get(i).getAccountNumber().equals(accountNumber))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static Account returnAccountByAccNum(String accountNumber)
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


	public static double depositTXN(String accountNumber, Double amt) {
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
	
	
	
	
	
}
