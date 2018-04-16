package Exercises;

public class Exercise13 {

	public static void main(String[] args) {
		
		System.out.println("i\t\tm(i)");
		System.out.println("____________________________");
		
		for(int i = 1; i <= 20; i++) 
			System.out.printf("%d\t\t%8.4f\n", i, computeSeries(i));

		
	}
	
	
	public static double computeSeries(int n) {
		double result = 0;
		
		for (int i = 1; i <= n; i++) {
			result += i / (double)(i + 1);
		}
		
		return result;
	}
}
