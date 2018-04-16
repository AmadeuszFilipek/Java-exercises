package Exercises;

public class Exercise24 {

	public static void main(String[] args) {
		
		double result = 0;
		
		for(int i = 1; i <= 97; i += 2) 
			result += i / (double)(i + 2);
		
		System.out.println("The result is: " + result);
		
	}
}
