package Exercises;

public class Exercise7 {

	public static void main(String[] args) {
		
		double pi = 4;
		int N = 1000; 
		// pi approximation
		for (int i = 1; i < N; i++) {
			pi += 4.0 / (i * 2 + 1) * (i % 2 == 0 ? 1 : -1);
			
		}
		System.out.println("Pi approximation using " + N + " extension : " + pi);
	}
}
