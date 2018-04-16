package Exercises;

import java.util.Random;

public class Exercise4 {

	public static void main(String[] args) {
		
		Random rnd = new Random(1000);
		
		int i = 0;
		while(i < 50) {
			System.out.println(rnd.nextInt(100));
			i++;
		}
	}
}
