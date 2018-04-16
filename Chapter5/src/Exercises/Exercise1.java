package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		int input;
		Scanner scanner = new Scanner(System.in);
		int positives = 0, negatives = 0;
		int total = 0;
		
		System.out.println("Enter integers, input ends with 0 : ");
		while(true) {
			if (scanner.hasNextInt()){
				input = scanner.nextInt();
				total += input;
				if (input < 0)
					negatives++;
				else if (input == 0)
					break;
				else
					positives++;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		System.out.printf("The number of positives is %d \n"
										+ "The number of negatives is %d \n"
										+ "The total is %d \n"
										+ "The average is %.2f \n",
	    positives,
	    negatives,
	    total,
	    total / (double)(positives + negatives)
			);
		
	}
}
