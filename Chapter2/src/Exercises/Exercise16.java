package Exercises;

import java.util.Scanner;

public class Exercise16 {
	
	public static void main(String[] args) {
		
		double side, area;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the side: ");
		while (true) {
			if (scanner.hasNextDouble()) {
				side = scanner.nextDouble();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		area = 3 / 2. * Math.sqrt(3) * Math.pow(side, 2);
		
		System.out.println("The area of the hexagon is " + area);
		
	}
}
