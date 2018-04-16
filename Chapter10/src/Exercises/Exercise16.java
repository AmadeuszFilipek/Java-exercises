package Exercises;

import java.math.BigInteger;

public class Exercise16 {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append('1');
		for(int i = 1; i < 50; i++)
			str.append('0');
		
		BigInteger number = new BigInteger(str.toString());
		
		int found = 0;
		while (found < 10) {
			if(number.remainder(new BigInteger("2")).equals(BigInteger.ZERO) || 
				 number.remainder(new BigInteger("3")).equals(BigInteger.ZERO)) {
				found++;
				System.out.println(number);
			}
			
			number = number.add(BigInteger.ONE);		
		}
	}
}
