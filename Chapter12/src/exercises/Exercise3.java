package exercises;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		
		int[] array = new int[100];
		
		for(int i = 0; i < array.length; i++) 
			array[i] = (int)(Math.random() * 100);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an index of the array: ");
		
		int index = readInteger(scanner);
		scanner.close();
		
		if(index >= array.length || index < 0)
			System.out.println("Out of bounds.");
		else
			System.out.println(array[index]);

	}
	
	public static int readInteger (Scanner scanner) {
		int number;
		
		while(true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else 
				System.out.print("Input " + scanner.next() + " incorrect. Please Enter the number again: ");
		}
		
		return number;
	}
}
