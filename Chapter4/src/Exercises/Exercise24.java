package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise24 {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);

		String[] input = new String[3];
		String[] printText = {"first", "second", "third"};

		for (int i = 0; i < input.length; i ++) {

			System.out.print("Enter the " + printText[i] + " string: ");
			while(true) {
				if (scanner.hasNextLine()) {
					input[i] = scanner.nextLine();
					break;
				}
			}
		}
		scanner.close();

		Arrays.sort(input);
		System.out.print("The three cities in alphabetical order are ");
		for (String s : input)
			System.out.print(s + " ");
		System.out.println();
	}
}
