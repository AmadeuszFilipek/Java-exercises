package Exercises;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int inputNumber = 0;
		
		System.out.print("Enter a integer number: ");
		while(true) {
			if (scanner.hasNextInt()) {
				inputNumber = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		System.out.println("The number is palindrome - " + isPalindrome(inputNumber));
	}
	
	public static int reverse(int number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		return Integer.parseInt(temp.toString());
		
	}
	public static boolean isPalindrome(int number) {
		
		return number == reverse(number);
	}
}
