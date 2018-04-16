package Exercises;

public class Exercise3 {

	public static void main(String[] args) {
		
		double kiloToPounds = 2.2;
		final int N = 200;
		
		System.out.println("Kilograms\tPounds");
		for(int i = 0; i < N; i++) {
			System.out.printf("%-8d\t%6.1f \n", i, i * kiloToPounds);			
		}	
		
	}
}
