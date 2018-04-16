package Exercises;

import java.math.BigInteger;

public class Exercise19 {

	public static void main(String[] args) {
		// This task needs quite some time run through
		// so i skipped the full execution
		BigInteger number = new BigInteger("1");
		
		System.out.printf("p\t\t2*p - 1\n\n");
		for (int p = 2; p <= 100; p++) {
			number = number.multiply(new BigInteger("2")).add(BigInteger.ONE);
			if (isPrime(number))
				System.out.printf("%d\t\t%s\n", p, number.toString());
			
		}
	}
	
	public static boolean isPrime(BigInteger candidate) {
		
		BigInteger top = candidate.divide(new BigInteger("2"));
		for(BigInteger i = new BigInteger("2"); i.compareTo(top) <= 0; i = i.add(BigInteger.ONE)) {
			if (candidate.remainder(i).equals(new BigInteger("0"))) {
					return false;
			}
		}	
		return true;
	}
}
