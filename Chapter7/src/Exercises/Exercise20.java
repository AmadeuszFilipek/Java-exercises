package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise20 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		double[] numbers = readDoubles(scanner, 10);
		
		selectionSort(numbers);
		
		System.out.println("Sorted numbers: ");
		System.out.println(Arrays.toString(numbers));
		
	}	

	public static void selectionSort(double[] array) {
		int max;
		double temp;
		for(int i = array.length - 1; i >= 0; i--) {
			max = i;
			for(int j = i - 1; j >= 0; j--) {
				if (array[j] > array[max])
					max = j;
			}
			temp = array[max];
			array[max] = array[i];
			array[i] = temp;
			
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
