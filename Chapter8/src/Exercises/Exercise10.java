package Exercises;

public class Exercise10 {

	public static void main(String[] args) {
		int[][] matrix = binaryMatrix(10, 10);
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
	
	public static int columnWithMostOnes(int[][] m) {
		int colCount = 0;
		int maxColCount = 0;
		int desiredCol = 0;
		int i = 0, j = 0;
		
		// traverse column-wise not row-wise
		while(i < m.length && j < m[i].length) {
			if(m[i][j] == 1) 
				colCount++;
			
			i++;
			if(i >= m.length) {
				if (colCount > maxColCount) {
					maxColCount = colCount;
					desiredCol = j;
				}
				j++;
				i = 0;
				colCount = 0;
			}			
		}
		
		return desiredCol;
	}
	
	public static int rowWithMostOnes(int[][] m) {
		int rowCount = 0;
		int maxRowCount = 0;
		int desiredRow = 0;
		
		for(int i = 0; i < m.length; i++) {
			rowCount = 0;
			for(int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 1)
					rowCount++;
			}
			if (rowCount > maxRowCount) {
				maxRowCount = rowCount;
				desiredRow = i;
			}
		}
		
		return desiredRow;
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
