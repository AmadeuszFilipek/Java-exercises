package Exercises;

import java.util.Scanner;

public class Exercise33 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[] package1 = new double[2];
		double[] package2 = new double[2];
		
		System.out.print("Enter weight and price for package 1: ");
		package1 = readPackage(scanner);
		System.out.print("Enter weight and price for package 1: ");
		package2 = readPackage(scanner);
		
		double pricePerUnit1 = package1[1] / package1[0];
		double pricePerUnit2 = package2[1] / package2[0];
		
		if (pricePerUnit1 < pricePerUnit2)
			System.out.println("Package 1 has a better price.");
		else if (Math.abs(pricePerUnit1 - pricePerUnit1) < Math.pow(10, -8))
			System.out.println("Two packages have the same price.");
		else
			System.out.println("Package 2 has a better price.");
	}
	
	private static double[] readPackage(Scanner scanner) {
		double[] temp = new double[2];
		
		while(true) {
			if (scanner.hasNextDouble()){
				temp[0] = scanner.nextDouble();
				if (scanner.hasNextDouble()) {
					temp[1] = scanner.nextDouble();
					break;
				}
			}
			else scanner.nextLine();	
		}		
		return temp;	
	}	
}
