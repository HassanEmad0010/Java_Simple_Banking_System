package com.bank;

public interface AccountInterface {
	
	public double checkBalance();
	public double withdrawalTXN(double amount);
	public double depositTXN(double amount);
	public int remainWithdrawalTXNS();
	public int remaindTXNS();
	int remaindepositTXNS();

	
	

}
