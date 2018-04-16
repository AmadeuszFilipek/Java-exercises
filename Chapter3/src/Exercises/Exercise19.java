package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[] sides = new double[3];
		System.out.println("Enter three sides for a triangle: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				sides[0] = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					sides[1] = scanner.nextDouble();
					if (scanner.hasNextDouble()) {
						sides[2] = scanner.nextDouble();
						break;
					}
				}
			}
			else
				scanner.nextLine();	
		}
		scanner.close();
		
		Arrays.sort(sides);
		double sum = sides[0] + sides[1] + sides[2];
		if (sides[0] + sides[1] > sides[2])
			System.out.println("The triangle perimeter is " + sum);
		else
			System.out.println("The given sides do not create a triangle");
	}
}