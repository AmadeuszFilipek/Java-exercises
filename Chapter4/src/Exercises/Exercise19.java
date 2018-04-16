package Exercises;

import java.util.Scanner;

public class Exercise19 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String inputIsbn;
		
		System.out.println("Enter the first 9 digits of an ISBN: ");
		while(true) {
			if (scanner.hasNext()) {
				inputIsbn = scanner.next();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();

		int[] digits = new int[9];
		int checksum = 0;
		
		if (inputIsbn.matches("\\d{9}+")) 
			for (int i = 0; i < 9; i++) {
				digits[i] = (int)inputIsbn.charAt(i) + 48;
				checksum += (i + 1) * digits[i];
			}
		else {
			System.out.println("Wrong input");
			System.exit(1);
		}
		checksum %= 11;

		StringBuilder fullISBN = new StringBuilder(inputIsbn);
		if (checksum >= 10)
			fullISBN.append('X');
		else
			fullISBN.append(checksum);
		
		System.out.println("The ISBN-10 number is " + fullISBN);		
	}	
}
