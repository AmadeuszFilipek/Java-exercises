package Exercises;

public class Exercise11 {

	public static void main(String[] args) {
		
		int population = 312032486;
		int birthRate = 7;
		int deathRate = 13;
		int immigrantRate = 45;
		int seconds = 1;
  	int year = 0;
  	
		while (seconds < 60 * 60 * 24 * 365 * 5 + 1) { // + 1 for the next year to trigger
			if (seconds % birthRate == 0)
				population += 1;
			if (seconds % deathRate == 0)
				population -= 1;
			if (seconds % immigrantRate == 0)
				population += 1;
			
			if (seconds % (60 * 60 * 24 * 365) == 0) {
				year += 1;
				System.out.println("Current population for year " + year + " is: " + 
						+ population);
			}
			seconds += 1;
		}	
	}
}
