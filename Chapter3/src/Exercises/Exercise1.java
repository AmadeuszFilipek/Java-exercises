package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double a, b, c, discriminant, root1, root2;
		System.out.println("Enter a, b, c: ");
		while (true) {
			if (scanner.hasNextDouble()) {
				a = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					b = scanner.nextDouble();
					if (scanner.hasNextDouble()) {
						c = scanner.nextDouble();
						break;
					}
				}
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		discriminant = b * b - 4 * a * c;
		if (discriminant < 0) {
			System.out.println("The equation has no real roots");
		}
		else if (Math.abs(discriminant) < Math.pow(10, -8)) { // the problem of floating accuracy
			root1 = -b / (2 * a);
			System.out.println("The equation has one second order root " + root1);
		}
		else {
			root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			root2 = (-b - Math.sqrt(discriminant)) / (2 * a); 
			System.out.println("The equation has two roots " + root1 + " and " + root2);
		}	
	}
}
