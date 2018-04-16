package exercises;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise17 {

	public static void main(String[] args) {
		
		double[][] a = new double[2000][2000];
		double[][] b = new double[2000][2000];
		
		for(int i = 0; i < a.length; i++) 
			for(int j = 0; j <a[i].length; j++){
				a[i][j] = 5;
				b[i][j] = 8;
			}
		
		long startTime = System.currentTimeMillis();
		double[][] result = parallelMultiplyMatrix(a, b);
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel multiplication time with "
				+ Runtime.getRuntime().availableProcessors() + 
				" processors is " + (endTime - startTime) + " milliseconds");

		System.out.println(result);
		
	}
	
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
		
		MultiplyMatrixAction mainTask = new MultiplyMatrixAction(a, b);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);
		
		return MultiplyMatrixAction.getResult();
	}
	
	/** assume the matrix is square **/
	public static class MultiplyMatrixAction extends RecursiveAction {
		
		private final static int THRESHOLD = 200;
		
		private double[][] a;
		private double[][] b;

		private int rowStart;
		private int rowEnd;
		private int colStart;
		private int colEnd;
		
		private static double[][] result;
		
		public static double[][] getResult() {
			return result;
		}
		
		public MultiplyMatrixAction(double[][] a, double[][] b) {
			this(a, b, 0, a.length, 0, a[0].length);
			result = new double[a.length][a[0].length];
		}
		
		public MultiplyMatrixAction(double[][] a, double[][] b, 
				int rowStart, int rowEnd, int colStart, int colEnd) {
			this.a = a;
			this.b = b;
			this.rowStart = rowStart;
			this.rowEnd = rowEnd;
			this.colStart = colStart;
			this.colEnd = colEnd;
		}
		
		public void compute() {
			
			//conquer
			if (rowEnd - rowStart < THRESHOLD && colEnd - colStart < THRESHOLD) {
				for (int row = rowStart; row < rowEnd; row++) {
					for(int col = colStart; col < colEnd; col++) {
						for(int i = 0; i < a.length; i++)
							result[row][col] += a[row][i] * b[i][col];
					}
				}
			}
			//divide
			else {

				int rowMid = (rowEnd - rowStart) / 2 + rowStart;
				int colMid = (colEnd - colStart) / 2 + colStart;

				MultiplyMatrixAction topLeft = new MultiplyMatrixAction(a, b, rowStart, rowMid, colStart, colMid);
				MultiplyMatrixAction topRight = new MultiplyMatrixAction(a, b, rowStart, rowMid, colMid, colEnd);
				MultiplyMatrixAction botLeft = new MultiplyMatrixAction(a, b, rowMid, rowEnd, colStart, colMid);
				MultiplyMatrixAction botRight = new MultiplyMatrixAction(a, b, rowMid, rowEnd, colMid, colEnd);
				
				invokeAll(topLeft, topRight, botLeft, botRight);
			}
		}
	}
}
