package Exercises;

import java.util.Scanner;

public class Exercise46 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		StringBuilder input = new StringBuilder(scanner.nextLine());
		scanner.close();
		// the easier way
		input.reverse();
		// the implement-by-yourself way
		// for (int i = input.length - 1; i >= 0; i--) {
		// 	newstring.add(input.at(i));
		
		System.out.println("The reversed string is: " + input.toString());
	}
}
