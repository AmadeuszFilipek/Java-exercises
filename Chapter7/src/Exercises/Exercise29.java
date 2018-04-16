package Exercises;

public class Exercise29 {

	public static void main(String[] args) {
		
		int[] cards = pickCards(4);
		printCards(cards);
		System.out.println("Sum of the cards: " + sumOfCards(cards));
		System.out.println("The number of picks that yeld the sum 24 is : " +
				numberOfPicksThatYield24());
		System.out.println(52 * 51 * 50 * 49);
	}
	
	public static int numberOfPicksThatYield24() {
		
		int[] cards = new int[4];
		int count = 0;
		
		for (int i = 0; i < 52; i++) {
			cards[0] = i;
			for(int j = i + 1; j < 52; j++) {
				cards[1] = j;
				for(int k = j + 1; k < 52; k++) {
					cards[2] = j;
					for (int l = k + 1; l < 52; l++) {
						cards[3] = l;
						//if (sumOfCards(cards) == 24)
							count++;
					}
				}							
			}
		}
		
		return count;
	}
	
	public static int sumOfCards(int... cards) {
		int sum = 0;
		for (int i = 0; i < cards.length; i++) {
			sum += cards[i] % 13 + 1;
		}
		return sum;
	}
	
	public static int[] pickCards(int cardsNumber) {
		int[] cards = new int[cardsNumber];
		boolean isNewCard;
		int i = 0;
		while (i < cards.length) {
			
			isNewCard = true;
			cards[i] = pickACard();
			
			for(int j = i - 1; j >= 0; j--) {
				if (cards[i] == cards[j]) {
					isNewCard = false;
					break;
				}
			}
			
			if (isNewCard)
				i++;
			
		}
		return cards;
	}
	// 13 cards of each color, 2 - 10, Jack, Queen, King, Ace
	public static int pickACard() {
		
		return (int)Math.floor(Math.random() * 52);
	}
		
	public static void printCard(int card) {
		if (card < 0 || card > 52)
			return;
		
		String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
		String[] rank = {"Ace", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
		System.out.println(rank[card % 13] + " of " + suit[card / 13]);
	}
	
	public static void printCards(int[] cards) {
		for(int i = 0; i < cards.length; i++)
			printCard(cards[i]);
	}
}
