package Exercises;

import java.util.Scanner;

public class Exercise50 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		int numberOfUppercase = 0;
		
		// the same could be implemented with using the ASCII table
		// knowing the starting number of char A 
		// or by applying regular expression [A-Z]
		for (int i = 0; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i)))
				numberOfUppercase++;
		}
		
		System.out.println("The number of uppercase letters is " + numberOfUppercase);
	}
}
