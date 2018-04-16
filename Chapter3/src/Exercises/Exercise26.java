package Exercises;

import java.util.Scanner;

public class Exercise26 {
	
	public static void main (String[] args) {
		
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		while(true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		boolean divisibleByFive = number % 5 == 0;
		boolean divisibleBySix = number % 6 == 0;
		boolean divisibleByFiveAndSix = divisibleByFive && divisibleBySix;
		boolean divisibleByFiveOrSix = divisibleByFive || divisibleBySix;
		boolean divisibleByFiveXorSix = divisibleByFive ^ divisibleBySix;
		System.out.println("Is divisible by five and six ? " + divisibleByFiveAndSix);
		System.out.println("Is divisible by five or 6 ? " + divisibleByFiveOrSix);
		System.out.println("Is divisible by five or 6, but not both? " +
				divisibleByFiveXorSix);		
		
	}
}
