package exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise14 {
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
		
		try (Scanner fileContent = new Scanner(file)) {
			ArrayList<Double> scores = new ArrayList<>();
			
			//collect all the scores in file
			while(fileContent.hasNext()) {
				if (fileContent.hasNextDouble()) {
					scores.add(fileContent.nextDouble());
				}
				else fileContent.next();		
			}
			
			// print the result
			System.out.println("Total score : " + sum(scores));
			System.out.println("Average score: " + average(scores));
			
		} catch(Exception e){
			System.out.println(e);
			System.exit(3);
		}
	}
	
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		
		for(Double i: list) 
			sum += i;
		
		return sum;
	}
	
	public static double average(ArrayList<Double> list) {
		
		return sum(list) / list.size();
	}
}
