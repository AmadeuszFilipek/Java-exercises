package Exercises;

import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter list(first number indicates list's length): ");
		double[] array = readDoubles(scanner);
		
		if (isSorted(array))
			System.out.println("The list is sorted");
		else
			System.out.println("The list is not sorted");
		
	}
	
	public static boolean isSorted(double[] list) {
		
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) 
				return false;
		}
		
		return true;
	}
	
	public static double[] readDoubles(Scanner scanner) {
		int numberOfReads = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				numberOfReads = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		
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
