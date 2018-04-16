package Exercises;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double amountIvested = 0;
		double annualInterestRate = 0;
		
		System.out.print("The amount invested: ");
		amountIvested = scanDouble(scanner);
		
		System.out.print("Annual interest rate [%]: ");
		annualInterestRate = scanDouble(scanner);
		annualInterestRate /= 100;
		
		System.out.println("Years\tFuture Value\n");
		
		for(int i = 1; i <= 30; i++) 
			System.out.printf("%d\t%.2f\n", i, 
					futureInvestmentValue(amountIvested, annualInterestRate / 12 , i));	
		
	}
	
	private static double scanDouble (Scanner scanner) {
		while (true) {
			if (scanner.hasNextDouble()) {
				return scanner.nextDouble();
			}
			else scanner.nextLine();		
		}	
	}
	
	public static double futureInvestmentValue(
			double investmentAmount, double monthlyInterestRate, int years) {
		
		return investmentAmount * 
				Math.pow((1 + monthlyInterestRate), years * 12);
	}
}
