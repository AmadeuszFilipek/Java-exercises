package Exercises;

public class Exercise16 {
	public static void main (String[] args) {
		
	// A is 65, Z is 90
		int code = (int)Math.round(Math.random() * (90 - 65)) + 65;
		// a random upperCase letter
		System.out.println("A random uppercase letter: " + (char)code);
	}

}
