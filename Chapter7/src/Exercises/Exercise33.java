package Exercises;

import java.util.Scanner;

public class Exercise33 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a year: ");
		int year = input.nextInt();
		input.close();
		
		String[] animalName = {"monkey", "rooster", "dog", "pig", "rat",
				"ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep"};
		
		System.out.println(animalName[year % 12]); 
	}
}
