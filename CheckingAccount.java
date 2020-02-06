import java.math.BigDecimal;

/**
 * CheckingAccount class takes withdraw and deposit methods from Account class
 * 
 * @author Jaemin Oh
 *
 */
public class CheckingAccount extends Account {
	private boolean overdraft = true;
	//if overdraft is true, this account is overdrawn
	//default is true
	private boolean active = false;
	//if active is true, this account is active
	//default is false

	/**
	 * The default way to create Checking Account
	 * @param accountOwner
	 * @param accountBalance
	 * @param overdraft
	 * @param active
	 */
	public CheckingAccount(String accountOwner, BigDecimal accountBalance, boolean overdraft, boolean active) {
		this.accoutOwner = accountOwner;
		this.accountBalance = accountBalance;
		this.overdraft = overdraft;
		this.active = active;
	}
	
	/**if account balance and amount to withdraw is positive, run first "if" - just withdraw
	 * if account balance gonna be negative, overdraw and charge 35 fee
	 * if account balance gonna be under 1000, pause withdraw
	 * if amount to withdraw is negative, print ERROR
	 */
	@Override
	public void withdraw(BigDecimal amountToWithdraw) {
		if (amountToWithdraw.compareTo(BigDecimal.ZERO) > 0 && accountBalance.compareTo(BigDecimal.ZERO) > 0) {
			accountBalance = accountBalance.subtract(amountToWithdraw);
			//balance > 0 && amountToWithdraw > 0 -> just withdraw
		  if (accountBalance.compareTo(BigDecimal.ZERO) < 0) { //if balance is under 0 
			overdraft = true; //overdraft
			System.out.println("This account is overdrawn");
			BigDecimal overdraftFee = new BigDecimal("35"); //overdraft fee
			accountBalance = accountBalance.subtract(overdraftFee); //charge overdraft fee
			BigDecimal limit = new BigDecimal("-1000"); //overdraft limit
			if (accountBalance.compareTo(limit) < 0) { //when balance is under 1000
				System.out.println("You have exceeded your maximum withdrawal amount");
				return; //pause withdraw
			}
		  }
		} else {
			System.out.println("ERROR");
		}
	} // withdraw end

	/**if account balance is negative, inactive but can deposit
	 * if account balance is positive set active and deposit
	 * if amountToDeposit is negative, print ERROR
	 */
	@Override
	public void deposit(BigDecimal amountToDeposit) {

		if (accountBalance.compareTo(BigDecimal.ZERO) < 0) { //when balance is negative 
			accountBalance = accountBalance.add(amountToDeposit); //just deposit
			if (accountBalance.compareTo(BigDecimal.ZERO) > 0) { //when balance is positive
				active = true; //set account active
				accountBalance = accountBalance.add(amountToDeposit); //and deposit
			}
		} else
			System.out.println("ERROR");

	} // deposit end
} // CheckingAccount end
