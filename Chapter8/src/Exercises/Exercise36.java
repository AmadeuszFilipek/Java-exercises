package Exercises;

import java.util.Scanner;

public class Exercise36 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows in the matrix: ");
		int size = scanner.nextInt();
		System.out.println("Enter the matrix row by row: ");
		char[][] letters = readCharacterMatrix(scanner, size);
		
		if(isLattinSquare(letters, size))
			System.out.println("The input array is Latin square");
		else
			System.out.println("The input array is not a lattin square");
		
	}

	public static boolean isLattinSquare(char[][] letters, int n) {
		
		//check rows
		for(int i = 0; i < letters.length; i++)
				if(!isLattinArray(letters[i], n))
					return false;
		
		//check columns by flipping them and treating as rows
		//i declare new variable, to keep @letters intact
		char[][] flipped = flipArray(letters);
		
		for(int i = 0; i < letters.length; i++)
			if(!isLattinArray(flipped[i], n))
				return false;
			
		return true;
	}
	
	private static boolean isLattinArray(char[] letters, int n) {
		int codeA = (int)'A';
		boolean[] flags = new boolean[n];
		
		for(int c = 0; c < letters.length; c++) {
			for(int i = 0; i < n; i++) {
				
				if(letters[c] == (char)(codeA + i)) {
					flags[i] = true;
					break;
				}
			}
		}
		
		boolean result = true;
		for (int i = 0; i < flags.length; i++)
			result &= flags[i];
		
		return result;
	}
	
	public static char[][] flipArray (char[][] a) {
		char[][] result = new char[a[0].length][a.length];
		
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[i].length; j++)
				result[j][i] = a[i][j];
		
		return result;
	}
	
	public static char[][] readCharacterMatrix(Scanner scanner, int size) {
		int codeA = (int)'A';
		
		char[][] numbers = new char[size][size];
		int rowCount = 0;
		int columnCount = 0;
		while(true) {
			numbers[rowCount][columnCount] = scanner.next().charAt(0);

			//parse the input
			if (numbers[rowCount][columnCount] < (char)codeA ||
					numbers[rowCount][columnCount] >= (char)(codeA + size)) {
				System.out.println("Wrong input: the letters must be from " +
						(char)codeA + " to " + (char)(codeA + size - 1));
				continue;
			}		

			columnCount++;
			if (columnCount >= size) { 
				rowCount++;
				columnCount = 0;
				if (rowCount >= size)
					break;
			}
		}
		
		return numbers;	
	}
}
