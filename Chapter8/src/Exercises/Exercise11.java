package Exercises;

import java.util.Scanner;

public class Exercise11 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("ENter a number between 0 and 511: ");
		int bitCode = scanner.nextInt();
		scanner.close();
		
		displayMatrix(translateToMatrix(bitCode));
		
		
	}
	
	public static void displayMatrix(boolean[][] m) {
		
		for(int i = 0; i < m.length; i++) {		
			for(int j = 0; j < m.length; j++) {
				if (m[i][j])
					System.out.print("T ");
				else
					System.out.print("H ");
			}
			System.out.println();
		}
	}
	
	public static boolean[][] translateToMatrix(int number) {
		boolean[][] matrix = new boolean[3][3];
		int i = matrix.length - 1;
		int j = matrix[i].length - 1;
		int bitShift = 0;
		
		//regain those 9 bits of data from integer...
		while(i >= 0 && j >= 0) {

			matrix[i][j] = (number >> bitShift & 1) == 1;
			bitShift++;
			
			j--;
			if (j < 0) {
				i--;
				if (i < 0)
					break;
				j = matrix[i].length - 1;
			}
		}
		
		return matrix;
	}
}
