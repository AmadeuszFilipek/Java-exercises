package Exercises;

import java.util.Scanner;

public class Exercise42 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a sought comission: ");
		double soughtComission = 25000;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				soughtComission = scanner.nextDouble();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		double salesAmount = 0;
		final double baseSalary = 5000;
		double salary = 5000;

		while (salary < baseSalary + soughtComission) {
			salesAmount++;
			salary = baseSalary + comission(salesAmount);
		}
		
		System.out.println("The minimum sales to earn " + (soughtComission + baseSalary) + 
				" a year is: " + salesAmount);

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
