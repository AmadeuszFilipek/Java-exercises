package exercises;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// No big improvements here with addition, i guess loops are optimized themselves
// Still, on big arrays, the parallel function is somewhat faster
// or my implementation is somehow slow
public class Exercise16 {

	public static void main(String[] args) {

		double[][] a = new double[5000][5000];
		double[][] b = new double[5000][5000];

		for(int i = 0; i < a.length; i++) 
			for(int j = 0; j <a[i].length; j++){
				a[i][j] = 5;
				b[i][j] = 8;
			}

		long startTime = System.currentTimeMillis();
		double[][] result = parallellAddMatrix(a, b);
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel sum time with "
				+ Runtime.getRuntime().availableProcessors() + 
				" processors is " + (endTime - startTime) + " milliseconds");

		startTime = System.currentTimeMillis();
		result = addMatrix(a, b);
		endTime = System.currentTimeMillis();
		
		System.out.println("Linear matrix sum time is " + (endTime - startTime) + " miliseconds");

	}

	public static double[][] addMatrix(double[][] a, double[][] b) {
		if (a == null || b == null || a.length != b.length || a[0].length != b[0].length)
			return null;

		double[][] result = new double[a.length][a[0].length];

		for(int i = 0; i < a.length; i++) 
			for(int j = 0; j <a[i].length; j++){
				result[i][j] = a[i][j] + b[i][j];
			}

		return result;
	}

	public static double[][] parallellAddMatrix(double[][] a, double[][] b) {
		if (a == null || b == null || a.length != b.length || a[0].length != b[0].length)
			return null;
		
		MatrixAdditionTask mainTask = new MatrixAdditionTask(a, b);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(mainTask);
	}

	public static class MatrixAdditionTask extends RecursiveTask<double[][]>	{

		private static final int ROW_THRESHOLD = 1000;
		private static final int COL_THRESHOLD = 1000;
		private double[][] a;
		private double[][] b;
	
		private int rowStart;
		private int rowEnd;
		private int colStart;
		private int colEnd;

		private static double[][] result;

		public MatrixAdditionTask(double[][] a, double[][] b) {
			this(a, b, 0, a.length, 0, a[0].length);
			result = new double[a.length][a[0].length];
		}

		private MatrixAdditionTask(double[][] a, double[][] b, 
				int rowStart, int rowEnd, int colStart, int colEnd) {
			this.a = a;
			this.b = b;
			this.rowStart = rowStart;
			this.rowEnd = rowEnd;
			this.colStart = colStart;
			this.colEnd = colEnd;
			
		}

		@Override
		public double[][] compute() {	
			//conquer
			if (rowEnd - rowStart < ROW_THRESHOLD && colEnd - colStart < COL_THRESHOLD) {
				for (int i = rowStart; i < rowEnd; i++) {
					for(int j = colStart; j < colEnd; j++) {
						result[i][j] = a[i][j] + b[i][j];
					}
				}
				return result;
			}
			//divide
			else {
				int rowMid = (rowEnd - rowStart) / 2 + rowStart;
				int colMid = (colEnd - colStart) / 2 + colStart;

				MatrixAdditionTask upperLeft = new MatrixAdditionTask(a, b, rowStart, rowMid, colStart, colMid);
				MatrixAdditionTask upperRight = new MatrixAdditionTask(a, b, rowMid, rowEnd, colStart, colMid);
				MatrixAdditionTask lowerLeft = new MatrixAdditionTask(a, b, rowStart, rowMid, colMid, colEnd);
				MatrixAdditionTask lowerRight = new MatrixAdditionTask(a, b, rowMid, rowEnd, colMid, colEnd);

				invokeAll(upperLeft, upperRight, lowerLeft, lowerRight);
				return result;
			}
		}
	}
}
