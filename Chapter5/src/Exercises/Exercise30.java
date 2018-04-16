package Exercises;

import java.util.Scanner;

public class Exercise30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double saveAmount = 0;
		double monthlyInterestRate = 0;
		double annualInterestRate = 0;
		int numberOfMonths = 0;
		
		System.out.print("Enter monthly saving amount: ");
		while(true) {
			if(scanner.hasNextDouble()){
				saveAmount = scanner.nextDouble();
				break;
			}
			else scanner.next();
		}
		
		System.out.print("Enter annual interest rate [%]: ");
		while(true) {
			if(scanner.hasNextDouble()){
				annualInterestRate = scanner.nextDouble();
				break;
			}
			else scanner.next();
		}
		
		System.out.print("Enter number of months: ");
		while(true) {
			if(scanner.hasNextInt()){
				numberOfMonths = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		annualInterestRate = annualInterestRate / 100;
		monthlyInterestRate = annualInterestRate / 12;
		double account = 0;
		
		for (int i = 1; i <= numberOfMonths; i++) 
			account = (saveAmount + account) * (1 + monthlyInterestRate); 
			
		System.out.println("The account value in savings after " + numberOfMonths +
				" months is " + account);
	}
}
