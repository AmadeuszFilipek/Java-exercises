package Exercises;

import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
	
		double[] point1, point2, point3;
		double s, side1, side2, side3, area;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first point for a triangle: ");
		point1 = scanDouble(scanner);
		System.out.println("Enter second point for a triangle: ");
		point2 = scanDouble(scanner);
		System.out.println("Enter third point for a triangle: ");
		point3 = scanDouble(scanner);
		side1 = side(point1, point2);
		side2 = side(point2, point3);
		side3 = side(point3, point1);
		s = (side1 + side2 + side3) / 2;
		area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		System.out.println("The area of the triangle is " + area);	
	}
	private static double side(double[] point1, double[] point2) {
		return Math.sqrt(Math.pow(point1[0] - point2[0], 2) +
				Math.pow(point1[1] - point2[1], 2));
	}
	
	private static double[] scanDouble(Scanner scanner) {
		double[] temp = new double[2];
		while (true) {
			if (scanner.hasNextDouble()) {
				 temp[0] = scanner.nextDouble();
				 if (scanner.hasNextDouble()) {
					 temp[1] = scanner.nextDouble();
					 return temp;
				 }
			}
			else
				scanner.nextLine();	
		}
	}
}
