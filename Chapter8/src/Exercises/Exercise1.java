package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 3-by-4 matrix row by row: ");
		double[][] matrix = readDoubleMatrix(scanner, 3, 4);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Sum of the elements at column " + 0 + " is " + sumColumn(matrix, i));
		}
		

	}

	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for (int i = 0; i < m.length; i++)
					sum += m[i][columnIndex];
		return sum;
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
