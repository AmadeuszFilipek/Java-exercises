package Exercises;

import java.util.Scanner;

public class Exercise10 {

	public static void main(String[] args) {
		
		double initialTemp, finalTemp, waterAmount, energyNeeded;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the amount of water in kilograms: ");
		waterAmount = scanDouble(scanner);
		System.out.println("Enter the initial temperature: ");
		initialTemp = scanDouble(scanner);
		System.out.println("Enter the final temperature: ");
		finalTemp = scanDouble(scanner);
		
		energyNeeded = waterAmount * (finalTemp - initialTemp) * 4184;
		
		System.out.println("The energy needed is: " + energyNeeded);
	}
	
	private static double scanDouble(Scanner scanner) {
		while (true) {
			if (scanner.hasNextDouble()) {
				return scanner.nextDouble();
			}
			else
				scanner.nextLine();	
		}
	}
}

