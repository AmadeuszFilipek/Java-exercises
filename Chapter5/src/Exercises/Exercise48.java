package Exercises;

import java.util.Scanner;

public class Exercise48 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println("characters at odd positions: ");
		
		for (int i = 0; i < input.length(); i++) {
			if ((i & 1) == 0) // this is so not readable 
			System.out.print(input.charAt(i));
		}
		
	}
}
