import java.math.BigDecimal;
/**
 * Account class defines basic fields and methods must be used in the checking and savingAccount classes.
 * @author Jaemin Oh
 *
 */
public abstract class Account {
	protected BigDecimal accountBalance;
	protected String accoutOwner;
	
	/** Gets value of account balance
	 * @param accountBalance The current account balance.
	 * @return balance of account
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	/**
	 * Sets value of account balance
	 * @param accountBalance
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	/**Gets value of account owner
	 * @param accountOwner owner's name
	 * @return accountOwner 
	 */
	public String getAccoutOwner() {
		return accoutOwner;
	}
	
	/**
	 * 
	 * @param accoutOwner
	 */
	public void setAccoutOwner(String accoutOwner) {
		this.accoutOwner = accoutOwner;
	}
	
	public abstract void withdraw(BigDecimal amountToWithdraw);
	public abstract void deposit(BigDecimal amountToDeposit);

}
