package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Exercise31 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = scanner.nextInt();
		if (year < 2001 || year > 2010) {
			System.out.println("No data for given year");
			System.exit(1);
		}
		
		System.out.print("Enter the gender: ");
		char gender = scanner.next().charAt(0);
		
		if (gender != 'M' && gender != 'F') {
			System.out.println("Invalid gender input. M - male, F - female.");
			System.exit(2);
		}
		
		System.out.println("Enter the name: ");
		String name = scanner.next();
		scanner.close();
		
		//connect to the data and search through it
		try {
			
			URL url = new URL("http://www.ssa.gov/oact/babynames" + "/babynameranking" + year + ".txt");
			
			Scanner input = new Scanner(url.openStream());
			boolean isRanked = false;
			
			//look through whole year data for the name
			while(input.hasNextLine()) {
				
				// read a line, given the data structure
				int rank = input.nextInt();
				String maleName = input.next();
				input.nextInt();						 					// number of boys
				String femaleName = input.next();			
				input.nextInt(); 											// number of girls
				
				System.out.println(maleName);
				if(gender == 'M') {
					if (maleName.equals(name)) {
						System.out.println(name + " is ranked #" + rank + " in year " + year);
						isRanked = true;
						break;
					}
				}
				else if (gender == 'F') {
					if(femaleName.equals(name)) {
						System.out.println(name + " is ranked #" + rank + " in year " + year);
						isRanked = true;
						break;
					}
				}
			}
			input.close();
			
			if(!isRanked)
				System.out.println("The name " + name + " is not ranked in year " + year);
					
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
