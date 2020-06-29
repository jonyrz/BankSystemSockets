
package itq.dist.banksystem.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankSystem {
	final static Logger logger = LogManager.getLogger(BankSystem.class);

	public static void main(String[] args) {
		
		Account account1 = new Account();
		account1.setAccountId("0000000001");
		account1.setBalance(10000);
		
		Account account2 = new Account();
		account2.setAccountId("0000000002");
		account2.setBalance(30000);

		Account account3 = new Account();
		account3.setAccountId("0000000003");
		account3.setBalance(20000);
		
		Thread t1 = new Transaction (account1, 0, 1000, 1);
		Thread t2 = new Transaction (account1, 0, 10000, 2);
		Thread t3 = new Transaction (account1, 0, 8000, 3);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}

