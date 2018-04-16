package Exercises;

import java.util.Scanner;

public class Exercise37 {

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
		
		StringBuilder binaryInteger = new StringBuilder();
		
		// int is 32 - bit long
		for(int i = 31; i >= 0; i--) {
			if (number <= Math.round(Math.pow(2, i + 1)) &&
					number >= Math.round(Math.pow(2, i))) {
				binaryInteger.append(1);
				number -= Math.round(Math.pow(2, i));
			}
			else 
				binaryInteger.append(0);
			
		}
		
		System.out.println("It's binary code is following: ");
		System.out.println(binaryInteger.toString());
	}
}
