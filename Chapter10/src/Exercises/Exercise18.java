package Exercises;

import java.math.BigInteger;

public class Exercise18 {

	public static void main(String[] args) {
	// five prime numbers larger than Long.MAX_VALUE	
	// did not wait through with the execution, took too much time
		
		StringBuilder val = new StringBuilder();
		val.append(Long.MAX_VALUE);
		
		BigInteger number = new BigInteger(val.toString());
		
		System.out.println("Five primes larger than long.max");
		int found = 0;
		while (found < 5) {
			if (isPrime(number)) {
				found++;
				System.out.println(number);
			}	
			number = number.add(BigInteger.ONE);
		}
		
		
	}
	//by far not optimal
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
