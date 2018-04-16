package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise8 extends Application {

	public void start(Stage primaryStage) {
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(20));
		
		Label position = new Label();
		position.setFont(Font.font(26));
		position.setVisible(false);
		
		//set the actual position of the mouse
		pane.setOnMouseDragged(e -> {
			position.setText("(" + e.getX() + "; " + e.getY() + ")");
		});
		
		//trigger visibility when the button is clicked
		pane.setOnMousePressed(e -> {
			position.setVisible(true);
		});
		
		//and hide the text then the button is released
		pane.setOnMouseReleased(e -> {
			position.setVisible(false);
		});
		
		pane.setCenter(position);
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Exercise15_08");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
