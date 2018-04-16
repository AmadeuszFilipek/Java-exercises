package Exercises;

import java.util.Scanner;

public class Exercise31 {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double exchangeRate;
		int convert;
		double dollarAmount = 0, rmbAmount = 0;
		
		System.out.print("Enter the exchange rate from dollars to RMB: ");
		while(true) {
			if (scanner.hasNextDouble()){
				exchangeRate = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		System.out.print("Enter 0 to conver dollars to RMB and 1 vice versa: ");
		while(true) {
			if (scanner.hasNextInt()){
				convert = scanner.nextInt();
				break;
			}
			else scanner.nextLine();
		}
		if (convert == 0) {
			System.out.print("Enter the dollar amount: ");
			while(true) {
				if (scanner.hasNextDouble()){
					dollarAmount = scanner.nextDouble();
					break;
				}
				else scanner.nextLine();
			}
		}	
		else if (convert == 1) {
			System.out.print("Enter the RMB amount: ");
			while(true) {
				if (scanner.hasNextDouble()){
					rmbAmount = scanner.nextDouble();
					break;
				}
				else scanner.nextLine();
			}
		}
		else {
			System.out.println("Incorrect input");
			System.exit(1);
		}
		scanner.close();
		
		if (convert == 0) {
			rmbAmount = dollarAmount * exchangeRate;
			System.out.printf("$%.2f is %.1f yuan\n", dollarAmount, rmbAmount);
		}
		else if (convert == 1) {
			dollarAmount = rmbAmount / exchangeRate;
			System.out.printf("%.1f yuan is $%.2f\n", rmbAmount, dollarAmount);
		}
		
	}
}
