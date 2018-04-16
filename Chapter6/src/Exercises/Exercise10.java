package Exercises;

public class Exercise10 {

	public static void main(String[] args) {
		
		int numberOfPrimes = 0;
		int i = 0;
		
		while (i < 10000) {
			if (isPrime(i))
				numberOfPrimes++;
			i++;
		}
		
		System.out.println("The number of primes less than 10000 is: " + numberOfPrimes);
		
	}
	
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) { // If true, number is not prime
				return false; // Number is not a prime
			}
		}

		return true; // Number is prime
	}
}
