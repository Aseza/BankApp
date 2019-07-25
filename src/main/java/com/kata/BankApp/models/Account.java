package com.kata.BankApp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kata.BankApp.custom_exceptions.InsufficientFundsException;

/*
 * This is the account model class, it represents a client's account. it has multiple methods, to deposit, 
 * withdraw or get all recent Transactions.
 */
public class Account {

	private double balance;
	List<Transaction> transactionsList;
	private int transactionId;

	public Account() {
		this.balance = 0l;
		transactionsList = new ArrayList<>();
		transactionId = 0;
	}
	
	//deposit money method
	public void deposit(double amount) throws IllegalArgumentException {
		if (amount <= 0)
			throw new IllegalArgumentException("You cannot deposit that amount, please check again");
		this.balance += amount;
		transactionsList
				.add(new Transaction(++transactionId, TransactionType.DEPOSIT, amount, new Date(), this.balance));
		System.out.println("an amount of " + amount + " has been deposited, new balance is " + this.balance);
	}
	
	//withdraw money method
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > this.balance) {
			throw new InsufficientFundsException();
		} else if (amount<=0)		{
			throw new IllegalArgumentException();
		}
		else{
			this.balance -= amount;
			transactionsList.add(
					new Transaction(++transactionId, TransactionType.WITHDRAWAL, amount, new Date(), this.balance));
			System.out.println("an amount of " + amount + " has been withdrawed, new balance is " + this.balance);

		}
	}

	public double getBalance() {
		return balance;
	}
	//retrieve all transactions
	public List<Transaction> getTransactionsList() {
		for (Transaction transaction : transactionsList) {
			System.out.println(transaction);
		}
		return transactionsList;
	}

}
