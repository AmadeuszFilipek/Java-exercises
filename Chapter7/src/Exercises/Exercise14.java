package Exercises;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter five numbers: ");
		int[] numbers = readIntegers(scanner);
		
		System.out.println("The greatest common divisor is " + gcd(numbers));
	}

	public static int gcd(int... numbers) {
		int result = 1;
		boolean isDivisor = false;
		int min = min(numbers);
		
		for (int gcd = 2; gcd <= min; gcd++) {
			isDivisor = true;
			
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % gcd != 0)
					isDivisor = false;
			}
			
			if (isDivisor) {
				if (gcd > result);
				result = gcd;
			}
		}
		
		return result;
	}
	
	public static int min(int[] array) {
		int min = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}
	
	public static int[] readIntegers(Scanner scanner) {
		
		int[] numbers = new int[5];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[count] = scanner.nextInt();
				count++;
				if (count >= 5) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}