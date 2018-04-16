package Exercises;

import java.util.Scanner;

public class Exercise12 {

	public static void main(String[] args) {

		double acceleration, takeOffSpeed, runwayLength;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter speed and acceleration: ");
		while (true) {
			if (scanner.hasNextDouble()) {
				takeOffSpeed = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					acceleration = scanner.nextDouble();
					break;
				}
			}
			else
				scanner.nextLine();
		}
  	scanner.close();
  	
		runwayLength = takeOffSpeed * takeOffSpeed / 2 / acceleration;
		
		System.out.println("The minimum runway length for this airplane is " + runwayLength);	
  	
	}	
}
