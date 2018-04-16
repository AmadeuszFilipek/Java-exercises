package Exercises;

public class Exercise40 {

	public static void main(String[] args) {
		
		final double N = 1000000;
		int numberOfHeads = 0;
		int numberOfTails = 0;
	
		for (int i = 0; i < N; i++) {
			if (Math.random() > 0.5)
				numberOfHeads++;
			else
				numberOfTails++;
		}
		
		System.out.println("Number of heads : " + numberOfHeads);
		System.out.println("Number of tails : " + numberOfTails);
	}
}
