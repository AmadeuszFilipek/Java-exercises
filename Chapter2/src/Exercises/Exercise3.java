package Exercises;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		
		double feet = 0;
		double meters = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a value for feet: ");
		
		while (true) {
			if (scanner.hasNextDouble()) {
				feet = scanner.nextDouble();
				break;
			}
			else 
				scanner.nextLine();
		}
		
		scanner.close();
		
		meters = feet * 0.305;
		System.out.println(feet + " feet is " + meters + " meters");
		
	}
}
