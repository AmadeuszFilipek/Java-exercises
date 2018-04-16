package Exercises;

import java.util.Scanner;

public class Exercise30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter equation: ");
		double[][] a = readDoubleMatrix(scanner, 2, 2);
		double[] b = readDoubleMatrix(scanner, 1, 2)[0];
		
		double[] solution = linearEquation(a, b);
		if (solution == null)
			System.out.println("The equation has no solution");
		else
			System.out.println("Solution : x = " + solution[0] + " y = " + solution[1]);
	}
	
	public static double[] linearEquation(double[][] a, double[] b) {
		
		double W = a[0][0] * a[1][1] - a[0][1] * a[1][0];
		
		if (W == 0)
			return null;
		
		double xW = b[0] * a[1][1] - b[1] * a[0][1];
		double yW = b[1] * a[0][0] - b[0] * a[1][0];
		
		double[] result = new double[2];
		result[0] = xW / W;
		result[1] = yW / W;
		return result;
		
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
