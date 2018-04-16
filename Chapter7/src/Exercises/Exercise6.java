package Exercises;

public class Exercise6 {

	
	public static void main(String[] args) {
		
		int[] primes = new int[50];
		int n = 2;
		int count = 0;
		
		while(count < 50) {
			if (isPrime(n, primes)) {
				primes[count] = n;
				count++;
			}
			n++;		
		}
		
		for (int i = 0; i < primes.length; i++) {
			System.out.print(primes[i] + " ");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}
		
		
	}
	/** Determines if a candidate is prime using the knownPrimes array
	 * 	of all smaller primes.
	 * @param candidate - number to be determined if is prime
	 * @param knownPrimes - all the primes smaller than candidate
	 * @return - true if candidate is prime, false otherways
	 */
	public static boolean isPrime(int candidate, int[] knownPrimes) {

		for(int i = 0; i < knownPrimes.length; i++) {
			if (knownPrimes[i] > 1 && knownPrimes[i] <= Math.round(Math.sqrt(candidate))) {
				if (candidate % knownPrimes[i] == 0)
					return false;
			}
		}	
		return true;
	}
}
