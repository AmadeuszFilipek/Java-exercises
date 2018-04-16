package Exercises;

import java.util.GregorianCalendar;

public class Exercise16 {

	public static void main(String[] args) {
		
		System.out.println("Year\tDays");
		for (int year = 2000; year < 2020; year++) {
			System.out.printf("%d\t%d\n", 
					year, numberOfDaysInAYear(year));
			
		}
		
		
	}
	
	public static int numberOfDaysInAYear(int year) {
		
		GregorianCalendar calendar = new GregorianCalendar(year, 0, 0);
		
		return calendar.getActualMaximum((GregorianCalendar.DAY_OF_YEAR));
	}
}
