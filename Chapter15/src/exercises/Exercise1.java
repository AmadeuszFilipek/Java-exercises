package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise1 extends Application {

	public void start(Stage primaryStage) {

		FourCardsHBox cards = new FourCardsHBox();
		
		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.CENTER);
		
		Button btnRefresh = new Button("Refresh");
		btnRefresh.setOnAction(e -> {cards.refresh();});
	
		vBox.getChildren().addAll(cards, btnRefresh);
		
		Scene scene = new Scene(vBox);
		primaryStage.setTitle("Exercise15_01");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public class FourCardsHBox extends HBox {

		private int[] cards;

		FourCardsHBox() {
			super(5);
			setAlignment(Pos.CENTER);
			setPadding(new Insets(5));
			refresh();
		}

		public void refresh() {
			cards = pickCards(4);
			getChildren().clear();

			//add them on the pane
			for(int i = 0; i < cards.length; i++) {
				String cardName = printCard(cards[i]);
				ImageView img = new ImageView("Images/PNG/" + cardName + ".png");
				img.setPreserveRatio(true);
				img.setFitHeight(300);
				getChildren().add(img);
			}
		}
	}

	/** [7.29] */
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

	public static String printCard(int card) {
		if (card < 0 || card > 52)
			return null;

		String[] suit = {"S", "C", "H", "D"};
		String[] rank = {"A", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "J", "Q", "K"};

		return rank[card % 13] + suit[card / 13];
	}
}
