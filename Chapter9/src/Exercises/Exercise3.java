package Exercises;

import java.util.Date;

public class Exercise3 {

	public static void main(String[] main) {
		
		Date date = new Date();

		for(long i = 1000; i < 100000000000L; i *= 10) {
			date.setTime(i);
			System.out.println(date.toString());
		}
	}
}
