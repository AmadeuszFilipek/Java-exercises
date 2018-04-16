package Exercises;

import java.util.Scanner;

public class Exercise44 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number;
		
		System.out.print("Enter a short integer: ");
		while(true) {
			if (scanner.hasNextShort()) {
				number = scanner.nextShort();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		int quotient, remainder;
		quotient = number;
		StringBuilder bits = new StringBuilder();
		// >> is equal to divide by two operation
		for(int i = 0; i < 16; i++) {
			quotient = (number >> i);
			remainder = quotient & 1;
			bits.append(remainder);
		}
		bits.reverse();
		System.out.println("The bits are " + bits.toString());
		
		
	}
}
