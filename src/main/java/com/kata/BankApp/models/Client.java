package com.kata.BankApp.models;

/*
 * This is a client model class, I must note that a client can have MULTIPLE accounts, for the sake of simplicity:
 * only one account is created per client instance.
 * in prod environment, also a client ID must be automatically generated accordingly, I did not use a client id #
 * in the example.
 */
public class Client {
	private String cientName;
	private Account account;

	public Client(String cientName) {
		this.cientName = cientName;
		this.account = new Account();
	}

	public String getCientName() {
		return cientName;
	}

	public void setCientName(String cientName) {
		this.cientName = cientName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
