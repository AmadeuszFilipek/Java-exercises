package Exercises;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long inputNumber = 0;
		
		System.out.print("Enter a integer: ");
		while(true) {
			if (scanner.hasNextLong()) {
				inputNumber = scanner.nextLong();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		System.out.println("The sum of it's digits is equal to: " + sumDigits(inputNumber));
		
	}
	
	public static int sumDigits(long n) {
		
		long extractedDigit;
		int digitSum = 0;
		long remainingNumber = n;
		int i = 0;
		while(remainingNumber > 0) {
			remainingNumber = n / (int)(Math.round(Math.pow(10, i)));
			extractedDigit = remainingNumber % 10;
			digitSum += extractedDigit;
			i++;
		}
		
		return (int)digitSum;
	}
}
