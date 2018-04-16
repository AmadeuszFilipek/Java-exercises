package Exercises;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int guess;
		System.out.print("HEAD (1) or TAIL (0) ?! ");
		while (true) {
			if (scanner.hasNextInt()) {
				guess = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();	
		}
		scanner.close();
		
		if (guess != 0 && guess != 1) {
			System.out.println("Wrong input.");
			System.exit(1);
		}
		
		int result = (int)Math.round(Math.random());
		
		if (guess == result) {
			System.out.println(result + " You win");
		}
		else
			System.out.println(result + " You lose");
	}
}
