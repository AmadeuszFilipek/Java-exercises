package Exercises;

public class Exercise14 {

	public static void main(String[] args) {
		
		System.out.println("i\t\tm(i)");
		System.out.println("________________________________");
		
		for(int i = 0; i <= 9; i++) {
			System.out.printf("%d\t\t%8.4f\n", i * 100 + 1, pi(i * 100 + 1));		
		}
		
	}
	
	public static double pi(int n) {
		double result = 0;
		
		for(int i = 1; i <= n; i++) {
			result += Math.pow(-1, i + 1) / (2 * i - 1);
		}
		return 4 * result;
	}
}
