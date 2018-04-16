package Exercises;

import java.util.Scanner;

public class Exercise16 {

	public static void main(String[] args) {
		
		// factorizing an integer number
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		while(true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else scanner.next();			
		}
		scanner.close();
		
		int factorialMultiplier = 2;
		int factoredBase = number;
		
		System.out.print("[");
		while(factoredBase > 1) {
		
			if (factoredBase % factorialMultiplier == 0) {
				System.out.printf("%d", factorialMultiplier);
				factoredBase = factoredBase / factorialMultiplier;
				if (factoredBase > 1)
					System.out.print(", ");
				else
					System.out.print("]\n");
			}
			else
				factorialMultiplier++;		
		}
	}
}
