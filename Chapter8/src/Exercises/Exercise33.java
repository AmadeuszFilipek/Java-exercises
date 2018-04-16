package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise33 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter four 4-vertex polygon points: ");
		double[][] vertices = readDoubleMatrix(scanner, 4, 2);
		scanner.close();
		
		double[] crossSection = getIntersectingPoint(vertices[0], vertices[2], vertices[1], vertices[3]);
		double[] triangleAreas = new double[4];
		
		for(int i = 0; i < triangleAreas.length; i++) {
			triangleAreas[i] = getTriangleArea(vertices[i], vertices[(i + 1) % 4], crossSection);			
		}
		
		Arrays.sort(triangleAreas);
		System.out.println("The areas are " + Arrays.toString(triangleAreas));
	}
	
	/** [8.32] get triangle area from three points, changed the argument structure */
	public static double getTriangleArea(double[]... points) {
		
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
	
	/** [8.31] intersecting point of four points or null*/
	public static double[] getIntersectingPoint(double[]... points) {
		double a, b, c, d, e, f;
		
		a = points[0][1] - points[1][1];
		b = -(points[0][0] - points[1][0]);
		e = a * points[0][0] + b * points[0][1]; // + sign because of b having - sign
		
		c = points[2][1] - points[3][1];
		d = -(points[2][0] - points[3][0]);
		f = c * points[2][0] + d * points[2][1]; // also + sign here
		
		double W = a * d - b * c;
		double Wx = e * d - b * f;
		double Wy = a * f - e * c;
		double[] result = new double[2];
		
		if (W != 0) {
			result[0] = Wx / W; // x
			result[1] = Wy / W; // y
			System.out.println("The intersecting point is at: ");
			System.out.println("x: " + result[0]);
			System.out.println("y: " + result[1]);
			return result;
		}
		else {
			System.out.println("There is no soultion, lines are parallel.");
			return null;
		}
	}
}
