package Exercises;

import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int code;
		
		System.out.print("Enter an ASCII code: ");
		while(true) {
			if (scanner.hasNextInt()) {
				code = scanner.nextInt();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		char character = (char)code;
		System.out.println("The character for ASCII code 69 is " + character);
		
	}
}
