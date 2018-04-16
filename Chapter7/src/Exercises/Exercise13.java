package Exercises;

public class Exercise13 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++)
			System.out.println(getRandom(1, 2, 3, 4, 5, 6, 7, 8, 9) );				
		
	}
	
	public static int getRandom(int... numbers) {
		int random;
		boolean isInside;
		while(true) {
			
			isInside = false;
			random = (int)Math.ceil(Math.random() * 54);
			
			for(int i = 0; i < numbers.length; i++) {
				if (random == numbers[i])
					isInside = true;
			}
			
			if (!isInside)
				return random;	
		}
	}
}
