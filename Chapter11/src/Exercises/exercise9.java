package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise9 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size n: ");
		int size = scanner.nextInt();
		scanner.close();
		
		int[][] matrix = binaryMatrix(size, size);
		displayMatrix(matrix);
		System.out.println("The largest row index: " + rowWithMostOnes(matrix));
		System.out.println("The largest column index: " + columnWithMostOnes(matrix));
		
	}
	
	public static void displayMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
					
			}
			System.out.println();
		}
	}
	
	public static ArrayList<Integer> columnWithMostOnes(int[][] m) {
		int colCount = 0;
		int maxColCount = 0;
		int i = 0, j = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		// traverse column-wise not row-wise
		while(i < m.length && j < m[i].length) {
			if(m[i][j] == 1) 
				colCount++;
			
			i++;
			if(i >= m.length) {
				if (colCount > maxColCount) {
					result.clear();
					maxColCount = colCount;
					result.add(j);
				}
				else if (colCount == maxColCount)
					result.add(j);
					
				j++;
				i = 0;
				colCount = 0;
			}			
		}
		
		return result;
	}
	
	public static ArrayList<Integer> rowWithMostOnes(int[][] m) {
		int rowCount = 0;
		int maxRowCount = 0;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < m.length; i++) {
			rowCount = 0;
			for(int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 1)
					rowCount++;
			}
			if (rowCount > maxRowCount) {
				result.clear();
				maxRowCount = rowCount;
				result.add(i);
			}
			else if(rowCount == maxRowCount)
				result.add(i);
		}
		
		return result;
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
