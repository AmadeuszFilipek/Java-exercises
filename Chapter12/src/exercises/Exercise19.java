package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Exercise19 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			Scanner scanner = new Scanner(url.openStream());
			int wordsCount = 0;
			
			while(scanner.hasNext()) {
				wordsCount++;
				scanner.next();
			}
			scanner.close();
			
			System.out.println("File has " + wordsCount + " words.");
			scanner.close();
		}
		catch(MalformedURLException e) {
			System.out.println("Invalid URL");
		}
		catch (IOException e) {
			System.out.println("Input/output error: no such file");
		} 		
	}	
}
