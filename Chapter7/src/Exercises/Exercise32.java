package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise32 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list(the first number is length of list):");
		int length = scanner.nextInt();
		int[] list = readIntegers(scanner, length);
		
		list = partition(list);
		System.out.println("The list after partition: ");
		System.out.println(Arrays.toString(list));
		
	}
	/** rearrange the list so that all the elements smaller than pivot
	 * are before the pivot and elements greater than pivot are on the right
	 * side of pivot. Pivot is assumed to be the first value in the list.
	 * @param list
	 * @return - rearranged list
	 */
	public static int[] partition(int[] list) {
	
		int pivot = list[0];
		int[] result = new int[list.length];
		
		int smallerCount = 0;
		int biggerCount = 0;
		int i = 1;
		while(i < list.length) {
			if (list[i] <= pivot) {
				result[smallerCount] = list[i];
				smallerCount++;
			}
			else {
				result[list.length - biggerCount - 1] = list[i];
				biggerCount++;
			}
			
			i++;
		}
		// at last, insert the pivot inside
		result[smallerCount] = pivot;
		return result;
	}
	
	public static int[] readIntegers(Scanner scanner, int readNumber) {
		
		int[] numbers = new int[readNumber];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[count] = scanner.nextInt();
				count++;
				if (count >= readNumber) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
