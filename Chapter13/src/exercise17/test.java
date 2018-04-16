package exercise17;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first complex number: ");
		Complex c1 = new Complex(scanner.nextDouble(), scanner.nextDouble());

		System.out.println("Enter the second complex number: ");
		Complex c2 = new Complex(scanner.nextDouble(), scanner.nextDouble());

		System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
		System.out.println(c1 + " - " + c2 + " = " + c1.substract(c2));
		System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
		System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
		System.out.println("|" + c1 + "| = " + c1.abs());
		
		scanner.close();
	}
}
