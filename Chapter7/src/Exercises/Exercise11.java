package Exercises;

import java.util.Scanner;

public class Exercise11 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		double[] numbers = readDoubles(scanner);
		
		System.out.println("The mean is " + mean(numbers));
		System.out.println("the standard deviation is " + deviation(numbers));

	}

	public static double deviation(double[] x) {
		double mean = mean(x);
		double deviation = 0;
		for(int i = 0; i < x.length; i++) {
			deviation += Math.pow(mean - x[i], 2);		
		}
		
		return Math.sqrt(deviation / (x.length - 1));
		
	}
	
	public static double mean(double[] x) {
		double sum = 0;
		
		for(int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum / x.length;
	}
	
	public static double[] readDoubles(Scanner scanner) {
		
		double[] numbers = new double[10];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers[count] = scanner.nextDouble();
				count++;
				if (count >= 10) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
