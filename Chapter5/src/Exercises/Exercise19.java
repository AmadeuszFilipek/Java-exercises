package Exercises;

public class Exercise19 {

	public static void main(String[] args) {
		
		int number = 8;
		
		for(int line = 1; line <= number; line++){
			for(int i = 0; i < number - line; i++)
				System.out.print("    ");
			
			for(int col = 1; col < line; col++) {
				System.out.printf("%-4d", (int)Math.pow(2, col-1));
			}
			for(int col = line; col > 0; col--) {
				System.out.printf("%-4d", (int)Math.pow(2, col-1));
			}
				
				System.out.println();
		}
		
	}
}
