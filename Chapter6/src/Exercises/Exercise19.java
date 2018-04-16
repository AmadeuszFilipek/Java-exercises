package Exercises;

import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[] sides = new double[3];
		int i = 0;
		
		System.out.print("Enter three sides of a triangle: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				sides[i] = scanner.nextDouble();
				i++;
				if (i >= 3)
					break;
			}
			else {
				scanner.next();
				i = 0;
			}		
		}
		scanner.close();
		
		if (isValid(sides[0], sides[1], sides[2]))
			System.out.println("The area of triangle is : " + area(sides[0], sides[1], sides[2]));
		else
			System.out.println("The input is invalid");
		
	}
		
	//private class MyTriangle
		
		public static boolean isValid(double side1, double side2, double side3) {
			
			if (side1 + side2 > side3)
				if (side2 + side3 > side1)
					if (side3 + side1 > side2) 
						return true;
		
			return false;
		}
		
		public static double area (double side1, double side2, double side3) {
			double semiperimeter = (side1 + side2 + side3) / 2; 
			
			return Math.sqrt(semiperimeter *
					(semiperimeter - side1) *
					(semiperimeter - side2) *
					(semiperimeter - side3));
		}
	
	
}
