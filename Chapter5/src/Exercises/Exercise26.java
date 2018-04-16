package Exercises;

public class Exercise26 {

	public static void main(String[] args) {
		
		double e, item;
		
		for (int n = 10000; n <= 100000; n += 10000) {
			e = 1;
			item = 1;
			
			for (int i = 1; i <= n; i++) {
				item = item / (double)i;
				e += item;
			}
			
			System.out.printf("The e after %d iterations is equal to: %f \n", n, e);
			
		}
		
		
		
	}
}
