package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Exercise33 {

	public static void main(String[] args) {
		
		displayCurrentDateTime();
		
		
	}
	
	public static void displayCurrentDateTime() {
		
		 // Obtain the total milliseconds since midnight, Jan 1, 1970
		 long totalMilliseconds = System.currentTimeMillis();
		
		
		 // Obtain the total seconds since midnight, Jan 1, 1970
		 long totalSeconds = totalMilliseconds / 1000;
		
		// Compute the current second in the minute in the hour
		 long currentSecond = totalSeconds % 60;
		
		 // Obtain the total minutes
		 long totalMinutes = totalSeconds / 60;
		
		 // Compute the current minute in the hour
		 long currentMinute = totalMinutes % 60;
		
		 // Obtain the total hours
		 long totalHours = totalMinutes / 60;
		
		 // Compute the current hour
		 long currentHour = totalHours % 24;
		
		 GregorianCalendar calendar = new GregorianCalendar();
		 calendar.setTimeInMillis(totalMilliseconds);
		 
		 int year = calendar.get(GregorianCalendar.YEAR);
		 String month = calendar.getDisplayName(GregorianCalendar.MONTH, 
				 GregorianCalendar.SHORT, Locale.ENGLISH);
		 int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		 // Display results
		 System.out.print("Current date and time is " + month + " " + day + ", " + year);
		 System.out.println(" " + currentHour + ":"
				 + currentMinute + ":" + currentSecond + " GMT");
		 }
}
