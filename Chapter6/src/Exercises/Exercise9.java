package Exercises;

public class Exercise9 {

	public static void main(String[] args) {
		
		System.out.println("Feet\tMeters\t|\tMeters\tFeet");
		System.out.println("_______________________________________________________________");
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%d\t%.3f\t|\t%d\t%.3f\n",
				  i, footToMeter(i),
					15 + i * 5, meterToFoot(15 + i * 5));
		}
		
	}
	
	public static double footToMeter(double foot) {
		
		return 0.305 * foot;
		
	}
	
	public static double meterToFoot(double meter) {
		
		return 3.279 * meter;
		
	}
}
