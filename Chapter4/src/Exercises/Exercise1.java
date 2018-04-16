package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double radius;
		
		System.out.print("Enter the length from the center to a vertex: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				radius = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		double side = 2 * radius * Math.sin(Math.PI / 5);
		double area = 5 * Math.pow(side, 2) / (4 * Math.tan(Math.PI / 5));
		
		System.out.printf("The are of the pentagon is %.2f", area);
		
	}
}
