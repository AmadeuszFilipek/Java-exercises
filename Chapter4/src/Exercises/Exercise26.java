package Exercises;

//rewrite listing 2.10
import java.util.Scanner;

public class Exercise26 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Receive the amount
		System.out.print(
				"Enter an amount in double, for example 11.56: ");
		String amount = input.next();
		input.close();
		
		// lets parse the input
		if (!amount.matches("\\d+.\\d+")) {
			System.out.println("Wrong input");
		  System.exit(1);
		}
		int dotIndex = amount.indexOf('.');
		
		
		
		// here was the conversion which could cause a loss of accuracy
		//int remainingAmount = (int)(amount * 100);

		// Find the number of one dollars, parsing is save because we checked it already
		int numberOfOneDollars = Integer.parseInt(amount.substring(0, dotIndex));
		int remainingAmount = Integer.parseInt(amount.substring(dotIndex + 1, amount.length()));

		// Find the number of quarters in the remaining amount
		int numberOfQuarters = remainingAmount / 25;
		remainingAmount = remainingAmount % 25;

		// Find the number of dimes in the remaining amount
		int numberOfDimes = remainingAmount / 10;
		remainingAmount = remainingAmount % 10;

		// Find the number of nickels in the remaining amount
		int numberOfNickels = remainingAmount / 5;
		remainingAmount = remainingAmount % 5;

		// Find the number of pennies in the remaining amount
		int numberOfPennies = remainingAmount;

		// Display results
		System.out.println("Your amount " + amount + " consists of");
		System.out.println(" " + numberOfOneDollars + " dollars");
		System.out.println(" " + numberOfQuarters + " quarters ");
		System.out.println(" " + numberOfDimes + " dimes");
		System.out.println(" " + numberOfNickels + " nickels");
		System.out.println(" " + numberOfPennies + " pennies");
	}
}