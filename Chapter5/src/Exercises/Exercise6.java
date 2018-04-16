package Exercises;

public class Exercise6 {

	public static void main(String[] args) {
		
		final double MILE_TO_KM = 1.609;
		final double N = 10;
		
		System.out.println("Miles\tKilometers\t|\tKilometers\tMiles");
		for(int i = 1; i <= N; i++) {
			System.out.printf("%-5d\t%-10.3f", i, i * MILE_TO_KM);
			System.out.printf("\t|\t%-10d\t%.3f \n", i * 5 + 15, (i * 5 + 15) / MILE_TO_KM);
		}	
	}
}
