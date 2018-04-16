package Exercises;

import java.util.Scanner;

public class Exercise36 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of sides: ");
		int n = scanner.nextInt();
		System.out.print("Enter the side: ");
		double side = scanner.nextDouble();
		scanner.close();
		
		System.out.println("The area of the polygon is " + area(n, side));
	}
	
	public static double area(int n, double side) {
		
		return n * side * side / ( 4 * Math.tan(Math.PI / n));
		
	}
}
