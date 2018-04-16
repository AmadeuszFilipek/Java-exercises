package Exercises;

import java.util.Scanner;

public class Exercise37 {

	public static void main(String[] args) { 
		
		Scanner scanner = new Scanner(System.in);
		String[][] capitals = { {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}};
		
		int correctCount = 0;
		for(int i = 0; i < capitals.length; i++) {
			System.out.println("What is the capital of " + capitals[i][0]);
			String input = scanner.next();
			
			if (input == capitals[i][1]) {
				correctCount++;
				System.out.println("Your answer is correct");
			}
			else {
				System.out.println("The correct answer should be " + capitals[i][1]);
			}		
		}
			
		System.out.println("The correct count is " + correctCount);
		scanner.close();
	}
}
