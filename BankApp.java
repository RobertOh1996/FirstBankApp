import java.math.BigDecimal;
import java.util.ArrayList;
/**
 * BankApp class makes objects of checking or saving accounts and print their values. 
 ** 
 * @author Jaemin Oh *
 */
public class BankApp {

	public static void main(String[] args) {
		
		
		CheckingAccount acc1 = new CheckingAccount("Jaemin", new BigDecimal("3000"), false, true);
		//first checking account1
		System.out.println("acc1 balance"); //it's going to be "3000"
		System.out.println(acc1.getAccountBalance()); //balance of checking account1
		
		acc1.withdraw(new BigDecimal("2000")); //withdraw 2000 in checking account1
		System.out.println("acc1 balance after withdraw");//it's going to be "1000"
		System.out.println(acc1.getAccountBalance()); //balance of checking account1 after withdrawing
		
		ArrayList<Account> list = new ArrayList<Account>(); //list of accounts
		SavingAccount acc2 = new SavingAccount("Taeho", new BigDecimal("2000"));
		//first saving account1
		CheckingAccount acc3 = new CheckingAccount("Joonwoo", new BigDecimal("1500"), false, true);
		//second checking account2
		acc2.deposit(new BigDecimal("5000")); //deposit 5000 in saving account1
		acc3.withdraw(new BigDecimal("2000")); //withdraw 2000 in checking account2
		list.add(acc2);
		list.add(acc3); //add accounts in list
		for(int i = 0;i < list.size();i++) { //traverse list
			System.out.println("result"+(i+1)); 
			System.out.println(list.get(i).getAccountBalance());
			//print balances
			//they're going to be "7000", "535"
		}		
	} //main method end
} //Bankapp end
