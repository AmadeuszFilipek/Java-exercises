package Exercises;

public class Exercise23 {

	public static void main(String[] args) {
		
		final int N = 50000;
		double leftToRightResult = 0;
		double rightToLeftResult = 0;
		
		for (int i = 1; i <= N; i++)
			leftToRightResult += 1. / i;
			
		for (int i = N; i > 0; i--)
			rightToLeftResult += 1. / i;
		
		// Cancellation errors, when adding very small number to big number
		// the small number is cancelled out
		System.out.println("Left to right result: " + leftToRightResult);
		System.out.println("Right to left result: " + rightToLeftResult);
		
	}
}
