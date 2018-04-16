package Exercises;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double side;
		System.out.print("Enter the side:");
		while(true) {
			if (scanner.hasNextDouble()) {
				side = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		double area = (6 * Math.pow(side, 2) / (4 * Math.tan(Math.PI / 6)));
		System.out.printf("The area of the hexagon is %.2f", area);
	}
}
