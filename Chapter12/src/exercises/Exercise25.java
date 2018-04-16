package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise25 {

	public static void main(String[] args) {
		
		String[] ranks = {"assistant", "associate", "full"};
		
		try {
			URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
			Scanner input = new Scanner(url.openStream());
			ArrayList<String> rank = new ArrayList<>();
			ArrayList<Double> salary =  new ArrayList<>();
			
			// read all the data
			while(input.hasNext()) {
				
				String temp = input.next();
				
				if (temp.equals(ranks[0]) || temp.equals(ranks[1]) || temp.equals(ranks[2])) {
					if(input.hasNextDouble()) {
						rank.add(temp);
						salary.add(input.nextDouble());
					}		
				}		
			}
			input.close();
			
			// print the data
			for (int i = 0; i < 3; i++) {
				System.out.println("Total salary for  " + ranks[i] + ": " + sum(salary, rank, i));
				System.out.println("Average salary for " + ranks[i] + ": " + average(salary, rank, i));
			}
		}
		catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		}
		catch (IOException e) {
			System.out.println("The file does not exist.");
		}
	}
	
	public static double sum(ArrayList<Double> array, ArrayList<String> rankList, int rank) {
		if (array.size() != rankList.size())
			return 0;
		
		String[] ranks = {"assistant", "associate", "full"};
		
		double sum = 0;
		
		for(int i = 0; i < array.size(); i++) {
			if(rankList.get(i).equals(ranks[rank]))
				sum += array.get(i);
		}
		
		return sum;
	}
	
	public static double average(ArrayList<Double> array, ArrayList<String> rankList, int rank) {	
		String[] ranks = {"assistant", "associate", "full"};
		int rankCount = 0;
		
		for(String s: rankList)
			if (s.equals(ranks[rank]))
				rankCount++;
		
		return sum(array, rankList, rank) / rankCount;
	}
}
