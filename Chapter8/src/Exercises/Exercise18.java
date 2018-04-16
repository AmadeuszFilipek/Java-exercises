package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise18 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter matrix matrix dimensions: ");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int[][] matrix = readIntegerMatrix(scanner, rows, columns);
		
		shuffle(matrix);
		displayMatrix(matrix);
		
	}
	
	public static void shuffle(int[][] m)	{
		
		int position;
		boolean[] positionFilled = new boolean[m.length];
		int[][]	holdOldMatrix = Arrays.copyOf(m, m.length);
		//for each row, generate it's new position
		for(int i = 0; i < m.length; i++) {

			// generate new position until you find an empty one
			while(true) {
				position = (int)Math.floor(Math.random() * m.length);
				//if its empty - take it and stop searching for position
				if(!positionFilled[position]) {
					positionFilled[position] = true;
					break;
				}
			}
				
			m[position] = holdOldMatrix[i];
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
	
	public static void displayMatrix(int[][] m) {
		
		for(int i = 0; i < m.length; i++) {		
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
