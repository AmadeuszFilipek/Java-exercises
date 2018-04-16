package Exercises;

import java.util.Scanner;

public class Exercise29 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter list1 9 numbers: ");
		int[][] m1 = readIntegerMatrix(scanner, 3, 3);
		System.out.println("Enter list2 9 numbers: ");
		int[][] m2 = readIntegerMatrix(scanner, 3, 3);
		
		if(equals(m1, m2))
			System.out.println("The two arrays are identical");
		else
			System.out.println("The two arrays are not identical");
	}
	
	public static boolean equals(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			return false;
		
		for(int i = 0; i < m1.length; i++)
			for(int j = 0; j < m1[i].length; j++) {
				boolean found = false;
				for(int k = 0; k < m2.length; k++)
					for(int l = 0; l < m2[k].length; l++)
						if(m1[i][j] == m2[k][l])
							found = true;
		
				if (!found)
					return false;
			}
		return true;
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
