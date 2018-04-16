package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercise29 {
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
		
		System.out.print("Enter a number of first day of year in a week (1-7):");
		while(true) {
			if (scanner.hasNextInt()) {
				day = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		//saturday = 7 Sunday = 1
		GregorianCalendar calendar = new GregorianCalendar(year, 0, day);
		String monthName;
		int dayNumber;
		int daysInMonth;
		String[] shortDayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		for (int i = 1; i <= 12; i++) {
			dayNumber = calendar.get(GregorianCalendar.DAY_OF_WEEK);
			daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			
			monthName = calendar.getDisplayName(GregorianCalendar.MONTH, 
					GregorianCalendar.LONG, Locale.ENGLISH);
			
			System.out.println("\t\t\t" + monthName);
			System.out.println("____________________________________________________");
			
			for (int j = 0; j < shortDayNames.length; j++)
				System.out.print(shortDayNames[j] + "\t");
						
			System.out.println("\n");
			
			// blank days before the first day of the month
			//if (dayNumber % 7 != 0)
				for(int j = 1; j < dayNumber; j++) 
					System.out.print("\t");
			
			// fill the day numbers in a month
			for(int j = 1; j <= daysInMonth; j++) {
				System.out.printf("%2d\t", j);
				if ((j + dayNumber - 1)% 7 == 0)
					System.out.print("\n");
			}
			System.out.println("\n");
			
			calendar.set(GregorianCalendar.MONTH, calendar.get(GregorianCalendar.MONTH) + 1);
		}
	}
}
