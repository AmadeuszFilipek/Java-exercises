package Exercises;

import java.util.Scanner;

public class Exercise18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double weight;
		System.out.print("Enter the package weight: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				weight = scanner.nextDouble();
				break;
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		double shippingCost = 0;
		if (weight < 0) {
			System.out.println("Wrong input");
			System.exit(1);
		}
		else if (weight <= 1) {
			shippingCost = 3.5;
		}
		else if (weight <= 3) {
			shippingCost = 5.5;
		}
		else if (weight <= 10) {
			shippingCost = 8.5;
		}
		else if (weight <= 20) {
			shippingCost = 10.5;	
		}
		
		if (shippingCost != 0)
			System.out.println("Package shipping cost: " + shippingCost);
		else
			System.out.println("Package too heavy. Cannot be shipped.");	
		
		
		
	}
}
