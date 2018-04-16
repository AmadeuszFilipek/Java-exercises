package Exercises;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the matrix: ");
		int size = scanner.nextInt();
		scanner.close();
		int[][] matrix = binaryMatrix(size, size);
		displayMatrix(matrix);
		lookForSameNumbers(matrix, 0);
		lookForSameNumbers(matrix, 1);
		
	}
	public static void lookForSameNumbers(int[][] m, int number) {

		//check rows	
		boolean noRowsFound = true;
		boolean noColumnsFound = true;
		boolean rowIsSame, columnIsSame;
		
		for(int i = 0; i < m.length; i++) {
			rowIsSame = true;
			columnIsSame = true;
			for(int j = 0; j < m[i].length; j++) {
				if (m[i][j] != number)
					rowIsSame = false;
				if (m[j][i] != number)
					columnIsSame = false;
			}
			
			if (rowIsSame) {
			System.out.println("All " + number + "s on row " + i);
				noRowsFound = false;
			}
			if (columnIsSame) {
				System.out.println("All " + number + "s on column " + i);
				noColumnsFound = false;
			}
		}
		
		if (noRowsFound)
			System.out.println("No only " + number + " numbers on a row");

		if (noColumnsFound)
			System.out.println("No only " + number + " numbers on a column");
		
		//check diagonals and sub-diagonals in ascending direction
		boolean noMajorDiagonalsFound = true;
		boolean noSubDiagonalsFound = true;
		boolean diagonalIsSame = true;
		
		for(int i = 0; i < m.length; i++) {
		
			diagonalIsSame  = true;
			for(int j = 0; j < m[i].length - i; j++) {
				if(m[j + i][j] != number) {
					diagonalIsSame  = false;
				}
			}
			
			if(diagonalIsSame) {
				if (i == 0){
					noMajorDiagonalsFound = false;
					System.out.println("All " + number + "s on major diagonal");
				}
				else {
					System.out.println("All " + number + "s on diagonal " + i);
					noSubDiagonalsFound = false;
				}
			}
		}	
		
		if (noMajorDiagonalsFound)
			System.out.println("No only" + number + " on the major diagonal");
		if (noSubDiagonalsFound)
			System.out.println("No only" + number + " on the sub-diagonal");
	}
	
	public static void displayMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
					
			}
			System.out.println();
		}
	}
	
	public static int[][] binaryMatrix(int rows, int columns) {
		int[][] result = new int[rows][columns];
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = (int)Math.round(Math.random());
			}	
		}
		
		return result;
	}
}
