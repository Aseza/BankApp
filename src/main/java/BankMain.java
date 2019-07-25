import com.kata.BankApp.custom_exceptions.InsufficientFundsException;
import com.kata.BankApp.models.Account;
import com.kata.BankApp.models.Client;
/*
 * 
 * This main class WAS ONLY ADDED TO SHOW TRANSACTION HISTORY, THIS IS NOT A TEST, test are created separately
 */
public class BankMain {
public static void main(String[] args) throws Exception {
	Client cl = new Client("Abdelilah");
	Account clAccount = cl.getAccount();
	try {

		clAccount.deposit(100.0);
		clAccount.withdraw(39.0);
		clAccount.deposit(10.0);
		clAccount.withdraw(39.0);
		clAccount.withdraw(13.0);
		System.out.println("-------START--------");
		clAccount.getTransactionsList();
		System.out.println("-------END--------");

	} finally {
	}
}
}
