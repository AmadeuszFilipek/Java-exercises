package Exercises;

public class Exercise7 {

	public static void main(String[] args) {
		
		final double STARTING_TUITION = 10000;
		final double INCREASE_RATE = 5 / 100.;
		double totalCost = 0;
		double tuition = STARTING_TUITION;
		
		// in ten years tuition will be
		for (int i = 1; i <= 10; i++) {
			tuition = tuition * (1 + INCREASE_RATE);
		}
		
		System.out.printf("Tuition in ten years will be: $%.2f\n", tuition);

		for (int i = 0; i < 4; i++) {
			totalCost += tuition;
			tuition = tuition * (1 + INCREASE_RATE);
		}
		
		System.out.printf("Total cost of four years' study after ten years will cost: "
			+ "$%.2f\n", totalCost);	
	}	
}
