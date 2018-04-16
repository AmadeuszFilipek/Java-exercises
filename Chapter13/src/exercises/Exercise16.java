package exercises;

import java.math.BigInteger;
import exercise15.Rational;

public class Exercise16 {
	/** Main method */
	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length != 1) {
			System.out.println(
					"Usage: java Calculator \"operand1 operator operand2\"");
			System.exit(0);
		}
		
		if (!args[0].matches("[0-9]+/[0-9]+\\s*[+\\-*/]\\s*[0-9]+/[0-9]+")) {
			System.out.println("Invalid input. Expected input : \"rational1 operator rational2\". Eg. 1/2 + 1/2");
			System.exit(1);
		}
		
		//get the operator symbol
		String[] whiteSplit = args[0].split("\\s+");
		char operator = whiteSplit[1].trim().charAt(0);
		
		//get the operands
		String[] split = args[0].trim().split("[+\\-*/]");
		Rational operand1 = new Rational(new BigInteger(split[0].trim()), new BigInteger(split[1].trim()));
		Rational operand2 = new Rational(new BigInteger(split[2].trim()), new BigInteger(split[3].trim()));
		
		// The result of the operation
		Rational result = null;

		// Determine the operator and get the result
		switch (operator) {
		case '+': result = operand1.add(operand2);
		break;
		case '-': result = operand1.subtract(operand2);
		break;
		case '*': result = operand1.multiply(operand2);
		break;
		case '/': result = operand1.divide(operand2);
		}

		// Display result
		System.out.println(operand1 + " " + operator + " " + operand2
				+ " = " + result);
	}
}

