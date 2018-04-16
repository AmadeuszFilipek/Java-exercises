package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Exercise24 {

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
			 GregorianCalendar.LONG, Locale.ENGLISH);
	 String day = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK,
			 GregorianCalendar.LONG, Locale.ENGLISH);
	 // Display results
	 System.out.println("Current date is " + day + " " + month + " " + year);
	 System.out.println("Current time is " + currentHour + ":"
			 + currentMinute + ":" + currentSecond + " GMT");
	 }
}
