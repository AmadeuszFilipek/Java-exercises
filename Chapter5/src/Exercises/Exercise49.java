package Exercises;

import java.util.Scanner;

public class Exercise49 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
				 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W'};

		char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y', 'Ó'};
		int numberOfConsonants = 0;
		int numberOfVowels = 0;
		boolean isConsonant = false, isVowel = false;
		char c;
		
		for (int j = 0; j < input.length(); j ++) {
			isConsonant = false;
			isVowel = false;
			c = input.charAt(j);

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

			if (isVowel)
				numberOfVowels++;
			else if(isConsonant)
				numberOfConsonants++;
		}
		
		System.out.println("Number of vowels is " + numberOfVowels);
		System.out.println("Number of consonants is " + numberOfConsonants);
	}
}
