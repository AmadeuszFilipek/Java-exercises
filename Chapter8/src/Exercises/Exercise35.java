package Exercises;

import java.util.Scanner;

public class Exercise35 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows in the matrix: ");
		int size = scanner.nextInt();
		System.out.println("Enter the matrix row by row: ");
		int [][] m = readIntegerMatrix(scanner, size, size);
		
		int[] submatrix = findLargestBlock(m);
		
		System.out.println("The maximum square matrix is at (" +
				submatrix[0] + "; " + submatrix[1] + ") with size " + submatrix[2]);
	}
	
	public static int[] findLargestBlock(int[][] m) {
		int[] result = new int[3];
		
		for (int size = m.length; size >= 1; size--)
			for(int i = 0; i < m.length - (size - 1); i++)
				for(int j = 0; j < m[i].length - (size - 1); j++)
					if (isAllSame(getMinor(m, i, j, size), 1)) {
						result[0] = i;
						result[1] = j;
						result[2] = size;
						return result;
					}
				
	  return null;
	}
	
	private static boolean isAllSame(int[][] m, int number) {
		if (m == null)
			return false;
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				if (m[i][j] != number)
					return false;
		
		return true;
	}
	
	public static int[][] getMinor(int[][] m, int row, int column, int size) {
		if(row + size > m.length || column + size > m.length)
			return null;
		
		int[][] minor = new int[size][size];
		
		for(int i = row; i < row + size; i++)
			for(int j = column; j < column + size; j++)
				minor[i - row][j - column] = m[i][j];
		
		return minor;
	}
	
	public static int[][] readIntegerMatrix(Scanner scanner, int row, int column) {
		
		int[][] numbers = new int[row][column];
		int rowCount = 0;
		int columnCount = 0;
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[rowCount][columnCount] = scanner.nextInt();
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
