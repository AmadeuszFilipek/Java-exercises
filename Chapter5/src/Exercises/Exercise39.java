package Exercises;

public class Exercise39 {

	public static void main(String[] args) {

		double salesAmount = 0;
		final double baseSalary = 5000;
		double salary = 5000;

		while (salary < 30000) {
			salesAmount++;
			salary = baseSalary + comission(salesAmount);
		}
		
		System.out.println("The minimum sales to earn $30'000 a year is: " + salesAmount);

	}
	
	private static double comission(double sales) {
		
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
