package Exercises;

import java.util.Scanner;

public class Exercise32 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three triangle points: ");
		double[][] points = readDoubleMatrix(scanner, 3, 2);
		
		if (sameLine(points))
			System.out.println("The three points are on the same line");
		else
			System.out.println("The area of triangle is " + getTriangleArea(points));
	}
	
	public static double getTriangleArea(double[][] points) {
		
		double side1 = side(points[0], points[1]);
		double side2 = side(points[1], points[2]);
		double side3 = side(points[2], points[0]);
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		return area;
	}
	
	private static double side(double[] point1, double[] point2) {
		return Math.sqrt(Math.pow(point1[0] - point2[0], 2) +
				Math.pow(point1[1] - point2[1], 2));
	}
	
	/** [8.15] verifies any number of points if they are on the same line */
	public static boolean sameLine(double[][] points) {
		
		for(int i = 0; i < points.length - 2; i++) {

			if (!onTheSameLine(
					points[i][0], points[i][1],
					points[i + 1][0], points[i + 1][1],
					points[i + 2][0], points[i + 2][1]
					))
				return false;			
				
		}

		return true;
	}
	/**Used by sameLine, verifies three points */
	private static boolean onTheSameLine(double x0, double y0,
			double x1, double y1, double x2, double y2) {
		
		double verifyFunction = (x1 - x0) * (y2 - y0)
				- (x2 - x0) * (y1 - y0);
		
	  return Math.abs(verifyFunction) < Math.pow(10, -8);
	}
	
	public static double[][] readDoubleMatrix(Scanner scanner, int row, int column) {
		
		double[][] numbers = new double[row][column];
		int rowCount = 0;
		int columnCount = 0;
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers[rowCount][columnCount] = scanner.nextDouble();
				columnCount++;
				if (columnCount >= column) { 
					rowCount++;
					columnCount = 0;
					if (rowCount >= row)
						break;
				}
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
