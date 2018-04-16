package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise32 {

	/** this program does not work because there is no data on the web-side anymore */
	public static void main(String[] args) {

		System.out.printf("Year\tRank 1\tRank 2\tRank 3\tRank 4\tRank 5\tRank 1\tRank 2\tRank 3\tRank 4\tRank 5\n");
		//connect to the data and search through it
		try {
			for (int year = 2010; year > 2000; year--) {
				URL url = new URL("http://www.ssa.gov/oact/babynames" + "/babynameranking" + year + ".txt");

				Scanner input = new Scanner(url.openStream());
				ArrayList<String> boyNames = new ArrayList<>();
				ArrayList<String> girlNames = new ArrayList<>();

				// read the top 5 names
				for(int i = 0; i < 5; i++) {

					if (input.hasNextLine()) {

						// read a line, given the data structure
						input.nextInt();											// rank
						boyNames.add(input.next());
						input.nextInt();						 					// number of boys
						girlNames.add(input.next());		
						input.nextInt(); 											// number of girls

					}
				}
				input.close();
				
				if (boyNames.size() >= 5 && girlNames.size() >= 5)
					System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", year, 
							boyNames.get(0), boyNames.get(1), boyNames.get(2), boyNames.get(3), boyNames.get(4),
							girlNames.get(0), girlNames.get(1), girlNames.get(2), girlNames.get(3), girlNames.get(4)	
							);

			}
		}
		catch(MalformedURLException e) {
			System.out.println("URL error");
		}
		catch(IOException e) {
			System.out.println("Input/output error. No such file.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
