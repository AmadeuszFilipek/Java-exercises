package Exercises;

import java.util.Scanner;

public class Exercise18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the password: ");
		String password = scanner.next();
		scanner.close();
		
		if (checkPassword(password))
			System.out.println("Valid password");
		else
			System.out.println("Invalid Password");
	
	}
	
	public static boolean checkPassword(String password) {
		
		return checkPasswordLength(password) &
					 checkPasswordComposition(password) &
					 checkPasswordDigits(password);
	}
	
	private static boolean checkPasswordLength (String password) {
		
		return password.length() >= 8;
	}
	
	private static boolean checkPasswordComposition (String password) {
		boolean result = true;
		for (int i = 0; i < password.length(); i++) {
			result &= Character.isLetterOrDigit(password.charAt(i));
		}
		return result;
	}
	
	private static boolean checkPasswordDigits (String password) {
		int digits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				digits++;
		}
		return (digits >= 2);
	}
}
