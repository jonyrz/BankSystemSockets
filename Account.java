package itq.dist.banksystem.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {
	final static Logger logger = LogManager.getLogger(Account.class);
	private String accountId;
	private double balance;
	
public String getAccountId() {
	return accountId;
}

public void setAccountId(String accountId) {
	this.accountId = accountId;
}

public synchronized double getBalance() {
	return balance;
}

public  void  setBalance(double balance) {
	this.balance = balance;
}
	
public synchronized void updateBalance(double monto, int transNumber, int movType) {
	if(getBalance() >= monto) {		
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
				e.printStackTrace();
		}	
		setBalance(getBalance() - monto);
		logger.info("Transaction completed [" + transNumber + "]: " + "Account: [" + getAccountId() + "] movemenent type: [" 
					+ movType + "] monto: [" + monto  + "]");
	} 
	else{
			logger.error("Insuficient founds: [" + getAccountId() + "]");
	}	
}
	
public synchronized void  ficticio() {
	logger.info("Inicia ficticio");
	try {
			Thread.sleep(10000);
	} 
	catch (InterruptedException e) {
			e.printStackTrace();
	}
	logger.info("Termina ficticio");
}
	
public void  noSyncFicticio() {
	logger.info("Inicia noSyncFicticio");
	try {
		Thread.sleep(10000);
	} 
	catch (InterruptedException e) {
			e.printStackTrace();
		}
	logger.info("Termina noSyncFicticio");
	}
}

