package Exercises;

import java.util.Scanner;

public class Exercise16 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a matrix of integers (6x2): ");
		int[][] matrix = readIntegerMatrix(scanner, 6, 2);
		
		sort(matrix);
		
		displayMatrix(matrix);
	}
	/** The method sorts the rows so that they align to each-other like in excel work-sheet
	 * I'm pretty sure thats not what the exercise was about,
	 * but the description is vague, and i can't decipher.
	 * @param m
	 */
	public static void sort(int[][] m) {
		int[] temp;
		
		for(int j = 0; j < m.length; j ++) {
			for(int i = 0; i < m.length - 1; i++) {
				for(int k = m[i].length - 1; k >= 0; k--) {
					if (m[i][k] > m[i + 1][k]) {
						temp = m[i];
						m[i] = m[i + 1];
						m[i + 1] = temp;
					}
				}
			}
		}
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
