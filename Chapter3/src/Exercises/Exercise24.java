package Exercises;

public class Exercise24 {

	public static void main(String[] args) {
		
		int cardNumber = (int)Math.floor(Math.random() * 13); // 0 - 12
		int cardSymbol = (int)Math.floor(Math.random() * 4); // 0 - 3
		
		String[] cards = {"Ace", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] symbols = {"Clubs", "Diamonts", "Hearts", "Spades"};
		
		System.out.println("The card you picked is " +
		cards[cardNumber] + " of " + symbols[cardSymbol]);
			
	}		
}
