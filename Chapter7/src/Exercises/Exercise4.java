package Exercises;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter scores (end with negative): ");
		double[] scores = readDoubles(scanner);
		int belowAverage = 0;
		int aboveAverage = 0;
		double average = 0;
		
		for (int i = 0; i < scores.length; i++) {
			average += scores[i];
		}
		average /= scores.length;
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > average)
				aboveAverage++;
			else
				belowAverage++;
		}
		
		System.out.println("The average score is " + average);
		System.out.println(belowAverage + " scores are belove average");
		System.out.println(aboveAverage + " scores are above average");
		
		
		
		
	}
	
	public static double[] readDoubles(Scanner scanner) {
		
		int bufferSize = 100;
		double[] numbers = new double[bufferSize];
		int count = 0;
		double temp;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				
				temp = scanner.nextDouble();
				if (temp < 0)
					break;
				
				numbers[count] = temp;
				count++;
				if (count >= 100) 
					break;
				
			}
			else scanner.next();
		}
		
		double[] result = new double[count];
		
		for(int i = 0; i < count; i++) {
			result[i] = numbers[i];
		}
		
		return result;	
	}
}
