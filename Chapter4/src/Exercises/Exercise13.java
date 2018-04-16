package Exercises;

import java.util.Scanner;

public class Exercise13 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a letter: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		char c = input.charAt(0);
		// W and Y are somewhat arguably, implemented as in Polish
		char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
												 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W'};
		
		char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y', 'Ó'};
		boolean isConsonant = false, isVowel = false;
		
		for (int i = 0; i < consonants.length; i ++) {
			if (c == Character.toLowerCase(consonants[i])) {
				isConsonant = true;
				break;
			}
			if (c == consonants[i]) {
				isConsonant = true;
				break;
			}
		}
		if (!isConsonant) {
			for (int i = 0; i < vowels.length; i++) {
				if (c == Character.toLowerCase(vowels[i])) {
					isVowel = true;
					break;
				}
				if (c == vowels[i]) {
					isVowel = true;
					break;
				}			
			}
		}
		
		//print results
		if (isConsonant)
			System.out.println(c + " is a consonant");
		else if(isVowel)
			System.out.println(c + " is a vowel");
		else
			System.out.println(c + " is invalid input");
	
	}
}
