package Exercises;

import java.util.Scanner;

public class Exercise20 {

	public static void main(String[] args) {
		
		double interest, balance, interestRate;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Balance and interest rate (e.g., 3 for 3%):");
		
		while (true) {
			if (scanner.hasNextDouble()) {
				 balance = scanner.nextDouble();
				 if (scanner.hasNextDouble()) {
					 interestRate = scanner.nextDouble();
					 break;
				 }
			}
			else
				scanner.nextLine();	
		}
		scanner.close();
		
		interest = balance * (interestRate) / 1200;
		
		System.out.println("The interest is " + interest);
		
	}
}
