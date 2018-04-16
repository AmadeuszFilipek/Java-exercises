package Exercises;

import java.util.Scanner;

public class Exercise39 {

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
		
		
		if (onTheLineSegment(tempo[0], tempo[1], tempo[2], tempo[3], tempo[4], tempo[5]))
			System.out.printf("(%.1f, %.1f) is on the line segment "
					+ "from (%.1f, %.1f) to (%.1f, %.1f)",
					tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		else if (onTheSameLine(tempo[0], tempo[1], tempo[2], tempo[3], tempo[4], tempo[5]))
			System.out.printf("(%.1f, %.1f) is on the same line "
					+ "from (%.1f, %.1f) to (%.1f, %.1f)",
					tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		else {

			if (leftOfTheLine(tempo[0], tempo[1], tempo[2], tempo[3], tempo[4], tempo[5])) 
				System.out.printf("(%.1f, %.1f) is on the left side of the line "
						+ "from (%.1f, %.1f) to (%.1f, %.1f)",
						tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
			else
				System.out.printf("(%.1f, %.1f) is on the right side of the line "
						+ "from (%.1f, %.1f) to (%.1f, %.1f)",
						tempo[4], tempo[5], tempo[0], tempo[1], tempo[2], tempo[3]);
		
		}
		
	}
	
	public static boolean leftOfTheLine(double x0, double y0,
			double x1, double y1, double x2, double y2) {
		// x0, y0, x1, y1, x2, y2
		double verifyFunction = (x1 - x0) * (y2 - y0)
				- (x2 - x0) * (y1 - y0);
		
		return verifyFunction > 0;
		
	}
	
	public static boolean onTheSameLine(double x0, double y0,
			double x1, double y1, double x2, double y2) {
		
		double verifyFunction = (x1 - x0) * (y2 - y0)
				- (x2 - x0) * (y1 - y0);
		
	  return Math.abs(verifyFunction) < Math.pow(10, -8);
	}
	
	public static boolean onTheLineSegment(double x0, double y0,
			double x1, double y1, double x2, double y2) {
		
		boolean isXInside = false;
		boolean isYInside = false;
		
		if(onTheSameLine(x0, y0, x1, y1, x2, y2)) {
			//check if x is inside
			if (x0 < x1) {
				if (x2 > x0 && x2 < x1)
					isXInside = true;
			}
			else
				if (x2 > x1 && x2 < x0)
					isXInside = true;
			//check if y is inside
			if (y0 < y1) {
				if (y2 > y0 && y2 < y1)
					isYInside = true;
			}
			else 
				if (y2 > y1 && y2 < y0)
					isYInside = true;
	
		}
		
		return isXInside && isYInside;	
	}
	
	
}
