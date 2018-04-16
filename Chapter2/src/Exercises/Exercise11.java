package Exercises;

import java.util.Scanner;

public class Exercise11 {

	public static void main(String[] args) {
		int numberOfYears;
		int population = 312032486;
		int birthRate = 7;
		int deathRate = 13;
		int immigrantRate = 45;
		int seconds = 1;
  	int year = 0;
  	
  	Scanner scanner = new Scanner(System.in);
  	System.out.println("Enter the number of years: ");
  	while(true) {
  		if (scanner.hasNextInt()) {
  			numberOfYears = scanner.nextInt();
  			break;
  		}
  		else 
  			scanner.nextLine();
  	}
  	scanner.close();
  	
		while (seconds < 60 * 60 * 24 * 365 * numberOfYears + 1) { // + 1 for the next year to trigger
			if (seconds % birthRate == 0)
				population += 1;
			if (seconds % deathRate == 0)
				population -= 1;
			if (seconds % immigrantRate == 0)
				population += 1;
			
			if (seconds % (60 * 60 * 24 * 365) == 0) {
				year += 1;
				if (year == numberOfYears)
					System.out.println("The population in "+ numberOfYears
							+ " years " + " is: " + population);
			}
			seconds += 1;
		}	
	}
}
