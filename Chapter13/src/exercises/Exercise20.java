package exercises;

import java.util.Scanner;

import exercise17.Complex;

public class Exercise20 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Complex a, b, c, discriminant, root1, root2;
		System.out.println("Enter a, b, c: ");
		while (true) {
			if (scanner.hasNextDouble()) {
				a = new Complex(scanner.nextDouble());
				if (scanner.hasNextDouble()) {
					b = new Complex(scanner.nextDouble());
					if (scanner.hasNextDouble()) {
						c = new Complex(scanner.nextDouble());
						break;
					}
				}
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		
		discriminant = b.multiply(b).substract(
				a.multiply(c).multiply(new Complex(4)));
		
		if (Math.abs(discriminant.getReal() + discriminant.getImaginary()) < Math.pow(10, -8)) {
			root1 = b.divide(a).divide(new Complex(-2));
			System.out.println("The equation has one second order root " + root1);
		}
		else {
			
			// not really a valid way to get a root of complex value
			root1 = b.substract(new Complex(0, Math.sqrt(-1 * discriminant.getReal()))).divide(a).divide(new Complex(-2));
	
			root2 = b.add(new Complex(0, Math.sqrt(-1 * discriminant.getReal()))).divide(a).divide(new Complex(-2));
			
			System.out.println("The equation has two roots " + root1 + " and " + root2);
		}	
	}
}
