package Exercises;

public class Exercise13 {

	public static void main(String[] args) {
		
		int n = 100;
		
		while( Math.pow(n, 3) >= 12000) {
			n--;
		}
		
		System.out.println("The largest n such that n^3 < 12000 is " + n);
	
		
	}	
}
