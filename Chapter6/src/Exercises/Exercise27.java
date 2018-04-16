package Exercises;

public class Exercise27 {

	public static void main(String[] args) {
		
		int printed = 0;
		int i = 1;
		while(printed <= 100) {
			if (isEmirp(i)) {
				System.out.printf("%d ", i);
				printed++;
				if (printed % 10 == 0)
					System.out.println();
			}
			i++;	
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
	public static boolean isPalindrome(int number) {
		
		return number == reverse(number);
	}
	public static boolean isEmirp(int number) {
		
		return !isPalindrome(number) & isPrime(number) & isPrime(reverse(number));
	}
}
