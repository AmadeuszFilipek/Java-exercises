package Exercises;

import java.util.Scanner;

// results are inconsistent with the sample runs in book, however
// i guess there should be no multiplications by '3' in the equation
public class Exercise47 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		int[] digits = new int[12];
		int checksum = 0;
		
		if (input.matches("\\d{12}+")) 
			for (int i = 0; i < 12; i++) {
				digits[i] = (int)input.charAt(i) + 48;
				if (i % 2 == 0) 
					checksum += digits[i];
				else
					checksum += 3 * digits[i];
			}
		else {
			System.out.println("Wrong input");
			System.exit(1);
		}
		
		checksum = 10 - checksum % 10;
		
		if (checksum == 10)
			input = input + "0";
		else
			input = input + checksum;
		
		System.out.println("The ISBN-13 number is " + input);
	}
}
