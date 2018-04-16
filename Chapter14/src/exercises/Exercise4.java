package exercises;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Exercise4 extends Application {

	public void start(Stage primaryStage) {
		
		HBox pane = new HBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5));
		
		// generate labels and add them to the pane
		for(int i = 0; i < 5; i++) {
			Random rng = new Random();
			Label label = new Label("Java");
			label.setRotate(90);
			label.setTextFill(Color.rgb(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256), rng.nextDouble()));
			label.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
			
			pane.getChildren().add(label);
		}
		
		pane.setMinHeight(100); // because the text was partialy hidden
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_04");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
