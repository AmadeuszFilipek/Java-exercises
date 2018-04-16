package Exercises;

import java.util.Scanner;

public class Exercise22 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double x, y;
		final double RADIUS = 10;
		
		System.out.print("Enter a point with two coordinates: ");
		while(true){
			if (scanner.hasNextDouble()) {
				x = scanner.nextDouble();
				if (scanner.hasNextDouble()){
					y = scanner.nextDouble();
					break;
				}
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		double amplitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (amplitude < RADIUS) {
			System.out.println("Point (" + x + ", " + y + ") is in the circle");
		}
		else {
			System.out.println("Point (" + x + ", " + y + ") is not in the circle");
		}
		
	}
}
