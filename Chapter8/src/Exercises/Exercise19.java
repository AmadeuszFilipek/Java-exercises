package Exercises;

import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rows and columns: ");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		System.out.println("Enter the matrix row by row");
		int[][] matrix = readIntegerMatrix(scanner, rows, columns);
		scanner.close();
		
		displayMatrix(matrix);
		
		if(isConsecutiveFour(matrix))
			System.out.println("That matrix has consecutive four numbers");
		else
			System.out.println("That matrix has no consecutive four numbers");

	}
	/** method test whether the matrix has four consecutive values horizontally, 
	 * vertically or diagonally.
	 *  
	 * @param values
	 * @return
	 */
	public static boolean isConsecutiveFour(int[][] values) {
		// check vertically
		for(int i = 0; i < values.length; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if(values[i][j] == values[i][j + 1] &&
					 values[i][j + 1] == values[i][j + 2] &&
					 values[i][j + 2] == values[i][j + 3])
					return true;
		
		// check horizontally
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length; j++)
				if (values[i][j] == values[i + 1][j] &&
				    values[i + 1][j] == values[i + 2][j] &&
				    values[i + 2][j] == values[i + 3][j])
				 	return true;
		
		//check diagonally down-stream orientation
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j] == values[i + 1][j + 1] &&
				    values[i + 1][j + 1] == values[i + 2][j + 2] &&
				    values[i + 2][j + 2] == values[i + 3][j + 3])
					return true;
		
		//check diagonally up-stream orientation
		for(int i = values.length - 1; i >= 3; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j] == values[i - 1][j + 1] &&
						values[i - 1][j + 1] == values[i - 2][j + 2] &&
						values[i - 2][j + 2] == values[i - 3][j + 3])
					return true;
		
		return false;				
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
	
	public static void displayMatrix(int[][] m) {
		
		for(int i = 0; i < m.length; i++) {		
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
