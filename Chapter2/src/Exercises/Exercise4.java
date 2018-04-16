package Exercises;

import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
			
	  double pounds = 0;
		double kilograms = 0;
			
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Enter a value in pounds: ");
			
		while (true) {
		 if (scanner.hasNextDouble()) {
				pounds = scanner.nextDouble();
				break;
		 }
		 else 
			 scanner.nextLine();
		 }
			
		scanner.close();
			
		kilograms = pounds * 0.454;
		System.out.println(pounds + " is " + kilograms + " kilograms");
			
	}
}