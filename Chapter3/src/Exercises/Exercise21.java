package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int year, h, q, m, j, k;
		
		System.out.print("Enter year (e.g., 2012): ");
		year = scanInt(scanner);
		System.out.println("Enter month: ");
		m = scanInt(scanner);
		System.out.println("Enter the day of the month (1-31): ");
		q = scanInt(scanner);
		scanner.close();
		
		if (m == 1) {
			m = 13;
			year -= 1;
		}
		if (m == 2) {
			m = 14;
			year -= 1;
		}
		
		j = year / 100;
		k = year % 100;
		
		// Christian Zeller formula
		h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
		
		System.out.print("Day of the week is ");
		switch (h) {
		case 0: System.out.print("Saturday"); break;
		case 1: System.out.print("Sunday"); break;
		case 2: System.out.print("Monday"); break;
		case 3: System.out.print("Tuesday"); break;
		case 4: System.out.print("Wednesday"); break;
		case 5: System.out.print("Thursday"); break;
		case 6: System.out.print("Friday"); break;
		default: break;
		}
	}
	
	private static int scanInt(Scanner scanner) {
		while (true) {
			if (scanner.hasNextInt()) {
				return scanner.nextInt();
			}
			else
				scanner.nextLine();	
		}
	}
}
