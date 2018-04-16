package Exercises;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ten integers : ");
		int[] integers = new int[10];
		
		for(int i = 0; i < integers.length; i++)
			integers[i] = read(scanner);			
	
		scanner.close();
		
		for(int i = integers.length - 1; i >= 0; i--) {
			System.out.print(integers[i] + " ");
		}
		
		
		
	}
	
	
	public static int read(Scanner scanner) {
		while(true) {
			if (scanner.hasNextInt()) {
				return scanner.nextInt();
			}
			else
				scanner.next();
		}	
	}
}
