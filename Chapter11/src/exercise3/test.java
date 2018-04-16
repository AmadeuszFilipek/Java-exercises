package exercise3;

public class test {

	public static void main(String[] args) {
		
		Account acc = new Account(1, 10000);
		
		SavingsAccount savAcc = new SavingsAccount(acc);
		CheckingAccount checkingAcc = new CheckingAccount(acc, 5000);
		
		System.out.println(acc);
		System.out.println(savAcc);
		System.out.println(checkingAcc);
		
		
	}
	
}
