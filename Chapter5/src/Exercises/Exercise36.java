package Exercises;

import java.util.Scanner;

// I already used loops in 3.9
public class Exercise36 {

public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int inputIsbn;
		
		System.out.println("Enter the first 9 digits of an ISBN as integer: ");
		while(true) {
			if (scanner.hasNextInt()) {
				inputIsbn = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		int[] digits = new int[9];
		int checksum = 0;
		for (int i = 0; i < 9; i++) {
			digits[i] = (inputIsbn / (int)Math.round(Math.pow(10, 8 - i))) % 10;
			checksum += (i + 1) * digits[i];
		}
		checksum %= 11;

		StringBuilder fullISBN = new StringBuilder();
		for (int i = 0; i < 9; i ++) {
			if (digits[i] == 0)
				fullISBN.append(0);
			else
				fullISBN.append(digits[i]);
		}
		if (checksum >= 10)
			fullISBN.append('X');
		else
			fullISBN.append(checksum);
		
		System.out.println("The ISBN-10 number is " + fullISBN);		
	}	
}
