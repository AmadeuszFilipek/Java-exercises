package Exercises;

import java.util.Scanner;

public class Exercise15 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a letter grade: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
	
		char c = input.charAt(0);
		int result = -1;
		char[][] charTable = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
				{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
				{'w', 'x', 'y', 'z'}};
		
		
		for (int i = 0; i < charTable.length; i++)
			for(int j = 0; j < charTable[i].length; j++) {
				if (c == charTable[i][j]) {
					result = i;
					break;
				}
				if (c == Character.toUpperCase(charTable[i][j])) {
					result = i;
					break;
				}
			}
		if (result != -1) {
			result = result + 2;
			System.out.println("The corresponding number is " + result);
		}
		else 
			System.out.println(c + " is an invalid input");
		
	}
}
