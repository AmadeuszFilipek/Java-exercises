package Exercises;

import java.util.Scanner;

public class Exercise10 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		double[] numbers = readDoubles(scanner);
		
		System.out.println("The index of the smallest number is: " + indexOfSmallestElement(numbers));
	}

	
	public static int indexOfSmallestElement(double[] array) {
		double min = min(array);
		int i = 0;
		
		while(true) {
			if (min == array[i])
				return i;
			
			i++;	
		}	
	}
	
	public static double min(double[] array) {
		double min = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
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
