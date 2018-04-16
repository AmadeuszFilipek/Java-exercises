package Exercises;

import java.util.Scanner;

public class Exercise25 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double a, b, c;
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
		
		double[] eqn = {a, b, c};
		double[] roots = new double[2];
		solveQuadratic(eqn, roots);
	}
	
	public static int solveQuadratic(double[] eqn, double[] roots) {
		double a = eqn[0];
		double b = eqn[1];
		double c = eqn[2];
		double discriminant = b * b - 4 * a * c;
		if (discriminant < 0) {
			System.out.println("The equation has no real roots");
			return 0;	
		}
		else if (Math.abs(discriminant) < Math.pow(10, -8)) { // the problem of floating accuracy
			roots[0] = -b / (2 * a);
			System.out.println("The equation has one second order root " + roots[0]);
			return 1;
		}
		else {
			roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
			roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a); 
			System.out.println("The equation has two roots " + roots[0] + " and " + roots[1]);
			return 2;
		}
	}
}
