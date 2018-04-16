package Exercises;

import java.util.Scanner;

public class Exercise9 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a character: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		if (input.length() > 0) {
			char character = input.charAt(0);
			int code = (int)input.charAt(0); 
			System.out.println("The Unicode for the character " + character
					+ " is " + code);
		}
		else {
			System.out.println("Wrong input");
			System.exit(1);
		}
	}	
}
