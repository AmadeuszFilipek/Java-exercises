package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Exercise24 {

	public static void main(String[] args) {
		
		File file = new File("Salary.txt");
		String[] ranks = {"assistant", "associate", "full"};
		int[][] ranges = {{50000, 80000}, {60000, 110000}, {75000, 130000}};
		
		try(PrintWriter input = new PrintWriter(file)) {
			Random rng = new Random();
			
			// write the content
			for(int i = 1; i<= 1000; i++) {
				int rank = rng.nextInt(3);
				double salary = rng.nextInt(ranges[rank][1] - ranges[rank][0]) + ranges[rank][0] + rng.nextDouble();
				input.printf("FirstName" + i + " LastName" + i + " " + ranks[rank] + " %.2f", salary);
				input.println();
			}
		
		}
		catch(FileNotFoundException e) {
			System.out.println();
		}
	}
}
