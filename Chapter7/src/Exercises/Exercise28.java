package Exercises;

import java.util.Scanner;

public class Exercise28 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ten integer numbers: ");
		int[] numbers = readIntegers(scanner, 10);
		
		System.out.println("All combinations of picking two numbers from numbers above.");
		displayCombinations(numbers);
	}
	
	public static void displayCombinations(int[] numbers) {
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				System.out.println(numbers[i] + " " + numbers[j]);
			}
		}	
	}
	
	public static int[] readIntegers(Scanner scanner, int readNumber) {
		
		int[] numbers = new int[readNumber];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[count] = scanner.nextInt();
				count++;
				if (count >= readNumber) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
