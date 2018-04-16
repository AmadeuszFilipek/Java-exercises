package Exercises;

import java.util.Scanner;

public class Exercise8 {
	public static void main(String[] args) {
		
		long totalMiliseconds = System.currentTimeMillis();
		long totalSeconds = totalMiliseconds / 1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
				
		int offset;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the time zone offset to GMT: ");
		while (true) {
			if (scanner.hasNextInt()) {
				offset = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();

		totalHours += offset;
		currentHour = totalHours % 24;
		
		System.out.println("Current time is " + currentHour + ":" + 
				currentMinute + ":" + currentSecond + " GMT");
	}
}

