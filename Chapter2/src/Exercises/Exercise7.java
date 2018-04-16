package Exercises;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
		
		long minutes;
		long days;
		long years;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number of minutes: ");
		while (true) {
			if (scanner.hasNextLong()) {
				minutes = scanner.nextLong();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		days = (int)minutes / (60 * 24);
		years = days / 365;
		
		System.out.println(minutes + " minutes is approximately " + years +
				" years and " + days + " days");
	}
}
