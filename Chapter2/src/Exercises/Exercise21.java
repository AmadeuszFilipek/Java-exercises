package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
		
		double investmentAmount, annualInterestRate, years, futureInvestmentValue;
		double monthlyInterestRate;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter investment amount:");
		investmentAmount = scanDouble(scanner);
		System.out.println("Enter annual interest rate in percentage:");
		annualInterestRate = scanDouble(scanner);
		System.out.println("Enter number of years:");
		years = scanDouble(scanner);
		scanner.close();
		
		monthlyInterestRate = annualInterestRate / 12 / 100;
		futureInvestmentValue = investmentAmount * 
				Math.pow((1 + monthlyInterestRate), years * 12);
				
		System.out.println("Accumulated value is $" + futureInvestmentValue);
		
	}
	
	private static double scanDouble (Scanner scanner) {
		while (true) {
			if (scanner.hasNextDouble()) {
				return scanner.nextDouble();
			}
			else scanner.nextLine();		
		}	
	}
}
