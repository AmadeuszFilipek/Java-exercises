package Exercises;

import java.util.Scanner;

public class Exercise34 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int inputValue;
		int userScore = 0;
		int computerScore = 0;

		while(true) {
	
			System.out.print("Scissor(0) rock (1), paper (2): ");
			while(true) {
				if (scanner.hasNextInt()) {
					inputValue = scanner.nextInt();
					break;
				}
				else 
					scanner.nextLine();
			}
			
			int opponentValue = (int)(Math.random() * 3);

			if (inputValue == 0) { // scissors
				switch(opponentValue) {
				case 0: System.out.println("The computer is scissor. It's a draw"); break;
				case 1: System.out.println("The computer is rock. You lose."); computerScore++; break;
				case 2: System.out.println("The computer is paper. You win."); userScore++; break;
				default : break;
				}
			}
			else if (inputValue == 1) { // rock
				switch (opponentValue) {
				case 0: System.out.println("The computer is scissor. You win."); userScore++; break;
				case 1: System.out.println("The computer is rock. Its a draw."); break;
				case 2: System.out.println("The computer is paper. You lose."); computerScore++; break;
				default : break;
				}
			}
			else if(inputValue == 2) { // paper
				switch (opponentValue) {
				case 0: System.out.println("The computer is scissor. You lose."); computerScore++; break;
				case 1: System.out.println("The computer is rock. You win."); userScore++; break;
				case 2: System.out.println("The computer is paper. It's a draw."); break;
				default : break;
				}		
			}
			else {
				System.out.println("Wrong input");
				continue;
			}
		
			if (userScore > 2 + computerScore) {
				System.out.println("You have won more than two times than computer. Congratulations.");
				break;
			}
			if (computerScore > 2 + userScore) {
				System.out.println("Computer have won more than two times than you. You have lost.");
				break;
			}
			
		}
		
		scanner.close();
	}
}