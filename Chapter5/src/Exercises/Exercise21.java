package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double loanAmount = 0;
		int loanPeriod = 1;
		
		System.out.print("Loan amount: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				loanAmount = scanner.nextDouble();
				break;				
			}
			else scanner.next();
		}
		
		System.out.print("Number of years: ");
		while(true) {
			if (scanner.hasNextInt()) {
				loanPeriod = scanner.nextInt();
				break;				
			}
			else scanner.next();
		}
		scanner.close();
		
		String[] text = {"Interest rate", "Monthly Payment", "Total Payment"};
		System.out.println(text[0] + "\t" + text[1] + "\t" + text[2]);
		System.out.println();
		
		double interestRate = 5/100.;
		double monthlyPayment = loanAmount * interestRate;
		double totalPayment = loanAmount;
		
		for (double i = interestRate; i <= 8.1/100.; i += 1/8./100.) {
			
			monthlyPayment = loanAmount * i / 12 / (1 - 1 / Math.pow(1 + i / 12, loanPeriod * 12));
			totalPayment = monthlyPayment * loanPeriod * 12;
			
			System.out.printf("%-4.3f%%\t\t", i * 100);
			System.out.printf("%-14.2f\t", monthlyPayment);
			System.out.printf("%-10.2f\n", totalPayment);
		}	
	}
}
