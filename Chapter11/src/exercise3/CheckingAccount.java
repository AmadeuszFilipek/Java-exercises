package exercise3;
/** CheckingAccount -> Account
 * ----------------------------------------
 * -overDraft:double
 * ----------------------------------------
 * +CheckingAccount()
 * +CheckingAccount(account: Account, limit: double)
 * +CheckingAccount(limit: double)
 * +CheckingAccount(id: integer, balance: double, limit: double)
 * +getOverdraftLimit(): double
 * +withdraw(amount: double): void
 * +toString(): String
 * ----------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class CheckingAccount extends Account {

	private double overdraftLimit;
	
	public CheckingAccount() {}
	
	public CheckingAccount(Account account, double limit) {
		super(account.getId(), account.getBalance());
		if (limit > 0)
			this.overdraftLimit = limit;
	}
	
	public CheckingAccount(double limit) {
		super();
		if (limit > 0)
			this.overdraftLimit = limit;
	}
	
	public CheckingAccount(int id, double balance, double limit) {
		super(id, balance);
		if (limit > 0)
			this.overdraftLimit = limit;
	}
	
	public double getOverdraftLimit() {
	return overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount < 0)
			return;
		if (getBalance() - amount > - 1 * overdraftLimit)
			setBalance(getBalance() - Math.abs(amount));
	}
	
	public String toString() {
		return super.toString() + "\nThis is a checking account.";
	}
}
