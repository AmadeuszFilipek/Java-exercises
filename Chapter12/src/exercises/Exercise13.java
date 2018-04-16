package exercises;

import java.io.File;
import java.util.Scanner;

public class Exercise13 {
	
	/** uses arguments from commands line */
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: filename");
			System.exit(1);
		}

		File file = new File(args[0]);
		
		if(!file.exists()) {
			System.out.println("The file " + args[0] + " does not exist.");
			System.exit(2);
		}
		
		// count all the characters, words and lines 
		try (Scanner fileContent = new Scanner(file)) {
			
			int lineCount = 0, wordCount = 0, characterCount = 0;
			
			//go through whole file
			while(fileContent.hasNext()) {
				String line = fileContent.nextLine();
				lineCount++;
				
				//split line into words, treat white characters as delimiters
				//and do not count them
				String[] words = line.split("\\s+"); 
				
				for(int i = 0; i < words.length; i++) {
					if(words[i].length() != 0) {
						wordCount++;
						characterCount += words[i].length();
					}
				}
			}
			
			// print the result
			System.out.println("The file " + file.getName() + " has:");
			System.out.println(characterCount + " characters");
			System.out.println(wordCount + " words");
			System.out.println(lineCount + " lines");
			
		} catch(Exception e){
			System.out.println(e);
			System.exit(3);
		}
	}
}
