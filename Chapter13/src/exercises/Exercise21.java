package exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a, b, c: ");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		
		double h = - b / 2 / a;
		double k = c - a * h * h;
		
		System.out.println("h is : " + h);
		System.out.println("k is : " + k);
		scanner.close();
	}

}
