package Exercises;

import java.util.Scanner;

public class Exercise12 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a hex digit: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();

		if ((int)input.charAt(0) > 47 && (int)input.charAt(0) < 72) 
			System.out.println("The binary value is: " + 
					Integer.toBinaryString(Integer.parseInt(input, 16)));
		else
			System.out.println("Invalid input");
	}
}
