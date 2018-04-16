package Exercises;

public class Exercise25 {

	public static void main(String[] args) {
		
		double pi;
		
		for(int n = 10000; n <= 100000; n += 10000) {
			pi = 0;	
			for(int i = 1; i <= n; i++)
				pi += Math.pow(-1, i + 1) / (2 * i - 1);
			pi *= 4;
			
			System.out.printf("The pi value for %d iterations is: %f\n", n, pi);
			
			
		}
		
		
	}
}
