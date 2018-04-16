package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the integers between 1 and 100: ");
		int[] integers = readIntegers(scanner);
		scanner.close();
		
		int[] occurences = occurence(integers);
		
		for(int i = 0; i < occurences.length; i++) {
			if (occurences[i] > 1)
				System.out.println((i + 1) + " occurs " + occurences[i] + " times");
			else if (occurences[i] == 1)
				System.out.println((i + 1) + " occurs " + occurences[i] + " time");			
		}
	}
	public static int[] occurence(int[] numbers) {
		// no duplicate occurrence value needed... maybe that is why i hold for 1 to 100...sure
		int[] occurence = new int[100];
		Arrays.fill(occurence, 0);
		
		for (int k = 0; k < occurence.length; k++) {
					
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == (k + 1))
					occurence[k]++;
			}
		}
		
		return occurence;
	}
	public static int[] readIntegers(Scanner scanner) {
		
		int bufferSize = 50;
		int[] integers = new int[bufferSize];
		int count = 0;
		int temp;
		
		while(true) {
			if (scanner.hasNextInt()) {
				
				temp = scanner.nextInt();
				if (temp == 0)
					break;
				if (temp < 1 || temp > 100)
					continue;
				integers[count] = temp;
				count++;
				if (count >= 50) 
					break;
				
			}
			else scanner.next();
		}
		
		int[] result = new int[count];
		
		for(int i = 0; i < count; i++) {
			result[i] = integers[i];
		}
		
		return result;	
	}
}
