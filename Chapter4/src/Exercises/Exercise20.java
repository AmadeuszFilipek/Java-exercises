package Exercises;

import java.util.Scanner;

public class Exercise20 {

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
		
		
		System.out.println("The lengh of a string is: " + input.length());
		System.out.println("The first character of a string is: " + input.charAt(0));
		
	}
}
