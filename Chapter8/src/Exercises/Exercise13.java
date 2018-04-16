package Exercises;

import java.util.Scanner;

public class Exercise13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns of the array: ");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		System.out.println("Enter the array: ");
		double[][] matrix = readDoubleMatrix(scanner, rows, columns);
		
		int[] indices = locateLargest(matrix);
		System.out.println("The location of the largest element is at (" +
				indices[0] + ", " + indices[1] + ")");
		
		
	}
	public static int[] locateLargest(double[][] a) {
		
		int[] coordinates = new int[2];
		double largestElement = a[0][0];
		for(int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] > largestElement) {
					largestElement = a[i][j];
					coordinates[0] = i;
					coordinates[1] = j;
				}
			}
		}
		
		return coordinates;
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
