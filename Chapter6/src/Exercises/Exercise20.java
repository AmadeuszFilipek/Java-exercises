package Exercises;

import java.util.Scanner;

public class Exercise20 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
	  String input = scanner.nextLine();
	  scanner.close();
	  
	  System.out.println("The number of letters in this string is : " + countLetters(input));
		
		
	}
	
	public static int countLetters(String s) {
		int letters = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) 
				letters++;
		}
		return letters;
	}
}
