package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise34 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 6 points: ");
		double[][] points = readDoubleMatrix(scanner, 6, 2);
		
		double[] rightMostLowest = getRightmostLowestPoint(points);
		
		System.out.println("The rightmost lowest point is " + Arrays.toString(rightMostLowest));
	}

	public static double[] getRightmostLowestPoint(double[][] points) {
		double[] rgmLwstPnt = new double[2]; 
		
		for(int i = 0; i < points.length; i++) 
			if (points[i][0] >= rgmLwstPnt[0] && points[i][1] <= rgmLwstPnt[1]) {
				rgmLwstPnt[0] = points[i][0];
			  rgmLwstPnt[1] = points[i][1];		
			}
	return rgmLwstPnt;
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
