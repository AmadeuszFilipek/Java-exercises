package Exercises;

import java.util.Scanner;

public class Exercise15 {

	public static void main(String[] args) {
		
		double x1, y1, x2, y2, distance;
		double[] temp;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter x1 and y1: ");
		temp = scanDouble(scanner);
		x1 = temp[0];
		y1 = temp[1];
		System.out.println("Enter x2 and y2: ");
		temp = scanDouble(scanner);
		x2 = temp[0];
		y2 = temp[1];
		
		distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		System.out.println("The distance between the two points is " + distance);
	
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
