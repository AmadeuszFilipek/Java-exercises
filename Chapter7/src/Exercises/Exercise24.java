package Exercises;

import java.util.Arrays;

public class Exercise24 {

	public static void main(String[] args) {
		
		int count = 0;
		int[] cards;
		while(true)	{
			count++;
			cards = pickFourCards();
			if (isOfEachSuit(cards)) {
				printCards(cards);
				System.out.println("Number of picks: " + count);
				break;
			}		
		}		
	}
	
	public static int[] pickFourCards() {
		int[] cards = new int[4];
		for(int i = 0; i < cards.length; i++)
			cards[i] = pickACard();
		return cards;
	}
	// 13 cards of each color, 2 - 10, Jack, Queen, King, Ace
	public static int pickACard() {
		
		return (int)Math.floor(Math.random() * 52);
	}
	
	public static boolean isOfEachSuit(int[] cards) {
		if(cards.length != 4)
			return false;
		
		boolean[] colorFound = new boolean[4];
		Arrays.fill(colorFound, false);
		for(int i = 0; i < cards.length; i++) {
			switch (cards[i] / 13){
			case 0: colorFound[0] = true; break;
			case 1: colorFound[1] = true; break;
			case 2: colorFound[2] = true; break;
			case 3: colorFound[3] = true; break;
			default: break;
			}
		}
		
		boolean isOfEachSuit = true;
		for (int i = 0; i < colorFound.length; i++) {
			if (!colorFound[i])
				isOfEachSuit = false;
		}
		return isOfEachSuit;
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
