package Exercises;

import java.util.Arrays;

public class Exercise23 {

	public static void main(String[] args) {
	
		boolean[] lockers = lockerPuzzle();
		printPuzzle(lockers);
		
		
	}
	
	public static void printPuzzle(boolean[] lockers) {
		
		for(int i = 0; i < lockers.length; i++) {
			if (lockers[i])
				System.out.print("L" + (i + 1) + " ");			
		}
	}
	
	public static boolean[] lockerPuzzle() {
		boolean[] lockers = new boolean[100];
		Arrays.fill(lockers, false);
		
		for (int i = 0; i < lockers.length; i++) {
			for(int j = i; j < lockers.length; j++) {
				if (i == 0 || j % i == 0)
					lockers[j] = ! lockers[j];
			}
		}
		
		return lockers;
	}
	
}
