package Exercises;

import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 6 by 6 matrix row by row: ");
		int[][]	matrix = readIntegerMatrix(scanner, 6, 6);
		int[]	flippedCell = evenNumbers(matrix, 1);
		System.out.println("The flipped cell is at (" + flippedCell[0] + "; " + flippedCell[1] + ")");
		
	}
	/** looks for not even number of @number and returns
	 *  the row and column which has uneven number of occurrences
	 * @param m
	 * @param number
	 * @return
	 */
	public static int[] evenNumbers(int[][] m, int number) {
		
		int[] result = new int[2];
		// check for rows
		for(int i = 0; i < m.length; i++) {
			int numberOfNumbers = 0;
			for(int j = 0; j < m[i].length; j++) {
				numberOfNumbers++;
			}
			
			if (numberOfNumbers % 2 != 0) {
				result[0] = i;	
				break;
			}
		}
		
		//check for columns, loop is different because of column-like iteration
		int i = 0, j = 0;
		int numberOfNumbers = 0;
		
		while(true) {
			
			if (m[i][j] == number)
				numberOfNumbers++;
			i++;
			
			if (i >= m[0].length) {
				if (numberOfNumbers % 2 != 0) {
					result[1] = j;	
					break;
				}
				numberOfNumbers = 0;
				j++;
				if (j >= m.length)
					break;
				i = 0;
			}
		}

		return result;
	}
	
	public static void displayMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
					
			}
			System.out.println();
		}
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
