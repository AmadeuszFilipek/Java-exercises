package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercise11 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int month, year;
		
		System.out.print("Enter a month and a year: ");
		while(true){
			if (scanner.hasNextInt()) {
				month = scanner.nextInt();
				if (scanner.hasNextInt()) {
					year = scanner.nextInt();
					break;
				}
			}
			else 
				scanner.nextLine();
		}
		scanner.close();

		GregorianCalendar calendar = new GregorianCalendar(year, month, 0);
		String monthName = calendar.getDisplayName(GregorianCalendar.MONTH,
				GregorianCalendar.LONG_FORMAT, Locale.ENGLISH);
		int daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	
		System.out.println(monthName + " " + year + " had " + daysInMonth + " days.");
		
	}
}
