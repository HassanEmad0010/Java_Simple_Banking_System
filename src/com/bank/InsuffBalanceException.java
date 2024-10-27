package com.bank;

public class InsuffBalanceException extends Exception {
	public InsuffBalanceException (String message)
	{
		super(message);
	}

}
