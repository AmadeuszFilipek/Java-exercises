package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise15 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		int[] numbers = readIntegers(scanner);
		
		int[] distincts = elimanteDuplicates(numbers);
		
		System.out.println("The distinct numbers are: " + Arrays.toString(distincts));
	}

	
	public static int[] elimanteDuplicates(int[] list) {
		
		boolean isDistinct;
		int[] distincts = new int[0];
		
		for (int j = 0; j < list.length - 1; j++) {
			isDistinct = true;
			for(int i = 0; i < distincts.length; i++) {
				if (list[j] == distincts[i])
					isDistinct = false;
			}
			if (isDistinct)
				distincts = addElement(distincts, list[j]);
		}
		
		return distincts;
	}
	
	public static int[] addElement(int[] list, int newElement) {
		int[] newList = new int[list.length + 1];
		for (int i = 0; i < list.length; i++)
			newList[i] = list[i];
		
		newList[newList.length - 1] = newElement;
		
		return newList;
	}
	
	public static int[] readIntegers(Scanner scanner) {
		int numberOfReads = 10;
		int[] numbers = new int[numberOfReads];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[count] = scanner.nextInt();
				count++;
				if (count >= numberOfReads) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
