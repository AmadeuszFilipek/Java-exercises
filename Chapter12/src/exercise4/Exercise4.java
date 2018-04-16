package exercise4;

public class Exercise4 {

	public static void main(String[] args) {
		
		try {
			Loan loan = new Loan(-5, 5, 1000);
			System.out.println(loan.toString());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
