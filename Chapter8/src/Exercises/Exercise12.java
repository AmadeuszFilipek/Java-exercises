package Exercises;

import java.util.Scanner;

public class Exercise12 {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		// Prompt the user to enter filing status
		System.out.print("(0-single filer, 1-married jointly or " +
				"qualifying widow(er), 2-married separately, 3-head of " +
				"household) Enter the filing status: ");

		int status = input.nextInt();

		// Prompt the user to enter taxable income
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();
		input.close();
		
		double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
		
		// simply change all the numbers with this table references...
		int[][] brackets = {
				{8350, 33950, 82250, 171550, 372950}, // Single filer
				{16700, 67900, 137050, 20885, 372950}, // Married jointly -or qualifying widow(er)
				{8350, 33950, 68525, 104425, 186475}, // Married separately
				{11950, 45500, 117450, 190200, 372950} // Head of household
				};

		
		// Compute tax
		double tax = 0;

		if (status == 0) { // Compute tax for single filers
			if (income <= brackets[0][0])
				tax = income * 0.10;
			else if (income <= brackets[0][1])
				tax = 8350 * 0.10 + (income - 8350) * 0.15;
			else if (income <= brackets[0][2])
				tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
				(income - 33950) * 0.25;
			else if (income <= brackets[0][3])
				tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
				(82250 - 33950) * 0.25 + (income - 82250) * 0.28;
			else if (income <= brackets[0][4])
				tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
				(82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
				(income - 171550) * 0.33;
			else
				tax = brackets[0][0] * rates[0] +
				(brackets[0][1] - brackets[0][0]) * rates[1] +
				(brackets[0][2] - brackets[0][1]) * rates[2] +
				(brackets[0][3] - brackets[0][2]) * rates[3] +
				(brackets[0][4] - brackets[0][3]) * rates[4] +
				(income - brackets[0][4]) * rates[5];
		}
		else if (status == 1) { // Left as an exercise
			// Compute tax for married file jointly or qualifying widow(er)
		}
		else if (status == 2) { // Compute tax for married separately
			// Left as an exercise
		}
		else if (status == 3) { // Compute tax for head of household
			// Left as an exercise
		}
		else {
			System.out.println("Error: invalid status");
			System.exit(1);
		}

		// Display the result
		System.out.println("Tax is " + (int)(tax * 100) / 100.0);
	}
}