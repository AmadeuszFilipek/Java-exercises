package Exercises;

import java.util.Scanner;

public class Exercise32 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		double[] tempo = new double[6];
		int i = 0;
		
		System.out.println("Enter three points for p0, p1 and p2: ");
		while(true) {
			if (scanner.hasNextDouble()){
				tempo[i] = scanner.nextDouble();
				i++;
			}
			else
				scanner.nextLine();
			if(i >= 6)
				break;	
		}
		scanner.close();
		
		// x0, y0, x1, y1, x2, y2
		double verifyFunction = (tempo[2] - tempo[0]) * (tempo[5] - tempo[1])
				- (tempo[4] - tempo[0]) * (tempo[3] - tempo[1]);
		
		if (verifyFunction < 0) {
			System.out.printf("(%.1f, %.1f) is on the right side of the line "
				+ "from (%.1f, %.1f) to (%.1f, %.1f)",
				tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		}
		else if(Math.abs(verifyFunction) < Math.pow(10, -8)) {
			System.out.printf("(%.1f, %.1f) is on the line "
					+ "from (%.1f, %.1f) to (%.1f, %.1f)",
					tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		}
		else {
			System.out.printf("(%.1f, %.1f) is on the left side of the line "
					+ "from (%.1f, %.1f) to (%.1f, %.1f)",
					tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		}
	}
}
