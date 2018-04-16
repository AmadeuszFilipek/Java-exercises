package Exercises;

import java.util.Scanner;

public class Exercise12 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number;
		System.out.print("Enter a three-digit integer: ");
		while(true)	{
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		if (isPalindrome(number)) {
			System.out.println(number + " is a palindrome");
		}
		else
			System.out.println(number + " is not a palindrome");
		
		
	}		
	private static boolean isPalindrome	(int number) {
		StringBuilder temp = new StringBuilder(Integer.toString(number));
		
		return Integer.toString(number).equals(temp.reverse().toString());
	}
}
