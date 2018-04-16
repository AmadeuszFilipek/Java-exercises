package Exercises;

import java.math.BigInteger;

public class Exercise21 {


	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append(Long.MAX_VALUE);
		
		BigInteger number = new BigInteger(str.toString());
		
		int found = 0;
		while (found < 10) {
			if(number.remainder(new BigInteger("5")).equals(BigInteger.ZERO) || 
				 number.remainder(new BigInteger("6")).equals(BigInteger.ZERO)) {
				found++;
				System.out.println(number);
			}
			
			number = number.add(BigInteger.ONE);		
		}
	}
}
