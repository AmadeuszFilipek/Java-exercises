package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of balls to drop: ");
		int numberOfBalls = scanner.nextInt();
		
		System.out.print("Enter the number of slots in the bean machine: ");
		int numberOfSlots = scanner.nextInt();
		
		scanner.close();
		
		String[] ballPaths = new String[numberOfBalls];
		int[] slots = new int[numberOfSlots];
		for (int i = 0; i < numberOfBalls; i++) {
			
			ballPaths[i] = generatePath(numberOfSlots - 1);
			slots[analysePath(ballPaths[i])]++;
			
			System.out.println(ballPaths[i]);
		}
		
		// it would be nicer to insert i = MAX(slots)
		for(int i = numberOfBalls; i >= 1; i--) {
			for (int j = 0; j < slots.length; j++) {
				if (slots[j] >= i) 
					System.out.print("0");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static String generatePath(int numberOfNails) {
		
		StringBuilder output = new StringBuilder();
		boolean isLeft;
		for (int i = 0; i < numberOfNails; i++) {
			isLeft = (Math.random() - 0.5) > 0;
			if (isLeft)
				output.append('L');
			else
				output.append('R');
		}
		
		return output.toString();
	}
	
	public static int analysePath(String path) {
		
		int numberOfRights = 0;
		for(int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'R')
				numberOfRights++;
		}
		
		return numberOfRights;
	}
}
