package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise45 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double> numbers = new ArrayList<>();
		
		System.out.print("Enter ten numbers: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers.add(scanner.nextDouble());
				if (numbers.size() >= 10)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		double mean = 0;
		double standardDeviation = 0;
		
		for (Double s: numbers) 
			mean += s;
		
		mean = mean / numbers.size();
		
		for (Double s: numbers) 
			standardDeviation = Math.pow(mean - s, 2);
		
		standardDeviation /= numbers.size() - 1;
		standardDeviation = Math.sqrt(standardDeviation);
		
		System.out.println("The mean is " + mean);
		System.out.println("The standard deviation is " + standardDeviation);
	}
}
