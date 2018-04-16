package exercises;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise7 extends Application {

	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setPadding(new Insets(5));
		
		Random rng = new Random();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				
				TextField txt = new TextField();
				txt.setText(Integer.toString(rng.nextInt(2)));
				txt.setAlignment(Pos.CENTER);
				txt.setMaxWidth(30);
				txt.setEditable(false);
				pane.add(txt, j, i);
				
			}
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_07");
		primaryStage.show();
		
	}
	
}
