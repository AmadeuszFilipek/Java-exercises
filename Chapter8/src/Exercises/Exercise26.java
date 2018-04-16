package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise26 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 3 by 3 matrix: ");
		double[][] m = readDoubleMatrix(scanner, 3, 3);
		
		m = sortRows(m);
		displayMatrix(m);
		
	}
	
	public static void displayMatrix(double[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
					
			}
			System.out.println();
		}
	}
	
	public static double[][] sortRows(double[][] m) {
		
		double[][] result = Arrays.copyOf(m, m.length);
		
		// I already wrote sorting methods, no need to waste time here
		for(int i = 0; i < result.length; i++) 
			Arrays.sort(result[i]);
		
		return result;
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
