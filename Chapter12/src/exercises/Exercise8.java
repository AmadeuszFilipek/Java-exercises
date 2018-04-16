package exercises;

import java.util.Scanner;

public class Exercise8 {

	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a hex number: ");
		String hex = input.nextLine();
		input.close();
		try {
			System.out.println("The decimal value for hex number "
					+ hex + " is " + hexToDecimal(hex.toUpperCase()));
		}
		catch(HexFormatException e) {
			System.out.println(e);
		}
	}

	public static int hexToDecimal(String hex) throws HexFormatException {
		
		if(!hex.matches("[0-9A-F]+"))
				throw new HexFormatException(hex);
		
		int decimalValue = 0;
		for (int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}

		return decimalValue;
	}

	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else // ch is '0', '1', ..., or '9'
			return ch - '0';
	}
	
	@SuppressWarnings("serial")
	public static class HexFormatException extends Exception {
		
		public HexFormatException(String hex) {
			super("Wrong input: \"" + hex + "\"");
		}
	}
}
