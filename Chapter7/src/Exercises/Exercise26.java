package Exercises;

import java.util.Scanner;

public class Exercise26 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list1(first number is list's length): ");
		int length1 = scanner.nextInt();
		int[] list1 = readIntegers(scanner, length1);
		
		System.out.print("Enter list2: ");
		int length2 = scanner.nextInt();
		int[] list2 = readIntegers(scanner, length2);
		
		if (equals(list1, list2))
			System.out.println("Two lists are strictly identical");
		else
			System.out.println("Two lists are not strictly identical");
		
	}
	
	public static boolean	equals(int[] list1, int[] list2) {
		if (list1.length != list2.length)
			return false;
		
		for(int i = 0; i < list1.length; i++) {
			if (list1[i] != list2[i])
				return false;
		}
		return true;
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
