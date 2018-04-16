package Exercises;

import java.math.BigInteger;

public class Exercise17 {

	public static void main(String[] args) {
		
		StringBuilder val = new StringBuilder();
		
		//i used the math. sqrt on long value overcoming the problem of writing my own sqrt for BigInteger
		//or looping and checking if the number is indeed squared
		val.append((long)Math.ceil(Math.sqrt(Long.MAX_VALUE)));
		
		BigInteger number = new BigInteger(val.toString());
		
		int found = 0;
		System.out.println("Long.MAX : " + Long.MAX_VALUE);
		
		// they have to be greater that long.max because i start with sqrt of long.max
		while (found < 10) {
			System.out.print(number);
			found++;
			System.out.println(" || " + number.multiply(number));
			number = number.add(BigInteger.ONE);
		}

	}
}
