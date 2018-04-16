package Exercises;

import java.util.Scanner;

public class Exercise9 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[3][3];
		int row, column;
		displayBoard(board);
		
		while(true) {
			while(true) {
				System.out.print("Enter a row (0, 1, 2) for player X: ");
				row = scanner.nextInt();
				System.out.print("Enter a column (0, 1, 2) for player X: ");
				column = scanner.nextInt();
				if (updateBoard(board, 'X', row, column))
					break;
			}
			displayBoard(board);
			if(isGameEnded(board, 'X'))
				break;
			
			while(true) {
				System.out.print("Enter a row (0, 1, 2) for player 0: ");
				row = scanner.nextInt();
				System.out.print("Enter a column (0, 1, 2) for player 0: ");
				column = scanner.nextInt();
				if (updateBoard(board, '0', row, column))
					break;
			}
			displayBoard(board);
			if(isGameEnded(board, '0'))
				break;
		}
		scanner.close();
	}
	
	public static boolean updateBoard(char[][] board, char playerSign, int row, int column) {
		if (board[row][column] == 'X' || board[row][column] == '0') {
			System.out.println("Place [" + row + ", " + column + "] already taken.");
			return false;
		}
			board[row][column] = playerSign;
		
		return true;
	}
	public static void displayBoard(char[][] board) {
												
		System.out.println("-------------");
		for(int i = 0; i < board.length; i ++) {
			System.out.print("|");
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(" " + board[i][j] + " |");
				
			}
			System.out.println();
			System.out.println("-------------");
			
		}
	}
	
	public static boolean isGameEnded(char[][] board, char playerSign) {
		//check columns and rows 
		for(int i = 0; i < board.length; i++) {
			if (board[i][0] == playerSign && board[i][1] == playerSign && board[i][2] == playerSign) {
				System.out.println("Player " + playerSign + " wins.");
				return true;
			}
			if (board[0][i] == playerSign && board[1][i] == playerSign && board[2][i] == playerSign) {
				System.out.println("Player " + playerSign + " wins.");
				return true;
			}	
		}
		// check diagonals
		if (board[0][0] == playerSign && board[1][1] == playerSign && board[2][2] == playerSign) {
			System.out.println("Player " + playerSign + " wins.");
			return true;
		}
		if (board[0][2] == playerSign && board[1][1] == playerSign && board[2][0] == playerSign) {
			System.out.println("Player " + playerSign + " wins.");
			return true;
		}
		return false;
	}
}
