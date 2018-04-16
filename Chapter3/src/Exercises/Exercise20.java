package Exercises;

import java.util.Scanner;

public class Exercise20 {

	public static void main(String[] args) {
	
		double temperature, windSpeed, windChillIndex;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the temperature in Fahrenheit between -58 F and 41 F:");
		temperature = scanDouble(scanner);
		System.out.println("Enter the windspeed (>=2) in miles per hour: ");
		windSpeed = scanDouble(scanner);
		
		if ((temperature < -58 || temperature > 41) && windSpeed < 2) {
			System.out.println("Invalid temperature and windspeed, out of range.");
			System.exit(1);
		}
		else if (temperature < -58 || temperature > 41) {
			System.out.println("Invalid temperature, out of range.");
			System.exit(1);
		}
		else if (windSpeed < 2) {
			System.out.println("Invalid windspeed, out of range.");
			System.exit(1);
		}
		
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
