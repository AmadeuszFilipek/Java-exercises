package Exercises;

import java.util.Scanner;

public class Exercise22 {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String input1, input2;
		
		System.out.println("Enter a string s1: ");
		while(true) {
			if (scanner.hasNext()) {
				input1 = scanner.next();
				break;
			}
			else 
				scanner.nextLine();
		}
		
		System.out.println("Enter a string s2: ");
		while(true) {
			if (scanner.hasNext()) {
				input2 = scanner.next();
				break;
			}
			else 
				scanner.nextLine();
		}
		scanner.close();
		
		if (input1.contains(input2))
			System.out.println(input2 + " is a substring of " + input1);
		else
			System.out.println(input2 + " is not a substring of " + input1);
	}
}
