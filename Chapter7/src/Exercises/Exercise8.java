package Exercises;

import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 10 double numbers: ");
		double[] values = readDoubles(scanner);
		
		System.out.println("The average is : " + average(values));
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
	
	public static int average(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum / array.length;
	}
	
	public static double average(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum / array.length;
	}
}
