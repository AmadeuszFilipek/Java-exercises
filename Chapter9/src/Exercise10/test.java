package Exercise10;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter values for quadratic equation parameters a, b and c:");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		scanner.close();
		
		QuadraticEquation eq = new QuadraticEquation(a, b, c);
		double discriminant = eq.getDiscriminant();
		System.out.println("Value of discriminant: " + discriminant);
		
		if (discriminant > 0)
			System.out.println("The roots: " + eq.getRoot1() + " " + eq.getRoot2());
		else if(Math.abs(discriminant) < Math.pow(10, -8))
			System.out.println("One root: " + eq.getRoot1());
		else
			System.out.println("The equations has no real roots.");
	}
}
