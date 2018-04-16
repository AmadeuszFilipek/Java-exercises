package Exercises;

public class Exercise10 {

	public static void main(String[] args) {
		
		double distance = 14; //[km]
		double timeSeconds = 30 + 45 * 60; //[s]
		double averageSpeedInMilesPerHour = distance * 1.6 / (timeSeconds / 60 / 60);
		
		System.out.println("The average speed is: " + averageSpeedInMilesPerHour + 
				" [miles/h]");
		
		
	}
}
