package Exercise11;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a, b, c, d, e and f for linear equation: ");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		double d = scanner.nextDouble();
		double e = scanner.nextDouble();
		double f = scanner.nextDouble();
		scanner.close();
		
		LinearEquation eq = new LinearEquation(a, b, c, d, e, f);
		
		if(eq.isSolvable())
			System.out.println("The solution: [" + eq.getX() + "; " + eq.getY() +"]");
		else
			System.out.println("The equation has no solution");
	}
}
