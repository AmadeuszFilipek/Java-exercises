package Exercises;

public class Exercise4 {


	public static void main(String[] args) {
		
		final double MILE_TO_KM = 1.609;
		final double N = 10;
		
		System.out.println("Miles\tKilometers");
		for(int i = 1; i <= N; i++) {
			System.out.printf("%-5d\t%.3f\n", i, i * MILE_TO_KM);				
		}	
	}
}
