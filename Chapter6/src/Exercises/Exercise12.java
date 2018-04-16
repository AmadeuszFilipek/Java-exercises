package Exercises;

public class Exercise12 {

	public static void main(String[] args) {
		
		printChars('1', 'Z', 10);
		

	}
	public static void printChars(char ch1, char ch2, int numberPerLine) {
		int printed = 0;
		for (int i = ch1; i < ch2; i++) {
			
			System.out.print((char)i + " ");
			printed++;
			if (printed % numberPerLine == 0)
				System.out.println();
			
		}	
	}
}
