package Exercises;

public class Exercise12 {

	public static void main(String[] args) {
		
		int n = 0;
		
		while( n * n <= 12000) {
			n++;
		}
		
		System.out.println("The smallest n such that n^2 > 12000 is " + n);
		
	}
}
