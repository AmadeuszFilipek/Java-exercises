package Exercises;

import java.util.Scanner;

public class Exercise15 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter five points: ");
		double[][] points = readDoubleMatrix(scanner, 5, 2);
		
		if(sameLine(points))
			System.out.println("The five points are on the same line");
		else
			System.out.println("The five points are not on the same line");
		
	}
	
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
	
	public static boolean onTheSameLine(double x0, double y0,
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
