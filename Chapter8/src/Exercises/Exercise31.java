package Exercises;

import java.util.Scanner;

public class Exercise31 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter four points p1, p2, p3, p4: ");
		double[][] points = readDoubleMatrix(scanner, 4, 2);
		scanner.close();
		
		getIntersectingPoint(points);
	}
	
	public static double[] getIntersectingPoint(double[][] points) {
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
