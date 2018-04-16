package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercise28 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int year = 0;
		int day = 0;
		
		System.out.print("Enter a year: ");
		while(true) {
			if (scanner.hasNextInt()) {
				year = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		
		System.out.print("Enter a number of first day of year in a week (1-7): ");
		while(true) {
			if (scanner.hasNextInt()) {
				day = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		// note day_of_week 0 is equal to Saturday
		GregorianCalendar calendar = new GregorianCalendar(year, 0, day);
		String dayName;
		String monthName;
		for (int i = 1; i <= 12; i++) {
		
			monthName = calendar.getDisplayName(GregorianCalendar.MONTH, 
					GregorianCalendar.LONG, Locale.ENGLISH);
		
			dayName = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK, 
				GregorianCalendar.LONG, Locale.ENGLISH);
		
			System.out.println(monthName + " 1, " + year + " is " + dayName);
			
			calendar.set(GregorianCalendar.MONTH, calendar.get(GregorianCalendar.MONTH) + 1);
		}
	}
}
