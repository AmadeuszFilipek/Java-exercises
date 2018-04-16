package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise10 extends Application {

	public void start(Stage primaryStage) {

		BorderPane pane  = new BorderPane();
		pane.setPadding(new Insets(20));

		Label lbl = new Label("Enter any text, end with enter.");
		lbl.setFont(Font.font(26));
		pane.setCenter(lbl);

		Scene scene = new Scene(pane, 500, 300);

		//container for the input string
		StringBuilder input = new StringBuilder();

		//collect all the input
		scene.setOnKeyTyped(e -> {
			input.append(e.getCharacter());
		});

		//print the collected input and reset the buffer
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				lbl.setText(input.toString());
				input.delete(0, input.length());
			}
		});

		primaryStage.setTitle("Exercise15_10");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
