package exercises;

import java.math.BigInteger;
import java.util.Scanner;

import exercise15.Rational;

public class Exercise19 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a decimal number: ");
		String number = scanner.next();
		
		//check if this number is negative
		boolean isNegative = number.charAt(0) == '-';
	
		// construct the rational part of the number
		String[] split = number.split("\\.");
		Rational rational = new Rational(
														new BigInteger(split[1]),
														new BigInteger(Integer.toString((int)Math.pow(10, split[1].length())))
														);
		
		//add the integer part of the value
		rational = rational.add(new Rational(new BigInteger(split[0]), BigInteger.ONE));
		System.out.println(rational);
		
		//switch the value to negative if necessary
		if (isNegative) {
			rational = new Rational(rational.getNumerator().negate(), rational.getDenominator());
		}
		
		System.out.println(rational);
		scanner.close();
	}
}
