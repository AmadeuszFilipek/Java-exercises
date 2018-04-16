package Exercises;

import java.util.Scanner;

public class Exercise20 {
	
	/** The game of four circles on a 6 x 7 matrix, player wins if he connects
	 * four of his colored circles in a row, column or diagonal.
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[6][7];
		int column;
		displayBoard(board);
		
		while(true) {
			
			while(true) {
				System.out.print("Drop a red disk at column (0-6): ");
				column = scanner.nextInt();
				if (updateBoard(board, 'R', column))
					break;
			}
			
			displayBoard(board);
			if(isGameEnded(board, 'X'))
				break;
			
			while(true) {
				System.out.print("Drop a yellow disk at column (0-6): ");
				column = scanner.nextInt();
				if (updateBoard(board, 'Y', column))
					break;
			}
			
			displayBoard(board);
			if(isGameEnded(board, 'Y'))
				break;
		}
		scanner.close();	
	}
	
	public static boolean isGameEnded(char[][] board, char playerSign) {
		
		if(isConsecutiveFour(board, playerSign)) {
			if (playerSign == 'R')
				System.out.println("The red player won");
			else
				System.out.println("The yellow player won");
			
			return true;
		}
			
		return false;
	}

	public static boolean updateBoard(char[][] board, char playerSign, int column) {
		
		// check if the column is filled
		if (board[0][column] == 'R' || board[0][column] == 'Y') {
			System.out.println("That column is already filled.");
			return false;
		}
		
		for(int i = board.length - 1; i >= 0; i--) {
			if(board[i][column] != 'R' && board[i][column] != 'Y') {
				board[i][column] = playerSign;	
				break;
			}
		}
		
		return true;
	} 
	
	public static boolean isConsecutiveFour(char[][] values, char sign) {
		// check vertically
		for(int i = 0; i < values.length; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j] == sign &&
					  values[i][j + 1] == sign &&
					  values[i][j + 2] == sign &&
					  values[i][j + 3] == sign)
					return true;
		
		// check horizontally
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length; j++)
				if (values[i][j] == sign &&
						values[i + 1][j] == sign &&
				    values[i + 2][j] == sign &&
				    values[i + 3][j] == sign)
				 	return true;
		
		//check diagonally down-stream orientation
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j] == sign &&
						values[i + 1][j + 1] == sign &&
				    values[i + 2][j + 2] == sign &&
				    values[i + 3][j + 3] == sign)
					return true;
		
		//check diagonally up-stream orientation
		for(int i = values.length - 1; i >= 3; i--)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j] == sign &&
					  values[i - 1][j + 1] == sign &&
						values[i - 2][j + 2] == sign &&
					  values[i - 3][j + 3] == sign)
					return true;
		
		return false;				
	}
	
	public static void displayBoard(char[][] board) {
		
		System.out.println("------------------------------");
		for(int i = 0; i < board.length; i ++) {
			System.out.print("|");
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(" " + board[i][j] + " |");
				
			}
			System.out.println();
			System.out.println("------------------------------");
			
		}
	}
}
