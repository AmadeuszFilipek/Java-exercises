package Exercises;

public class Exercise22 {

	public static void main(String[] args) {
		
		int[] solution;
		
		while(true) {
			solution = placeQueens();
			if (isSolution(solution))
				break;
		}
		
		printBoard(solution);
		
	}
	
	public static void printBoard(int[] columnallignment) {
		
		for(int i = 0; i < columnallignment.length; i++) {
			for(int j = 0; j < columnallignment.length; j++) {
				if (j == 0)
					System.out.print("|");
				if (columnallignment[i] == j)
					System.out.print("O|");
				else
					System.out.print(" |");
			}
			
			System.out.println();
		}
		
	}
	
	public static int[] placeQueens() {
		int boardWidth = 8;
		int[] columnAlignment = new int[boardWidth];
		
		for (int i = 0; i < boardWidth; i++) {
			columnAlignment[i] = (int)Math.floor(Math.random() * 8); // 0 - 7
		}
		
		return columnAlignment;	
	}
	/** each value of columnAllignment is a position of Queen in a i-th column
	 * 
	 * @param columnAllignment
	 * @return
	 */
	public static boolean isSolution(int[] columnAllignment) {
		int boardWidth = 8;
		// check if each row contains exactly one queen
		for(int i = 0; i < boardWidth; i++) {
			for(int j = i + 1; j < boardWidth; j++) {
				if (columnAllignment[i] == columnAllignment[j])
					return false;
			}
		}
		// check for diagonal crossing down-stream
		for (int i = 0; i < boardWidth; i++) {	
			for (int j = i + 1; j < boardWidth; j++) {
				if (columnAllignment[j] == (columnAllignment[i] - (j - i)))
					return false;
			}					
		}
		// check for diagonal crossing up-stream
		for (int i = 0; i < boardWidth; i++) {	
			for (int j = i + 1; j < boardWidth; j++) {
				if (columnAllignment[j] == (columnAllignment[i] + (j - i)))
					return false;
			}					
		}
		
		return true;
	}
}
