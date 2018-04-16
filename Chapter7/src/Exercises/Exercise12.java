package Exercises;

import java.util.Scanner;

public class Exercise12 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		double[] numbers = readDoubles(scanner);

		reverse(numbers);
		
		System.out.println("The reversed numbers are : ");
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}
	
	public static void reverse(double[] array) {
		double temp;
		
		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}		
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
