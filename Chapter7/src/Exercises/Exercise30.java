package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of values: ");
		int length = scanner.nextInt();
		System.out.print("Enter the values: ");
		int[] values = readIntegers(scanner, length);
		
		if (isConsecutiveFour(values))
			System.out.println("The list has consecutive fours");
		else
			System.out.println("THe list has no consecutive fours");

	}
	
	public static boolean isConsecutiveFour(int[] values) {
		boolean[] flags = new boolean[3];
		boolean result;
		
		for(int i = 0; i < values.length - 3; i++) {
			
			Arrays.fill(flags, false);
			for(int j = 0; j < flags.length; j++) {
				if (values[i] == values[i + j + 1]) {
					flags[j] = true;
				}
				else break;
			}
			
			result = true;
			for (int j = 0; j < flags.length; j++) {
				result &= flags[j];
			}
			
			if (result)
				return true;	
		}
		
		return false;
		
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
