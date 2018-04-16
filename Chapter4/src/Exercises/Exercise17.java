package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String monthInput;
		int year;
		
		System.out.print("Enter a year: ");
		while(true) {
			if (scanner.hasNextInt()) {
				year = scanner.nextInt();
				break;
			}
			else scanner.nextLine();
		}
		
		System.out.print("Enter a month: ");
		while(true) {
			if (scanner.hasNext()) {
				monthInput = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		int daysInMonth = 0;
		boolean correctMonth = false;
		
		// i leave that for further use, but that was not necessary
		//if (yearInput.matches("\\d+"))
		//	year = Integer.parseInt(yearInput);
	
		GregorianCalendar calendar = new GregorianCalendar();
		Map<String, Integer> monthsMap = calendar.getDisplayNames(
				GregorianCalendar.MONTH, GregorianCalendar.SHORT, Locale.ENGLISH);
	
		for (String monthName : monthsMap.keySet()) {
			if (monthInput.equals(monthName)) {
				calendar.set(GregorianCalendar.MONTH, monthsMap.get(monthInput));
				correctMonth = true;
				break;
			}
		}
		if (correctMonth) {
			calendar.set(GregorianCalendar.YEAR, year);
			daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			System.out.println(monthInput + " " + year + " has " + daysInMonth + " days");
		}
		else 
			System.out.println("Wrong month input");

	}
}
