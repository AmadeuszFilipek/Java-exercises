package Exercises;

public class Exercise10 {

	public static void main(String[] args) {
		
		double numbersPrinted = 0;
		
		for (int i = 100; i < 1000; i++) {
			
			// divisible by 5 and by 6
			if (i % 30 == 0) {
				System.out.printf("%d ", i);
				numbersPrinted++;	
				
				if(numbersPrinted % 10 == 0) {
					System.out.printf("\n");
				}	
			}		
		}
		
		
		
	}
}
