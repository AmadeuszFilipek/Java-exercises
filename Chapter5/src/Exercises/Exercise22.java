package Exercises;

import java.util.Scanner;

public class Exercise22 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double loanAmount = 0;
		int numberOfYears = 0;
		double annualInterestRate = 0;
		
		System.out.print("Loan Amount: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				loanAmount = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		
		System.out.print("Number of years: ");
		while(true) {
			if (scanner.hasNextInt()) {
				numberOfYears = scanner.nextInt();
				break;
			}
			else scanner.nextLine();
		}
		
		System.out.print("Annual interest rate: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				annualInterestRate = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		

		
		double interest, principal, balance = loanAmount;
		double monthlyInterestRate = annualInterestRate / 12 / 100.;
		double monthlyPayment = loanAmount * monthlyInterestRate / 
				(1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
		double totalPayment = monthlyPayment * numberOfYears * 12;
		
		System.out.printf("\nMonthly payment: %.2f\n", monthlyPayment);
		System.out.printf("Total payment: %.2f\n\n", totalPayment);
		System.out.println();
		System.out.println("Payment#\tInterest\tPrincipal\tBalance\n");
				
		for(int i = 1; i <= numberOfYears * 12; i++) {
			interest = monthlyInterestRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;
			
			System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n",
					i, interest, principal, balance);
		}	
	}
}
