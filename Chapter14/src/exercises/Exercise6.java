package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise6 extends Application {

	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setHgap(0);
		pane.setVgap(0);
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Rectangle rec = new Rectangle(50, 50, (j + i) % 2 == 0 ? Color.WHITE : Color.BLACK);
				pane.add(rec, i, j);
			}
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_06");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
