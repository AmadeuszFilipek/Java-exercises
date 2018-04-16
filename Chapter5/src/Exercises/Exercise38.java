package Exercises;

import java.util.Scanner;

public class Exercise38 {

public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number;
		
		System.out.print("Enter a decimal integer: ");
		while(true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		StringBuilder octalInteger = new StringBuilder();
		int value;

		for(int i = 10; i >= 0; i--) {
			if (number <= Math.round(Math.pow(8, i + 1)) &&
					number >= Math.round(Math.pow(8, i))) {
				value = (int)(number / Math.round(Math.pow(8, i)));
				octalInteger.append(value);
				number -= value * Math.round(Math.pow(8, i));
			}
			else 
				octalInteger.append(0);
			
		}
		
		System.out.println("It's octal code is following: ");
		System.out.println(octalInteger.toString());
	}
}
