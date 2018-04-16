package Exercises;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		// factorizing an integer number
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of lines: ");
		while(true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}
			else scanner.next();			
		}
		scanner.close();

		
		StringBuilder pyramid = new StringBuilder("");
		
		for(int line = 1; line <= number; line++){
		  for (int col = number; col > 1; col--) {
		  	if (col <= line)
		  		pyramid.append(' ').append(col).append(' ');
		  	else
		  		pyramid.append(' ').append(' ').append(' ');
		  }
		  for (int col = 1; col <= number; col++) {
		  	if (col <= line)
		  		pyramid.append(' ').append(col).append(' ');
		  	else
		  		pyramid.append(' ').append(' ').append(' ');
	  }
		  pyramid.append('\n');
		}
		
	System.out.println(pyramid);
	}
}
