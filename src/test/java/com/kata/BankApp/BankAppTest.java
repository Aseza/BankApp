package com.kata.BankApp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.kata.BankApp.models.*;
import com.kata.BankApp.custom_exceptions.InsufficientFundsException;

/**
 * Unit test for our BankApp, All tests are described in method names
 */
public class BankAppTest {
	Client cl;
	Account clAccount;

	@Before
	public void setup() {
		cl = new Client("Abdelilah");
		clAccount = cl.getAccount();
	}

	@Test
	public void ifNewlyOpenedThenBalanceMustBeEmpty() {
		assertEquals(0.0, clAccount.getBalance(), 0);

	}

	@Test(expected = InsufficientFundsException.class)
	public void whenInsufficientFunds() throws Exception {

		clAccount.deposit(10.0);
		clAccount.withdraw(12.0);

	}

	@Test(expected = InsufficientFundsException.class)
	public void whenInsufficientFunds_emptyAccount() throws Exception {
		clAccount.withdraw(12.0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void whenDepositValueIsIllegall() throws IllegalArgumentException {
		clAccount.deposit(-12.0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void whenWithdrawalValueIsIllegall() throws Exception {
		clAccount.withdraw(-12.0);

	}

	@Test
	public void whenNominalCase_incrementalDeposit() throws Exception {

		clAccount.deposit(12.0);
		clAccount.deposit(1.0);

		assertEquals(13.0, clAccount.getBalance(), 0);

	}

	@Test
	public void whenNominalCase_incrementalWithdrawal() throws Exception {

		clAccount.deposit(12.0);

		clAccount.withdraw(1.0);
		clAccount.withdraw(10.0);

		assertEquals(1.0, clAccount.getBalance(), 0);

	}

	@Test
	public void whenNominalCase_depositAndWithdraw() throws Exception {

		clAccount.deposit(12.0);
		assertEquals(12.0, clAccount.getBalance(), 0);

		clAccount.withdraw(10);
		assertEquals(2.0, clAccount.getBalance(), 0);

		clAccount.deposit(1.0);
		assertEquals(3.0, clAccount.getBalance(), 0);

	}

	@Test
	public void assertTransactionsList() throws Exception {
		clAccount.deposit(12.0);
		clAccount.withdraw(10);
		clAccount.deposit(1.0);
		List<Transaction> transactionsList = clAccount.getTransactionsList();
		
		//Asserting Number of transactions
		assertEquals(3, transactionsList.size());
		

		//Asserting transaction id
		assertEquals(1, transactionsList.get(0).getId());
		assertEquals(2, transactionsList.get(1).getId());
		assertEquals(3, transactionsList.get(2).getId());
		
		//Asserting balance at transaction
		assertEquals(12.0, transactionsList.get(0).getBalanceAtTransaction(),0);
		assertEquals(2.0, transactionsList.get(1).getBalanceAtTransaction(),0);
		assertEquals(3.0, transactionsList.get(2).getBalanceAtTransaction(),0);
		
		//Asserting transaction amount
		assertEquals(12.0, transactionsList.get(0).getTransactionAmount(),0);
		assertEquals(10.0, transactionsList.get(1).getTransactionAmount(),0);
		assertEquals(1.0, transactionsList.get(2).getTransactionAmount(),0);
		
		//Asserting transaction type
		assertEquals("DEPOSIT", transactionsList.get(0).getTransactionType().name());
		assertEquals("WITHDRAWAL", transactionsList.get(1).getTransactionType().name());
		assertEquals("DEPOSIT", transactionsList.get(2).getTransactionType().name());

		
		
		
	}		


}
