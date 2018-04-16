package Exercises;

import java.util.Scanner;

public class Exercise6 {
	public static void main(String[] args) {
		int integer;
		int digitSum;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number between 0 and 1000: ");
		
		while (true) {
			if (scanner.hasNextInt()) {
				integer = scanner.nextInt();
				if (integer > 0 && integer < 1000)
					break;
			}
			else 
				scanner.nextLine();
		}
		
		scanner.close();
		
		// between 0 and 1000
		digitSum = integer % 10 + (integer / 10) % 10 + (integer / 100) % 10;

		System.out.println("The sum of it's digits is: " + digitSum);
		
	}
}