package Exercises;

import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string and a character: ");
		String input = scanner.next();
		char c = scanner.next().charAt(0);
		scanner.close();
		
		System.out.println("The number of occurences of " + c + " is " + count(input, c));
		
	}
	
	public static int count(String str, char a) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a)
				count++;
		}
		
		return count;
	}
}
