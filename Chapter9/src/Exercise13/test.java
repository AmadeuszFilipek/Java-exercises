package Exercise13;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter dimensions of array: ");
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		System.out.println("Enter the array: ");
		
		double[][] a = readDoubleMatrix(scanner, row, column);
		
		Location loc = Location.locateLargest(a);
		
		System.out.println("The largest element " + loc.maxValue + " is at: " + loc.row + " " + loc.column);
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
