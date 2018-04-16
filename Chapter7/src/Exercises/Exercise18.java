package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers : ");
		double[] array = readDoubles(scanner, 10);
		
		bubbleSort(array);
		System.out.println("Sorted numbers: ");
		System.out.println(Arrays.toString(array));
		
		
		
	}
	
	public static void bubbleSort(double[] array) {
		double temp;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}			
			}		
		}
	}
	
	public static double[] readDoubles(Scanner scanner, int numberOfReads) {
		double[] numbers = new double[numberOfReads];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers[count] = scanner.nextDouble();
				count++;
				if (count >= numberOfReads) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
