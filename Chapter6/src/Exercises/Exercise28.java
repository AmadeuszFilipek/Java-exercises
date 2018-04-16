package Exercises;

public class Exercise28 {

	public static void main(String[] args) {
		
		System.out.println("p\t\t2^p - 1");
		System.out.println("_______________________");
		for (int p = 2; p <= 31; p++) {
			if (isPrime(mersennePrime(p))) {
				System.out.printf("%d\t\t%d\n", p, mersennePrime(p));
			}
		}
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) { // If true, number is not prime
				return false; // Number is not a prime
			}
		}

		return true; // Number is prime
	}
	public static int reverse(int number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		return Integer.parseInt(temp.toString());
		
	}
	public static int mersennePrime(int p) {
		int result = 2;
		for (int i = 1; i < p; i++) {
			result *= 2;
		}
		return result - 1;
	}
}
