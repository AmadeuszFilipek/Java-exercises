package exercises;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Exercise4 {
	/** same as [5.29] */
	public static void main(String[] args) {

		if(args.length > 2) {
			System.out.println("Usage: month year or month or no arguments.");
			System.exit(1);
		}

		int year = 0;
		int month = 1;
		
		if (args.length == 2) {
			try {
				year = Integer.parseInt(args[1]);
				month = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e) {
				System.out.println("Error: input not a number.");
				System.exit(2);
			}
		}
		else if (args.length == 1) {
			try {
				month = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e) {
				System.out.println("Error: input not a number.");
				System.exit(2);
			}
		} 
		
		if(month > 12 || month < 1) {
			System.out.println("Invalid month value. month is in range [1, 12].");
			System.exit(3);	
		}
		
		try {
			printMonth(month - 1, year);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/** prints the month calendar for a given month of given year */
	public static void printMonth(int month, int year) throws Exception {
		
		if (month < 0 || month > 12)
			throw new Exception("Month out of range");
		if (year < 0)
			throw new Exception("Year cannot be negative.");
		
		//Saturday = 7 Sunday = 1
		GregorianCalendar calendar = new GregorianCalendar();
		String monthName;
		int dayNumber;
		int daysInMonth;
		String[] shortDayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		if (month != 0)
			calendar.set(GregorianCalendar.MONTH, month);
		
		if (year != 0)
			calendar.set(GregorianCalendar.YEAR, year);
		else
			year = calendar.get(GregorianCalendar.YEAR);
		
		dayNumber = calendar.get(GregorianCalendar.DAY_OF_WEEK);
		daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

		monthName = calendar.getDisplayName(GregorianCalendar.MONTH, 
				GregorianCalendar.LONG, Locale.ENGLISH);

		System.out.println("\t\t" + monthName + ", " + year);
		System.out.println("---------------------------------------------------");

		for (int j = 0; j < shortDayNames.length; j++)
			System.out.print(shortDayNames[j] + "\t");

		System.out.println("\n");

		// blank days before the first day of the month
		for(int j = 1; j < dayNumber; j++) 
			System.out.print("\t");

		// fill the day numbers in a month
		for(int j = 1; j <= daysInMonth; j++) {
			System.out.printf("%2d\t", j);
			if ((j + dayNumber - 1)% 7 == 0)
				System.out.print("\n");
		}
		System.out.println("\n");

	}
}
