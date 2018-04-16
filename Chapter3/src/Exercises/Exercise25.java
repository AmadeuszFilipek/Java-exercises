package Exercises;

import java.util.Scanner;

public class Exercise25 {

	public static void main(String[] args) {
		
		double x = 0;
		double y = 0;
		
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
		
		double W = a * d - b * c;
		double Wx = e * d - b * f;
		double Wy = a * f - e * c;
		
		if (W != 0) {
			x = Wx / W;
			y = Wy / W;
			System.out.println("The intersecting point is at: ");
			System.out.println("x: " + x);
			System.out.println("y: " + y);
		}
		else if (Wx != 0 || Wy != 0)
			System.out.println("There is no soultion, lines are parallel.");
		else 
			System.out.println("Infinite number of solutions "
				+ " with one parameter, thus of linear dimension.");
	}
}