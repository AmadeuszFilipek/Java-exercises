package Exercises;

import java.util.Scanner;

import Exercise11.LinearEquation;

public class Exercise12 {

	public static void main(String[] args) {
		
		double a, b, e;
		double c, d, f;
		double[] tempo = new double[8];
		
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
		while (true) {
			if(scanner.hasNextDouble()) {
				tempo[i] = scanner.nextDouble();
				i++;
			}
			else 
				scanner.nextLine();
			if (i >= 8) {
				break;
			}
		}
		scanner.close();
		
		a = tempo[1] - tempo[3]; b = -(tempo[0] - tempo[2]);
		e = a * tempo[0] + b * tempo[1];
		c = tempo[5] - tempo[7]; d = -(tempo[4] - tempo[6]);
		f = c * tempo[4] + d * tempo[5];
		
		LinearEquation eq = new LinearEquation(a, b, c, d, e, f);
		
		if(eq.isSolvable())
			System.out.println("The solution: [" + eq.getX() + "; " + eq.getY() +"]");
		else
			System.out.println("Those two line segments are parallel and do not intersect.");
	}
}
