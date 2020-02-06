import java.math.BigDecimal;
/**
 * SavingAccount class takes withdraw and deposit methods from Account class
 * @author Jaemin Oh
 *
 */
public class SavingAccount extends Account {
	
	/**
	 * The default way to create saving account
	 * @param accountOwner
	 * @param accountBalance
	 */
	public SavingAccount(String accountOwner, BigDecimal accountBalance) {
		this.accoutOwner = accountOwner;
		this.accountBalance = accountBalance;
	}
	
	/**if account balance after withdrawing and amount to withdraw are positive, withdraw it
	 * all other situation, print ERROR
	 */
	@Override
	public void withdraw(BigDecimal amountToWithdraw) {		
		if(accountBalance.subtract(amountToWithdraw).compareTo(BigDecimal.ZERO) > 0) {
			//when account balance after withdrawing is positive
			if(amountToWithdraw.compareTo(BigDecimal.ZERO) > 0) {
				//when amount to withdraw is positive
				accountBalance = accountBalance.subtract(amountToWithdraw); // withdraw
			}
		} else System.out.println("ERROR");		
	} //withdraw end

	/**if account balance is positive, deposit
	 * all other situation, print ERROR
	 */
	@Override
	public void deposit(BigDecimal amountToDeposit) {		
		if(amountToDeposit.compareTo(BigDecimal.ZERO) > 0) {
			accountBalance = accountBalance.add(amountToDeposit);
		} else System.out.println("ERROR");
	} //Deposit end
} //SavingAccount end
