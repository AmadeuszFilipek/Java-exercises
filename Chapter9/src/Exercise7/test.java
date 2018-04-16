package Exercise7;

public class test {

	public static void main(String[] args) {
		
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		
		System.out.println("balance: " + account.getBalance());
		System.out.println("Monthly interest: " + account.getMonthlyInterest());
		System.out.println("Date of creation: " + account.getDateCreated().toString());
	}
}
