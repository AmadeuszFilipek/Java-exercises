package Exercises;

import java.util.Scanner;

public class Exercise23 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double x, y;
		final double WIDTH = 10;
		final double HEIGHT = 5;
		
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
		

		if ((Math.abs(x) < WIDTH / 2) && (Math.abs(y) < HEIGHT / 2)) {
			System.out.println("Point (" + x + ", " + y + ") is in the rectangle");
		}
		else {
			System.out.println("Point (" + x + ", " + y + ") is not in the rectangle");
		}
		
	}
}
