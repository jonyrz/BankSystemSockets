
package itq.dist.banksystem.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Transaction extends Thread{
	final static Logger logger = LogManager.getLogger(Transaction.class);
	private Account account;
	private int mov;
	private double monto;
	private int trans;

public Transaction(Account account, int mov, double monto, int trans) {
	this.account = account;
	this.mov = mov;
	this.monto = monto;
	this.trans = trans;
}
	
public void run (){
	if(this.trans ==1) {
	account.ficticio();
	}	
	account.noSyncFicticio();		
	logger.info("Account: [" + account.getAccountId() + "] movemenent type: [" 
					+ mov + "] monto: [" + monto  + "]");
	if(mov == 0) {
		account.updateBalance(monto, trans, mov);
	} 
	else{
		account.setBalance(account.getBalance() + monto);
	}
}
}