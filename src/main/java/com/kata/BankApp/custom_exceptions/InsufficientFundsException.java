package com.kata.BankApp.custom_exceptions;
/*
 * an Exception class model that represents a new Exception : InsufficientFundsException
 */
public class InsufficientFundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {
		System.err.println("You can't withdraw that much money due insufficient funds");
	}
}
