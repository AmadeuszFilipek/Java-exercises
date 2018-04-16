package Exercises;

import java.util.Scanner;

public class Exercise18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Enter two characters: ");
		while(true) {
			if (scanner.hasNext()) {
				input = scanner.next();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		String[] fieldStatus = {"Mathematics", "Computer Science", "Information Technology"};
		String[] levelStatus = {"freshman", "sophomore", "junior", "senior"};
		String result = new String("");
		
		if (input.matches("[MCI][1-4]")) {
			switch (input.charAt(0)) {
				case 'M': result += fieldStatus[0]; break;
				case 'C': result += fieldStatus[1]; break;
				case 'I': result += fieldStatus[2]; break;
				default : break;
			}
			result += " ";
			int code = (int)input.charAt(1) - 48; // 0 is 48 in ASCII
			result += levelStatus[code - 1]; // -1 because of 1-4 numeration	
		}
		else 
			result = "Invalid input";
		
		System.out.println(result);	
	}
}
