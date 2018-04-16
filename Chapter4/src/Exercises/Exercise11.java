package Exercises;

import java.util.Scanner;

public class Exercise11 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input;
		
		System.out.print("Enter a decimal value(0 to 15): ");
		while(true) {
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
	
		if (input > 0 && input < 16)
			System.out.println("The hex value is: " + Integer.toHexString(input));
		else
			System.out.println(input + " is an invalid input");
	}
}
