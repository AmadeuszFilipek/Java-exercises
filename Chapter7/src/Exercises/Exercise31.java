package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise31 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list1: ");
		int list1Length = scanner.nextInt();
		int[] list1 = readIntegers(scanner, list1Length);
		System.out.print("Enter list2: ");
		int list2Length = scanner.nextInt();
		int[] list2 = readIntegers(scanner, list2Length);
		
		int[] mergedList = merge(list1, list2);
		
		System.out.println(Arrays.toString(mergedList));
		
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
	
	public static int[] merge(int[] list1, int[] list2) {
		int[] result = new int[list1.length + list2.length];
		// check if the list1 is whole smaller than list2
		boolean list1IsSmaller = list1[list1.length - 1] <= list2[0];
		// check if the list1 is whole bigger than list2
		boolean list1IsBigger = list1[0] >= list2[list2.length - 1];
		
		if (list1IsSmaller) {
		//add list1 on the left side;
			for(int i = 0; i < list1.length; i++)
				result[i] = list1[i];
			
			for(int i = 0; i < list2.length; i++) 
				result[i + list1.length] = list2[i];
		}
		else if (list1IsBigger) {
		//add list2 on the left side;
			for(int i = 0; i < list2.length; i++)
				result[i] = list2[i];
			
			for(int i = 0; i < list1.length; i++) 
				result[i + list2.length] = list1[i];
		}
		else {
		//list1 is somewhere in the middle of list2
		//merging is done iterating through each of lists
		//and comparing the values at actual indexes;
			boolean flag1 = false; 
			int i = 0;
			int i1 = 0;
			int i2 = 0;
			while(i < list1.length + list2.length) {
				
				if (i1 < list1.length && i2 < list2.length)
					flag1 = list1[i1] < list2[i2];
				else {
					if (i1 >= list1.length)
						flag1 = false;
					else
						flag1 = true;
				}
		
				if (i1 < list1.length && flag1) {
					result[i] = list1[i1];
					i1++;
					i++;
				}
				else if (i2 < list2.length) {
					result[i] = list2[i2];
					i2++;
					i++;
				}	
			}	
		}
		return result;
	}
}
