package Exercises;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {
		
		double  weight, height, bmi;
		double poundToKg = 0.45359237;
		double inchToMeter = 0.0254;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter weight in pounds: ");
		weight = scanDouble(scanner);
		System.out.println("Enter height in inches: ");
		height = scanDouble(scanner);
		
		bmi = weight * poundToKg / Math.pow((height * inchToMeter), 2);
		
		System.out.println("BMI is " + bmi);
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
