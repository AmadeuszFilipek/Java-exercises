package Exercises;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int inputValue;
		
		System.out.print("Scissor(0) rock (1), paper (2): ");
		while(true) {
			if (scanner.hasNextInt()) {
				inputValue = scanner.nextInt();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		int opponentValue = (int)(Math.random() * 3);
		
		if (inputValue == 0) { // scissors
			switch(opponentValue) {
			case 0: System.out.println("The computer is scissor. It's a draw"); break;
			case 1: System.out.println("The computer is rock. You lose."); break;
			case 2: System.out.println("The computer is paper. You win."); break;
			default : break;
			}
		}
		else if (inputValue == 1) { // rock
			switch (opponentValue) {
			case 0: System.out.println("The computer is scissor. You win."); break;
			case 1: System.out.println("The computer is rock. Its a draw."); break;
			case 2: System.out.println("The computer is paper. You lose."); break;
			default : break;
			}
		}
		else if(inputValue == 2) { // paper
			switch (opponentValue) {
			case 0: System.out.println("The computer is scissor. You lose."); break;
			case 1: System.out.println("The computer is rock. You win."); break;
			case 2: System.out.println("The computer is paper. It's a draw."); break;
			default : break;
			}		
		}
		else {
			System.out.println("Wrong input");
			System.exit(1);
		}
			
	}
}
