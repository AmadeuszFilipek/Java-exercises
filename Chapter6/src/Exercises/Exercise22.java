package Exercises;

public class Exercise22 {

	public static void main(String[] args) {
		
		for (int i = 1; i < 100; i++) {
			System.out.printf("%d\t%.2f\n", i, sqrt(i));
		}
		
		
	}
	
	public static double sqrt(long n) {
	
		if (n == 0)
			return 0;
		else if (n < 0)
			return 1 / 0;
		
		double lastGuess = 1;
		double sigma = 0.0001;
		double nextGuess = -1;
		
		while (true) {
			nextGuess = (lastGuess + n / lastGuess) / 2;
			if (Math.abs(nextGuess - lastGuess) < sigma)
				break;
			lastGuess = nextGuess;
		} 


		return nextGuess;
	}
}
