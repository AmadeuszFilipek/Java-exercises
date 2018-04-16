package exercise8;

public class test {

	public static void main(String[] args) {
	
		Account acc = new Account("george", 1122, 1000);
		acc.setAnnualInterestRate(1.5);
		
		acc.deposit(30, "Money from Grandpa");
		acc.deposit(40, "My last month's savings.");
		acc.deposit(50, "From Dad.");
		
		acc.withdraw(5, "Payment for a magazine");
		acc.withdraw(4, "Icecream");
		acc.withdraw(2, "Bread");
		
		System.out.println(acc);
		
		
	}

}
