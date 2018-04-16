package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise8 extends Application {

	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5));
		
		int row = -1;
		//add all the cards on the pane, 9 per row
		for(int i = 0; i < 54; i++) {
			if (i % 9 == 0)
				row ++;
			
			String cardName = printCard(i);
			ImageView img = new ImageView("images/cards/" + cardName + ".png");
			img.setPreserveRatio(true);
			img.setFitHeight(100);
			pane.add(img, i % 9, row);
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_03");
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
	
	public static String printCard(int card) {
		if (card == 52 || card == 53)
			return "J";
		if (card < 0 || card > 53)
			return null;
		
		String[] suit = {"S", "C", "H", "D"};
		String[] rank = {"A", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "J", "Q", "K"};
	
		return rank[card % 13] + suit[card / 13];
	}
}
