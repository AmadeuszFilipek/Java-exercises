package Exercises;

public class Exercise43 {

	public static void main(String[] args) {
		
		int totalNumber = 0;
		
		for (int i = 1; i <= 7; i++) {
			for(int j = i + 1; j <= 7; j++) {
				System.out.println(i + " " + j);
				totalNumber++;
			}
		}
		
		System.out.println("Total number of combinations is : " + totalNumber);
		
	}
}
