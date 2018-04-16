package Exercises;

public class Exercise12 {

	public static void main(String[] args) {
		double miles = 24;
		double hours = 1;
		double minutes = 40;
		double seconds = 35;
		
		double averageSpeedInKmPerHour = miles * 1.6 / 
				(hours + minutes / 60 + seconds / 3600); 
		
		System.out.println("Average speed in [km/h] is: " + averageSpeedInKmPerHour);
	}
}
