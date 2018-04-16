package Exercises;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a letter grade: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		char c = input.charAt(0);
		int code = (int)c;
		int result = -1;
		
		if (code > 64 && code < 70) {
			result = 69 - code;
			System.out.println("The numeric value for grade " + c + " is " + result);
		}
		else 
			System.out.println(c + " is an invalid grade");
	}
}
