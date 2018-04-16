package Exercises;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
	
		double temperature, windSpeed, windChillIndex;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the temperature in Fahrenheit between -58 F and 41 F:");
		temperature = scanDouble(scanner);
		System.out.println("Enter the windspeed (>=2) in miles per hour: ");
		windSpeed = scanDouble(scanner);
		
		windChillIndex = 35.74 + 0.6215 * temperature - 35.75 *
				Math.pow(windSpeed, 0.16) + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
				
		System.out.println("The wind chill index is " + windChillIndex);
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
