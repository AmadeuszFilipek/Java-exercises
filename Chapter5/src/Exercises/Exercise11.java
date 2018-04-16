package Exercises;

public class Exercise11 {

	public static void main(String[] args) {
		
		double numbersPrinted = 0;
		
		for (int i = 100; i < 200; i++) {
			
			// divisible by 5 or 6 but not both
			if (i % 5 == 0 ^ i % 6 == 0) {
				System.out.printf("%d ", i);
				numbersPrinted++;	
				
				if(numbersPrinted % 10 == 0) {
					System.out.printf("\n");
				}	
			}		
		}
		
	}
}
