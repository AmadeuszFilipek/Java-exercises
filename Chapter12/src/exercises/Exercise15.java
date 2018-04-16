package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exercise15 {

	public static void main(String[] args) {


		File file = new File("Exercise12_15.txt");
		
		//create file and fill it with data
		if(!file.exists()) {
			try(PrintWriter input = new PrintWriter(file)) {
				
				//input random data delimited with space
				Random rng = new Random();
				for(int i = 0; i < 100; i++) {
					input.print(rng.nextInt(100) + " ");
				}		
				
			} catch(FileNotFoundException e) {
				System.out.println(e);
				System.exit(1);
			}	
		}
		
	
		//read the data back
		try (Scanner fileContent = new Scanner(file)) {
			ArrayList<Integer> scores = new ArrayList<>();
			
			//collect all the scores in file
			while(fileContent.hasNext()) {
				if (fileContent.hasNextInt()) {
					scores.add(fileContent.nextInt());
				}
				else fileContent.next();		
			}
			
			// sort the array and print the result
			scores.sort(null);
			System.out.println(scores);
			
		} catch(Exception e){
			System.out.println(e);
			System.exit(3);
		}
	}
}
