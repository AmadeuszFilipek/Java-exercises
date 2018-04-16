package Exercises;

import java.util.Scanner;

public class Exercise24 {
	public static void main(String[] args) {
		// Read a Sudoku solution
		int[][] grid = readASolution();

		System.out.println(isValid(grid) ? "Valid solution" :
				"Invalid solution");
	}

	/** Read a Sudoku solution from the console */
	public static int[][] readASolution() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a Sudoku puzzle solution:");
		int[][] grid = new int[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				grid[i][j] = input.nextInt();
		
		input.close();
		return grid;
	}

	/** Check whether a solution is valid */
	public static boolean isValid(int[][] grid) {
		
		for(int i = 0; i < grid.length; i ++) {
			if (!isRowValid(grid[i]))
				return false;
			if(!isColumnValid(grid, i))
				return false;
		}
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if (!isSmallBoxValid(grid, i, j))
					return false;
			
		return true; // The solution is valid
	}
	
	/** boxRow - [0, 1, 2] boxColumn - [0, 1, 2] */
	public static boolean isSmallBoxValid(int[][] grid, int boxRow, int boxColumn) {
		boolean[] present = new boolean[9];
		
		for(int i = 3 * boxRow; i < 3 * boxRow + 3; i++) {
			for(int j = 3 * boxColumn; j < 3 * boxColumn + 3; j++) {
				present[grid[i][j] - 1] = true;
			}
		}
		
		// check for any missing
		for (int j = 0; j < present.length; j++)
			if (!present[j])
				return false;

		return true;
	}
	
	public static boolean isColumnValid(int[][] grid, int column) {
		boolean[] present = new boolean[9];
		int i = 0;
		// collect values
		while(true) {
			
			present[grid[i][column] - 1] = true;
			
			i++;
			if (i >= grid.length)
				break;
		}
		// check for any missing
		for (int j = 0; j < present.length; j++)
			if (!present[j])
				return false;
		
		return true;
	}
	
	public static boolean isRowValid(int[] row) {
		//collect values
		boolean[] present = new boolean[9];
		for(int i = 0; i < row.length; i++) {
			present[row[i] - 1] = true;
		}
		// check for any missing
		for (int i = 0; i < present.length; i++)
			if (!present[i])
				return false;
		
		return true;
	}
	
	/** Check whether grid[i][j] is valid in the grid */
	public static boolean isValid(int i, int j, int[][] grid) {
		// Check whether grid[i][j] is unique in i's row
		for (int column = 0; column < 9; column++)
			if (column != j && grid[i][column] == grid[i][j])
				return false;

		// Check whether grid[i][j] is unique in j's column
		for (int row = 0; row < 9; row++)
			if (row != i && grid[row][j] == grid[i][j])
				return false;

		// Check whether grid[i][j] is unique in the 3-by-3 box
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
				if (row != i && col != j && grid[row][col] == grid[i][j])
					return false;

		return true; // The current value at grid[i][j] is valid
	}
}

