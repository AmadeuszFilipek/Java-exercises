package Exercises;

public class Exercise15 {

	public static void main(String[] args) {
		
		// print all ascii symbols from ! to ~
		int printed = 0;
		
		System.out.println("ASCII table from ! to ~");
		for (int i = 0; i < 256; i++) {
			if ((char)i >= '!' && (char)i <= '~') {
				System.out.printf("%c ", i);
				printed ++;
				if (printed % 10 == 0)
					System.out.println();
			}			
		}
		
		
	}
}
