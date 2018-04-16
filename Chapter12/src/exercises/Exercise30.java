package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a file name:");
		File file = new File(scanner.next());
		scanner.close();
		
		if (!file.exists()) {
			System.out.println("File does not exist." );
			System.exit(1);
		}
		if (!file.isFile()) {
			System.out.println(file.getAbsolutePath() + " is not a file.");
			System.exit(2);
		}
		
		int[] occurrences = new int[(int)'Z' - (int)'A' + 1];
		
		try (Scanner input = new Scanner(file)) {
			
			while(input.hasNext()) {
				String temp = input.next();
				
				//go through each letter
				for(int i = 0; i < temp.length(); i++) 
					if(Character.isLetter(Character.toUpperCase(temp.charAt(i))))
						occurrences[Character.toUpperCase(temp.charAt(i)) - (int)'A']++;
				}						
			
				//print the result
				for(int i = 0; i < occurrences.length; i++)
					System.out.println("Number of " + (char)(i + 'A') + "'s: " + occurrences[i]);
								
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
	}
}
