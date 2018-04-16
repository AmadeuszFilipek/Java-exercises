package Exercises;

import java.util.GregorianCalendar;
import java.util.Locale;
public class Exercise4 {

	public static void main(String[] args) {
		
		String monthName;
		int monthNumber = (int)Math.ceil(Math.random() * 12);
		// -1 because in Calendar months are numerated from 0
		GregorianCalendar calendar = new GregorianCalendar(1970, monthNumber -1, 1);

		monthName = calendar.getDisplayName(GregorianCalendar.MONTH,
									GregorianCalendar.LONG_FORMAT, Locale.ENGLISH);
	
		System.out.println(monthName);
	}
}
