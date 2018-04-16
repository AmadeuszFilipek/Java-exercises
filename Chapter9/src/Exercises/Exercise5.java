package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Exercise5 {

	public static void main(String[] args) {
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		int year = calendar.get(GregorianCalendar.YEAR);
		String month = calendar.getDisplayName(GregorianCalendar.MONTH,
				GregorianCalendar.LONG, Locale.ENGLISH);
		String day = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK,
				GregorianCalendar.LONG, Locale.ENGLISH);
		
		System.out.println(day + " " + month + " " + year);
		
		calendar.setTimeInMillis(1234567898765L);
		
		year = calendar.get(GregorianCalendar.YEAR);
		month = calendar.getDisplayName(GregorianCalendar.MONTH,
				GregorianCalendar.LONG, Locale.ENGLISH);
		day = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK,
				GregorianCalendar.LONG, Locale.ENGLISH);
		
		System.out.println(day + " " + month + " " + year);
		
	}
}
