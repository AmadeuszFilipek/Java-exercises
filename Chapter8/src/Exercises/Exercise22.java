package Exercises;

public class Exercise22 {

	public static void main(String[] args) {
		
		int[][]	matrix = binaryMatrix(6, 6);
		displayMatrix(matrix);
		
		if (evenNumbers(matrix, 1))
			System.out.println("Every row and column has even number of 1s");
		else
			System.out.println("Not every row or column has even number of 1s");
		
		
	}
	/** Checks if every column and row has even number of @number
	 * 	
	 * @param
	 * @param number - value to be looked for
	 * @return
	 */
	public static boolean evenNumbers(int[][] m, int number) {
		// check for rows
		for(int i = 0; i < m.length; i++) {
			int numberOfNumbers = 0;
			for(int j = 0; j < m[i].length; j++) {
				numberOfNumbers++;
			}
			
			if (numberOfNumbers % 2 != 0)
				return false;	
		}
		
		//check for columns, loop is different because of column-like iteration
		int i = 0, j = 0;
		int numberOfNumbers = 0;
		
		while(true) {
			if (m[i][j] == number)
				numberOfNumbers++;
			i++;
			if (i >= m[0].length) {
				if (numberOfNumbers % 2 != 0)
					return false;	
				numberOfNumbers = 0;
				j++;
				if (j >= m.length)
					break;
				i = 0;
			}
		}

		return true;
	}
	
	public static void displayMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
					
			}
			System.out.println();
		}
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
