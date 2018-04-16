package Exercises;

import java.util.Scanner;

public class Exercise37 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a integer number and it's width: ");
		int number = scanner.nextInt();
		int width = scanner.nextInt();
		scanner.close();
		
		System.out.println("Padded string: " + format(number, width));
		
	}
	
	public static String format(int number, int width) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		
		if (temp.length() >= width)
			return temp.toString();
		
		temp.reverse();
		
		for (int i = temp.length(); i < width; i++) {
			temp.append('0');
		}
		
		return temp.reverse().toString();
	}
}
