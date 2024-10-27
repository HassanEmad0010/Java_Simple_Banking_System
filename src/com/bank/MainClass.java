// This project is done by me from A to Z


package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public static void main (String [] argus)
	{
		Scanner input = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();
		/*
		 * Account hassanAccount = new Account("1000010342", "Hassan Emad", 20000.00);
		 * Account AliAccount = new Account("20003943300", "ALi ALI", 15000.22);
		 * accounts.add(hassanAccount); accounts.add(AliAccount);
		 * BankManagementSystem.setAccounts(accounts);
		 * 
		 * System.out.println(BankManagementSystem.getAccounts());
		 * 
		 * 
		 * BankManagementSystem.withdrawalTXN(hassanAccount, 100);
		 * BankManagementSystem.withdrawalTXN(hassanAccount, 100);
		 * BankManagementSystem.withdrawalTXN(hassanAccount, 100);
		 * BankManagementSystem.withdrawalTXN(hassanAccount, 100);
		 * 
		 * BankManagementSystem.withdrawalTXN(AliAccount, 250);
		 * 
		 * BankManagementSystem.depositTXN(AliAccount, 1000);
		 * BankManagementSystem.depositTXN(hassanAccount, 1000);
		 * 
		 * 
		 * System.out.println(BankManagementSystem.getAccounts());
		 */
		
		
		int mainMenuChoise =0;
		
		boolean closeFlag = false;
		
		do {
			System.out.println("				*******Welcome on our testing Bank System*******");

			switch (mainMenuChoise) {
			case 0: {
				
				System.out.println(" --The_Main_Menu--");
				System.out.println("TO regist a new account press 1");
				System.out.println("TO display account info press 2");
				System.out.println("TO Withdraw amount press 3");
				System.out.println("TO deposit amount press 4");

				System.out.println("TO close press 0");			
				int choise = input.nextInt();


			switch (choise) {
			case 0: {
				System.out.println("Closing the system....");
				closeFlag = true;
				break;
			}
			case 1: {
				System.out.println("------------ Register a new Account------------- ");
				System.out.println("To return to the main menu press 000");

				System.out.println("Add your account number");
				String accNum = input.next();
				
				if (accNum.equals("000"))
				{
					mainMenuChoise =0;
					break;
				}
				
				System.out.println("Add your name");
				String accName = input.next();

				// Clear the buffer by calling nextLine() before reading a double
				System.out.println("Add the initial amount to deposit");
				 double accAmount =0.0 ;
				if (input.hasNextDouble()) { // Check if the input is a valid double
				     accAmount = input.nextDouble();
				    System.out.println("Acconut balance is: " + accAmount);
				} else {
				    System.out.println("Invalid amount entered. Please enter a number.");
				     // Clear the invalid input
				    mainMenuChoise=0;
				}
				Account account = new Account(accNum, accName, accAmount);
				accounts.add(account);
				BankManagementSystem.setAccounts(accounts);
				System.out.println("* Account added successfully *");
				System.out.println(account.toString());
				System.out.println("");
				mainMenuChoise =0;
				break;
			}
			case 2: {
				System.out.println("------------ Displaying account info------------- ");
				
				if (!accounts.isEmpty())
				{
					int accountCounter =1;
				for (Account account : BankManagementSystem.getAccounts())
				{
					
					System.out.printf("## 	Account: #%d:- 			  %n",accountCounter);
					System.out.printf("## Account number is %s ## %n", account.getAccountNumber() );
					System.out.printf("## Account name is %s ## %n", account.getAccountHolder());
					System.out.printf("## Account balance is %.2f ## %n",account.getBalance());
					System.out.println("");
					accountCounter++;
				}
				
				}
				else 
					System.out.println("No accounts to display");
				
				break;
			}
			
			case 3: {
				try {
					System.out.println("------------ Withdrawal Sub-Menu------------- ");
					System.out.println("*Enter your account number");
					String accNum = input.next().trim();
					System.out.println("*Enter the amount to withdraw in EGP");
					Double amt = input.nextDouble();
					
					double newBalance = BankManagementSystem.withdrawalTXN(accNum, amt);
					
					if (newBalance != -1.00)
					{
						System.out.println("-- Withdrawal TXN is done successfully --");
						System.out.println("The new balance is "+ newBalance);

					}
					else 
					{
						System.out.println("Error when withdrawal, may insuffitint balance or excceds max num of withdrwal");
					}
					
					
				} catch (Exception e) {
					System.out.println("Invalid in whithdrawal TXN"+ e.getMessage());
				}
				
				

				break;
			}
			
			case 4:
			{
				try {
					System.out.println("------------ Deposit Sub-Menu------------- ");
					System.out.println("*Enter your account number");
					String accNum = input.next().trim();
					System.out.println("*Enter the amount to deposit in EGP");
					Double amt = input.nextDouble();
					
					double newBalance = BankManagementSystem.depositTXN(accNum, amt);
					
					if (newBalance != -1.00)
					{
						System.out.println("-- Deposit TXN is done successfully --");
						System.out.println("The new balance is "+ newBalance);
					}
					else 
					{
						System.out.println("Error: Max deposit TXNS may excceded for this customer");
					}
					
					
				} catch (Exception e) {
				System.out.println("Error on deposit sub-menu: invalid input data");
				}
				break;
			}
			
			default:
				System.out.println("Invalid input please try again");
				closeFlag = true;
				break;
			} //inner switch case
			break;
			} //outer case
			default:
				throw new IllegalArgumentException("Unexpected value: " + mainMenuChoise);
			}
			
		} while (!closeFlag);
		input.close();
	
	}
	
	
}
