package Exercises;

import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
	
		double drivingDistance, milesPerGallon, pricePerGallon, costOfDriving;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the driving distance:");
		drivingDistance = scanDouble(scanner);
		System.out.println("Enter miles per gallon:");
		milesPerGallon = scanDouble(scanner);
		System.out.println("Enter price per gallon:");
		pricePerGallon = scanDouble(scanner);
		
		costOfDriving = drivingDistance * pricePerGallon / milesPerGallon;
		
		System.out.println("The cost of driving is $" + costOfDriving);
	
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
