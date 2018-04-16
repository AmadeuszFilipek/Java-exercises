package Exercises;

import java.util.ArrayList;

public class Exercise33 {

	public static void main(String[] args) {
		
		// find perfect numbers - ones that are equal to the sum of their positive divisors
		// excluding themselves ( 28 = 14 + 7 + 4 + 2 + 1)
		
		for(int i = 3; i < 10000; i++) {
			if(isPerfect(i))
				System.out.println("The number " + i + " is perfect.");
			
		}
		
		
	}
	
	private static boolean isPerfect(int number) {
		
		ArrayList<Integer> divisors = new ArrayList<>();
		int divisorSum = 0;
		
		for (int i = 1; i < number; i++) {
			if (number % i == 0) divisors.add(i);
		}
		
		for (int j = 0; j < divisors.size(); j++) {
			divisorSum += divisors.get(j);
		}
		
		return divisorSum == number ? true : false;
		
	}
}
