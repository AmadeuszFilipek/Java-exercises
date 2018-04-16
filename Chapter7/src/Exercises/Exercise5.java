package Exercises;

import java.util.Scanner;


public class Exercise5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		int[] distinctNumbers = readDistinctNumbers(scanner);
		int numberOfDistincts = 0;
		
		System.out.print("The distinct numbers are: ");
		for (int i = 0; i < distinctNumbers.length; i++) {
			if (distinctNumbers[i] != 0) {
				numberOfDistincts++;
				System.out.print(distinctNumbers[i] + " ");
			}
		}
		System.out.println("\nThe number of distinct numbers is " + numberOfDistincts);
		
	}
	
	public static int[]	readDistinctNumbers(Scanner scanner) {
		
		int numberOfInputs = 10;
		int[] distinctNumbers = new int[numberOfInputs];
		int count = 0;
		int temp;
		
		while(true) {
			if (scanner.hasNextInt()) {
				temp = scanner.nextInt();
				if (!alreadyContains(distinctNumbers, temp)) {
					distinctNumbers[count] = temp;
				}
				count++;
				if (count >= numberOfInputs)
					break;
			}
			else scanner.next();
		}
		
		return distinctNumbers;
	}
	
	public static boolean alreadyContains(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number)
				return true;
		}
		return false;
	}
}
