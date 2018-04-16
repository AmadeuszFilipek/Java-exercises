package Exercises;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double sidesNumber = 0, side = 0;
		System.out.print("Enter the number of sides:");
		while(true) {
			if (scanner.hasNextDouble()) {
				sidesNumber = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		System.out.print("Enter the side:");
		while(true) {
			if (scanner.hasNextDouble()) {
				side = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		double area = (sidesNumber * Math.pow(side, 2) /
				(4 * Math.tan(Math.PI / sidesNumber)));
		System.out.println("The area of the polygon is " + area);
	}
}
