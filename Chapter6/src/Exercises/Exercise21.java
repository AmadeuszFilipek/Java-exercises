package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();
		scanner.close();
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			if (getNumber(input.charAt(i)) != -1)
				output.append(getNumber(input.charAt(i)));
			else
				output.append(input.charAt(i));
		}
		
		System.out.println(output.toString());
		
	}
	
	public static int getNumber(char uppercaseLetter) {
		
		char c = Character.toUpperCase(uppercaseLetter); // comment to include lowercase
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
			return result;
		}
		else 
			return result;
	
	}
}
