package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise41 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> integers = new ArrayList<>();
		int temp;
		
		System.out.print("Enter integers (end with 0): ");
		while(true) {
			if (scanner.hasNextInt()) {
				temp = scanner.nextInt();
				integers.add(temp);
				if (temp == 0)
					break;
			}
			else scanner.next();
				
		}
		scanner.close();
		
		int max = Integer.MIN_VALUE;
		int occurrenceCount = 0;
		
		for (int i = 0; i < integers.size(); i++) {
			if (integers.get(i) > max) {
				max = integers.get(i);
				occurrenceCount = 1;
			}
			else if (integers.get(i) == max) 
				occurrenceCount++;
		}

		System.out.println("The largest integer is " + max + " and it occurres " + occurrenceCount
				+ " times.");
		
	}
}
