package Exercises;

import java.util.Scanner;

public class Exercise31 {

public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double saveAmount = 0;
		double monthlyInterestRate = 0;
		double annualInterestRate = 0;
		int numberOfMonths = 0;
		
		System.out.print("Enter the initial deposit amount: ");
		while(true) {
			if(scanner.hasNextDouble()){
				saveAmount = scanner.nextDouble();
				break;
			}
			else scanner.next();
		}
		
		System.out.print("Enter annual percentage yield: ");
		while(true) {
			if(scanner.hasNextDouble()){
				annualInterestRate = scanner.nextDouble();
				break;
			}
			else scanner.next();
		}
		
		System.out.print("Enter maturity period(number of months): ");
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
		double account = saveAmount;
		
		System.out.println("\n");
		System.out.println("Month\tCD Value");
		for (int i = 1; i <= numberOfMonths; i++) {
			account *= (1 + monthlyInterestRate); 
			System.out.printf("%d\t%.2f\n", i, account);
		}
	}
}
