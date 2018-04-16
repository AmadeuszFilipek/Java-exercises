package Exercises;

import java.util.Scanner;

public class Exercise5 {
	public static void main(String[] args) {
		
		double subtotal;
		double gratuityRate;
		double gratuity;
		double total;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the subtotal and gratuity rate: ");
		
		while (true) {
			if (scanner.hasNextDouble()) {
				subtotal = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					gratuityRate = scanner.nextDouble();
					break;
				}
			}
			else
				scanner.nextLine();
		}
		
		scanner.close();
		gratuity = gratuityRate / 100 * subtotal;
		total = gratuity + subtotal;
		System.out.println("The gratuity is $" + gratuity + 
				" and total is $" + total);
		
	}
}