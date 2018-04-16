package Exercises;

import java.util.Scanner;

public class Exercise13 {

	public static void main(String[] args) {
		
		double monthlySave = 0;
		double annualInterestRate = 5./100;
		double monthlyInterestRate = annualInterestRate / 12;
		double accountValue = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the monthly saving amount: ");
		while (true) {
			if (scanner.hasNextDouble()) {
				monthlySave = scanner.nextDouble();
				break;
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		for (int i = 0; i < 6; i++) {
			accountValue = (accountValue + monthlySave) * (1 + monthlyInterestRate);
		}
		
		System.out.println("After the sixth month, the account value is $" + accountValue);
	}
}
