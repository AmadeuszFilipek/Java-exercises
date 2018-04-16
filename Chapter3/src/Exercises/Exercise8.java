package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[3];
		
		System.out.println("Enter three integer numbers: ");
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[0] = scanner.nextInt();
				if (scanner.hasNextInt()) {
					numbers[1] = scanner.nextInt();
					if (scanner.hasNextInt()) {
						numbers[2] = scanner.nextInt();
						break;
					}
				}
			}
			else
				scanner.nextLine();		
		}
		scanner.close();
		// increasing order
		Arrays.sort(numbers);

		System.out.println(Arrays.toString(numbers));

	}
}
