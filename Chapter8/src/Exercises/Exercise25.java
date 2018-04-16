package Exercises;

import java.util.Scanner;

public class Exercise25 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 3 by 3 matrix: ");
		double[][] matrix = readDoubleMatrix(scanner, 3, 3);
		
		if (isMarkovMatrix(matrix))
			System.out.println("It is a Markov matrix");
		else
			System.out.println("It is not a Markov matrix");
		
		
	}
	
	public static boolean isMarkovMatrix(double[][] m) {
		double columnSum = 0;
		int i = 0, j = 0;
		
		while(true) {
			
			if (m[i][j] < 0)
				return false;
			
			columnSum += m[i][j];
			
			i++;
			if (i >= m.length) {
				if (((columnSum - 1) > Math.pow(10, -8)))
					return false;
				columnSum = 0;
				j++;
				if(j >= m[0].length)
					break;
				i = 0;
			}	
		}
		
		return true;
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
