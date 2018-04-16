package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		double celciusDegree = 0;
		double fahrenheitDegree = 0;
		
		System.out.println("Enter a degree in Celsius: ");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (scanner.hasNextDouble()) {
				celciusDegree = scanner.nextDouble();
			  break;
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		fahrenheitDegree = (9 / 5.0) * celciusDegree + 32;
		System.out.println(celciusDegree + " is " + fahrenheitDegree + " in Fahrenheit");
	}
}
