package exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		boolean anotherRound = true;
		Scanner scanner = new Scanner(System.in);
		
		while(anotherRound) {
			
			String wordToGuess = generateWord();
			char[] guessedLetters = new char[wordToGuess.length()];
			Arrays.fill(guessedLetters, '*');
			char input;
			int numberOfMisses = 0;
			
			while(true) {
				
				System.out.print("(Guess) Enter a letter in word " + new String(guessedLetters) + " > ");	
				input = scanner.next().charAt(0);
				
				if (contains(wordToGuess.toCharArray(), input)) {
					
					if(contains(guessedLetters, input))
						System.out.println(input + " is already in a word");
					else 
						updateGuess(wordToGuess, guessedLetters, input);
					
				}
				else {
					System.out.println(input + " is not in a word.");
					numberOfMisses++;
				}
				
				if (Arrays.equals(wordToGuess.toCharArray(), (guessedLetters))) {
					System.out.println("The word is " + wordToGuess + 
							". You missed " + numberOfMisses + " times.");
					System.out.print("Do you want to guess another word ? Enter y or n >");
					input = scanner.next().charAt(0);
					if (input == 'y')
						anotherRound = true;
					else 
						anotherRound = false;
					break;
				}
			}
		}
		scanner.close();
	}
	
	
	public static String generateWord() {
		
		// this pathname is hardcoded
		File file = new File("C:/Amadeusz_all_files/Java/Chapter12/src/exercises/hangman.txt");
		String result = "hangman";
		
		if (file.exists()) {
			try {
				//read all lines
				List<String> lines = Files.readAllLines(file.toPath());
				List<String> words = new ArrayList<>();
				
				for(String line : lines) {
					if(line.matches("[a-z]+"))
					words.add(line.trim());
				}	
				
				Random rng = new Random();
				result = words.get((rng.nextInt(words.size())));
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			return result;
		}
		else {
			System.out.println("Could not open the words file.");
			return result;
		}
	}
	
	public static void updateGuess(String word, char[] guessTable, char letter) {
		int[] guessedWords = guessALetter(word, letter);
		for(int i = 0; i < guessedWords.length; i++) {
			guessTable[guessedWords[i]] = letter;
		}
	}
	public static int[] guessALetter(String word, char letter) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				count++;	
			}
		}
		int[] guessedLetters = new int[count];
		count = 0;
		for(int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				guessedLetters[count] = i;	
				count++;
			}
		}
		return guessedLetters;
	}
	
	public static boolean contains(char[] table, char letter) {
		for (int i = 0; i < table.length; i++) {
			if (table[i] == letter)
				return true;
		}
		
		return false;
	}
}
