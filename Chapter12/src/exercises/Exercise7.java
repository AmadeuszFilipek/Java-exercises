package exercises;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a binary number: ");
		String input = scanner.next();
		
		try {
			System.out.println("Decimal value of " + input + " is : " + bin2Dec(input));
		} catch(NumberFormatException e) {
			System.out.println(e);
		} finally {
			scanner.close();
		}
		
	}
	
	public static int bin2Dec(String binaryString) throws NumberFormatException {
		if (!binaryString.matches("[01]+"))
			throw new NumberFormatException("Wrong input: \"" + binaryString + "\"");
		
		int result = 0;
		for(int i = 0; i < binaryString.length(); i++) {
			result *= 2;
			if (binaryString.charAt(i) == '1')
				result++;
		}
		
		return result;
	}
}
