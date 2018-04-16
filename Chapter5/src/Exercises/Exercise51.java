package Exercises;

import java.util.Scanner;

public class Exercise51 {


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first string: ");
		String input1 = scanner.nextLine();
		System.out.print("Enter the second string: ");
		String input2 = scanner.nextLine();
		scanner.close();
		
		int longestLength = 0;
		boolean isCommonPrefix = false;
		
		// longest common prefix...
		for (int i = 1; i < Math.min(input1.length(), input2.length()); i++) {
			if (input1.regionMatches(0, input2, 0, i)) {
				if (i > longestLength)
					longestLength = i;
				isCommonPrefix = true;
			}
		}
		
		if (isCommonPrefix) 
			System.out.println("The longest common prefix is " + input1.substring(0, longestLength));
		else
			System.out.println(input1 + " and " + input2 + " have no common prefix");
		
	}
}
