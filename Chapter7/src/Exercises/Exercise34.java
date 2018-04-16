package Exercises;

import java.util.Scanner;

public class Exercise34 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.next();
		scanner.close();
		System.out.println("After sorting: " + sort(input));
		
	}
	
	public static String sort(String s)	{
		// the idea is bubble sort
		StringBuilder result = new StringBuilder(s);
		char temp;
		for(int i = 0; i < result.length(); i++) {	
			for(int j = 0; j < result.length() - 1; j++){
				if (result.charAt(j) > result.charAt(j + 1)) {
					temp = result.charAt(j);
					result.setCharAt(j, result.charAt(j + 1));
					result.setCharAt(j + 1, temp);
				}
			}	
		}
		
		return result.toString();
	}
}
