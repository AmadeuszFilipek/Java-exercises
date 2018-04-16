package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
			Scanner input = new Scanner(url.openStream());
			ArrayList<Integer> scores = new ArrayList<>();
			
			while(input.hasNext()) {
				if (input.hasNextInt()) {
					scores.add(input.nextInt());
				}
				else input.next();
			}
			input.close();
			
			System.out.println("Total score: " + sum(scores));
			System.out.println("Average score: " + average(scores));
		}
		catch(MalformedURLException e) {
			System.out.println("Wrong URL");
		}
		catch(IOException e) {
			System.out.println("Input/output error: no such file.");
		}
	}
	
	public static double sum(ArrayList<Integer> array) {
		double sum = 0;
		
		for(Integer i : array)
			sum += i;
		
		return sum;
	}
	
	public static double average(ArrayList<Integer> array) {
		
		return sum(array) / array.size();
	}
}
