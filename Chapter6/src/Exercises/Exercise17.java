package Exercises;

public class Exercise17 {

	public static void main(String[] args) {
		
		printMatrix(10);
		
	}
	
	public static void printMatrix(int n) {
		double number;
		
		for (int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				number = Math.random();
				if (number > 0.5)
					number = 1;
				else 
					number = 0;
				System.out.print((int)number + " ");
				
			}
			
			System.out.println();
		}
		
		
	}
}
