package Exercises;

import java.util.Scanner;

public class Exercise35 {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double side = scanner.nextDouble();
		scanner.close();
		
		System.out.println("The area of a pentagon is " + area(side));
		
		
	}
	
	public static double area(double side) {
		
		return 5 * side * side / ( 4 * Math.tan(Math.PI / 5));
	}
}
