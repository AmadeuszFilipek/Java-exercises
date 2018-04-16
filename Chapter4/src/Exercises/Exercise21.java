package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String input;
		
		System.out.println("Enter a string: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		if (input.matches("\\d{3}+-\\d{2}+-\\d{4}+")) {
			System.out.println(input + " is a valid social security number");
		}
		else
			System.out.println(input + " is an invalid social security number");
		
	}
}
