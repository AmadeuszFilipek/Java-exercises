package Exercises;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		
		double x = 0;
		double y = 0;
		
		double a = 3.4, b = 50.2, e = 44.5;
		double c = 2.1, d = .55, f = 5.9;
		double[] tempo = new double[6];
		
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		System.out.println("Enter a, b, c, d, e, f: ");
		while (true) {
			if(scanner.hasNextDouble()) {
				tempo[i] = scanner.nextDouble();
				i++;
			}
			else 
				scanner.nextLine();
			if (i >= 6) {
				break;
			}
		}
		scanner.close();
		
		a = tempo[0]; b = tempo[1]; e = tempo[4];
		c = tempo[2]; d = tempo[3]; f = tempo[5];
		double W = a * d - b * c;
		double Wx = e * d - b * f;
		double Wy = a * f - e * c;
		
		if (W != 0) {
			x = Wx / W;
			y = Wy / W;
			System.out.println("Solution x: " + x);
			System.out.println("Solution y: " + y);
		}
		else if (Wx != 0 || Wy != 0)
			System.out.println("There is no soultion, problem undefined.");
		else 
			System.out.println("Infinite number of solutions "
					+ " with one parameter, thus of linear dimension.");
	}
}