package exercise3;

/** SavingsAccount -> Account
 * ----------------------------------------
 * +SavingsAccount()
 * +SavingsAccount(account: Account)
 * +SavingsAccount(id: int, balance: double)
 * +withdraw(amount: double): void
 * +toString(): String
 * ----------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class SavingsAccount extends Account {

	public SavingsAccount() {}
	
	public SavingsAccount(Account account) { 
		super(account.getId(), account.getBalance());
	}
	
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount <= getBalance())
			setBalance(getBalance() - amount);
	}	
	
	public String toString() {
		return super.toString() + "\nThis is a savings account.";
	}
}
