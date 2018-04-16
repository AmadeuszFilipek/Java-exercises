package Exercises;

import java.util.Scanner;

public class Exercise6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter matrix 1 (3x3): ");
		double[][] martix1 = readDoubleMatrix(scanner, 3, 3);
		System.out.println("Enter matrix 2 (3x3): " );
		double[][] matrix2 = readDoubleMatrix(scanner, 3, 3);
		
		displayMultiplication(martix1, matrix2);
		
	}
	
	public static double[][] multiplyMatrix(double[][] a, double[][] b) {
		
		double[][] result = new double[a.length][a[0].length];
		
		if (a[0].length != b.length)
			return result;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				for(int k = 0; k < a[i].length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}				
			}
		}
		return result;
	}
	
	public static void displayMultiplication(double[][] a, double[][] b) {
		//should also check the length
		double[][] result = multiplyMatrix(a, b);
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			
			if( i == a.length / 2)
				System.out.print(" * ");
			else
				System.out.print("   ");
			
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			
			if ( i == a.length / 2)
				System.out.print(" = ");
			else 
				System.out.print("   ");
			
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			
			System.out.println();
		}
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
