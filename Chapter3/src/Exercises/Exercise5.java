package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		
		int todayDay, elapsedDays;
		String todayName, futureDayName;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter today's day: ");
		while(true){
			if (scanner.hasNextInt()) {
				todayDay = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();
		}
		
		System.out.println("Enter the number of days elapsed since today: ");
		while(true){
			if (scanner.hasNextInt()) {
				elapsedDays = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(GregorianCalendar.DAY_OF_WEEK, todayDay);
		todayName = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK,
				GregorianCalendar.LONG_FORMAT, Locale.ENGLISH);
		calendar.set(GregorianCalendar.DAY_OF_WEEK, todayDay + elapsedDays);
		futureDayName = calendar.getDisplayName(GregorianCalendar.DAY_OF_WEEK,
				GregorianCalendar.LONG_FORMAT, Locale.ENGLISH);
		
		System.out.println("Today is " + todayName +
				" and the future day is " + futureDayName);
	}
}
