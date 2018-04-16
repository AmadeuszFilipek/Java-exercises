package Exercises;

import java.util.Scanner;

public class Exercise2 {
	
	public static void main(String[] args) {
		
		double radius = 0;
		double length = 0;
		double volume = 0;
		double area = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the radius and the length of a cylinder: ");

		while (true) {
			if (scanner.hasNextDouble()) {
				radius = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					length = scanner.nextDouble();
					break;
				}
			}
			else
				scanner.nextLine();
		}
		
		scanner.close();
		
		area = radius * radius * Math.PI;
		volume = area * length;
		
		System.out.println("The area is: " + area);
		System.out.println("The volume is: " + volume);
		
		
	}
}
