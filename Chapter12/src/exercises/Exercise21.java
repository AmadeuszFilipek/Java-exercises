package exercises;

import java.io.File;
import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
						
		File file = new File("C:\\Amadeusz_all_files\\Java\\Chapter12/src/SortedStrings.txt");
		
		try {
			if(file.exists() && file.isFile()) {
				
				Scanner input = new Scanner(file);
				String previous = null, actual = null;
				boolean isSorted = true;
				
				// go through the file
				while(input.hasNext()) {
					
					previous = actual;
					actual = input.next();
					
					//check if the content of the file is sorted
					if(previous != null && actual != null)
						if (actual.compareTo(previous) < 0) {
							System.out.println("Out of order strings: \"" + previous + "\" and \"" + actual + "\"");
							isSorted = false;
							break;
						}	
				}
				input.close();
				
				if(isSorted)
					System.out.println("The strings in the file are sorted in increasing order.");
			}
			else
				System.out.println("Could not find the file.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
