package Exercises;

public class Exercise32 {

	public static void main(String[] args) {
		
		int N = 10000;
		int winCount = 0;
		for (int i = 0; i < N; i++) {
			if (playCraps())
				winCount++;
		}
		
		System.out.println("Number of wins: " + winCount);
		System.out.println("Number of loses: " + (N - winCount));
		
		
	}
	
	public static int rollDice() {
		
		return (int)Math.ceil(Math.random() * 6);
	}
	
	public static boolean playPoint(int point) {
		if (point < 2 || point > 12)
			return false;
		
		int roll1, roll2, sum;
		
		while(true) {
			roll1 = rollDice();
			roll2 = rollDice();
			sum = roll1 + roll2;
			if (sum == 7) {
			//	System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);
				return false;
			}
				
			if (sum == point) {
			//	System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);
				return true;	
			}	
		}
	}
	public static boolean playCraps() {
		
		int roll1 = rollDice();
		int roll2 = rollDice();
		int sum = roll1 + roll2;
		
	//	System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);
		
		if (sum == 2 || sum == 3 || sum == 12)
		//	System.out.println("You lose");
			return false;
		else if(sum == 7 || sum == 11)
			return true;
		//	System.out.println("You win");
		else {
		//	System.out.println("point is " + sum);
			if (playPoint(sum))
				return true;
			else
				return false;
		}		
	}
}
