package Exercises;

import java.util.Scanner;

public class Exercise9 {
	public static void main(String[] args) {
		
		double startingVel, endingVel, timeSpan;
		double averageAcceleration;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter v0, v1, and t: ");
		
		while (true) {
			if (scanner.hasNextDouble()) {
				startingVel = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					endingVel = scanner.nextDouble();
					if (scanner.hasNextDouble()) {
						timeSpan = scanner.nextDouble();
						break;
					}
				}
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		averageAcceleration = (endingVel - startingVel) / timeSpan;
		
		System.out.println("The average acceleration is: " + averageAcceleration);
		
	}
}
