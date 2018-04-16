package Exercises;

public class Exercise25 {

	
	public static String convertMillis(long millis) {
		
		StringBuilder output = new StringBuilder();
		
		 long totalSeconds = millis / 1000;
		
		 long currentSecond = totalSeconds % 60;
		
		 long totalMinutes = totalSeconds / 60;
		
		 long currentMinute = totalMinutes % 60;
		
		 long totalHours = totalMinutes / 60;
		
		 long currentHour = totalHours % 24;
		
		 output.append(currentHour).append(':').append(currentMinute)
		 			 .append(':').append(currentSecond);
		 
		 return output.toString();
	}
}
