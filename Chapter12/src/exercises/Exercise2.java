package exercises;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		int number1 = readInteger(scanner);
		
		System.out.print("Enter the second number: ");
		int number2 = readInteger(scanner);
		
		System.out.println(number1 + " + " +  number2 + " = " + (number1 + number2));
		
		
		
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
