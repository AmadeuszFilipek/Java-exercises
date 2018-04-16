package Exercises;

public class Exercise18 {

	public static void main(String[] args) {
		
		System.out.println("Pattern 1");
		
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j <= i; j++) 
				System.out.print(j + " ");
			
		System.out.println();	
		}
		
		System.out.println("Pattern 2");
		
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j <= 7 - i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern 3");
		
		for(int i = 1; i < 7; i++) {
			for(int j = 6; j > 0; j--) {
				if (j <= i)
					System.out.print(j + " ");
				else
					System.out.print("  ");
			}
			
			System.out.println();
		}
		
		System.out.println("Pattern 4");
		
		for(int i = 1; i < 7; i++) {
			for (int j = 1; j < i; j++)
				System.out.print("  ");
			for(int j = 1; j < 8 - i; j++)
					System.out.print(j + " ");

			System.out.println();
		}
		
	}
}
