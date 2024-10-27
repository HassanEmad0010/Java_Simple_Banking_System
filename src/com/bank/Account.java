package com.bank;

public class Account implements AccountInterface {

	private String accountNumber, accountHolder ;
	private Double balance;
	private static final int MAX_WITHDRAWAL_TXNS = 3;
	private static final int MAX_DEPOSIT_TXNS = 2;
	private int numOfWithdrawalTxns =0;
	private int numOfDepositTXNS =0;

	public Account (String accountNumber, String accountHolder, Double balance)
	{
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
		
	}
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Double getBalance() {
		return balance;
	}
	private void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public double checkBalance() {
		
		return getBalance();
	}
	@Override
	public double withdrawalTXN(double amount) {
		if (getNumberOfWithdrawalTxns() < MAX_WITHDRAWAL_TXNS)
		{
			if (this.getBalance() > amount)
			{
				increaseWithdrawalTxns();
				setBalance(balance - amount);
				return this.balance - amount;
			}
		}
		return -1.00;
		}


	
	
		
		
	@Override
	public double depositTXN(double amount) {
		if (numOfDepositTXNS < MAX_DEPOSIT_TXNS)
		{
		increaseDepositTxns();
		setBalance(balance + amount);
		return getBalance();
		}
		return -1.00;
		
		}



	public int getNumberOfWithdrawalTxns() {
		return numOfWithdrawalTxns;
	}



	public void setNumberOfWithdrawalTxns(int numberOfWithdrawalTxns) {
		this.numOfWithdrawalTxns = numberOfWithdrawalTxns;
	}
	
	public void increaseWithdrawalTxns ()
	{
		setNumberOfWithdrawalTxns(numOfWithdrawalTxns + 1);;
	}
	
	public void increaseDepositTxns ()
	{
		setNumOfDepositTXNS(numOfDepositTXNS +1 );
	}



	public int getNumOfDepositTXNS() {
		return numOfDepositTXNS;
	}



	public void setNumOfDepositTXNS(int numOfDepositTXNS) {
		this.numOfDepositTXNS = numOfDepositTXNS;
	}



	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance=" + balance
				+ ", numOfWithdrawalTxns=" + numOfWithdrawalTxns + ", numOfDepositTXNS=" + numOfDepositTXNS + "]";
	}
	
	
	
	
	
	
	
	
}
