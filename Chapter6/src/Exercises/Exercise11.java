package Exercises;

public class Exercise11 {
	
	public static void main(String[] args) {
	
		System.out.println("Sales amount\tComission");
		System.out.println("_________________________________");
		for(int amount = 10000; amount <= 100000; amount += 5000)
			System.out.printf("%d\t\t%9.1f\n", amount, computeComission(amount));
		
	}
	
	private static double computeComission(double sales) {
		
		double comission = 0;
		
		if (sales < 5000) {
			comission = 8 / 100. * sales;	
		}
		else if (sales < 10000) {
			comission = 8 / 100. * 5000 + (sales - 5000) * 10 / 100.;
		}
		else {
			comission = 8 / 100. * 5000 + 5000 * 10 / 100. + (sales - 10000) * 12 / 100.;
		}
		
		return comission;	
	}
}
