package com.kata.BankApp.models;

import java.util.Date;
/*
 * This class represents a Transaction Model, it contains some instance variables to describe state;
 * it contains getters, setters , an overridden toString method and a constructor
 */
public class Transaction {
	
	private int id;
	private TransactionType transactionType;
	private double transactionAmount;
	private Date timeStamp;
	private double balanceAtTransaction;



	public Transaction(int id, TransactionType transactionType, double transactionAmount, Date timeStamp,
			double balanceAtTransaction) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.timeStamp = timeStamp;
		this.balanceAtTransaction = balanceAtTransaction;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getBalanceAtTransaction() {
		return balanceAtTransaction;
	}

	public void setBalanceAtTransaction(double balanceAtTransaction) {
		this.balanceAtTransaction = balanceAtTransaction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionType=" + transactionType + ", transactionAmount="
				+ transactionAmount + ", timeStamp=" + timeStamp + ", balanceAtTransaction=" + balanceAtTransaction
				+ "]";
	}

}
