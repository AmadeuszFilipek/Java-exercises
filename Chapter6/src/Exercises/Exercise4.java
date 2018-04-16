package Exercises;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int inputNumber = 0;
		
		System.out.print("Enter a integer number: ");
		while(true) {
			if (scanner.hasNextInt()) {
				inputNumber = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		
		reverse(inputNumber);
	}
	
	
	public static void reverse(int number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		System.out.println(Integer.parseInt(temp.toString()));
		
	}
}
