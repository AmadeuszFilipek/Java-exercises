package exercises;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Exercise18 {
	
	public static int[][] parallelEightQueens() {
		int[][] queensSolutions = new int[8][8];

		ArrayList<EightQueensSolution> solutions = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			solutions.add(new EightQueensSolution(i));
		}
		ForkJoinPool pool = new ForkJoinPool();
		for(int i = 0; i < 8; i++) {
			queensSolutions[i] = pool.invoke(solutions.get(0));
		}
		
		return queensSolutions;
	}


	public static class EightQueensSolution extends RecursiveTask<int[]> {

		private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};

		public EightQueensSolution() {}

		public EightQueensSolution(int i) {
			queens[0] = i;
		}

		public int[] compute() {
			search();
			return queens;
		}

		/** Search for a solution */
		private boolean search() {
			// k - 1 indicates the number of queens placed so far
			// We are looking for a position in the kth row to place a queen
			int k = 1;
			while (k >= 0 && k < 8) {
				// Find a position to place a queen in the kth row
				int j = findPosition(k);
				if (j < 0) {
					queens[k] = -1;
					k--; // back track to the previous row
				} 
				else {
					queens[k] = j;
					k++;
				}
			}

			if (k == -1)
				return false; // No solution
			else
				return true; // A solution is found
		}

		public int findPosition(int k) {
			int start = queens[k] + 1; // Search for a new placement

			for (int j = start; j < 8; j++) {
				if (isValid(k, j))
					return j; // (k, j) is the place to put the queen now
			}

			return -1;
		}

		/** Return true if a queen can be placed at (row, column) */
		public boolean isValid(int row, int column) {
			for (int i = 1; i <= row; i++)
				if (queens[row - i] == column // Check column
				|| queens[row - i] == column - i // Check upleft diagonal
				|| queens[row - i] == column + i) // Check upright diagonal
					return false; // There is a conflict
			return true; // No conflict
		}
	}
}
