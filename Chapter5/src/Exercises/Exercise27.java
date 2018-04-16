package Exercises;

import java.util.GregorianCalendar;

public class Exercise27 {

	public static void main(String[] args) {
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		int numberOfLeapYears = 0;
		
		for (int i = 101; i <= 2100; i++) {
			
			if (calendar.isLeapYear(i)) {
				numberOfLeapYears++;
				System.out.print(i + " ");
				if (numberOfLeapYears % 10 == 0)
					System.out.println();
					
			}
		
		
		}
	}
}
