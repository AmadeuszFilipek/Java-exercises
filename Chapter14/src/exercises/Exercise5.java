package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise5 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();

		double centerX = 150;
		double centerY = 150;
		double radius = 70;
		char[] words = "WELCOME TO JAVA ".toCharArray();
		
		for (int i = 0; i < words.length; i++) {
			double phi = Math.PI * 2 / words.length * i;
			Text text = new Text(centerX + radius * Math.cos(phi), 
													centerY + radius * Math.sin(phi), 
													Character.toString(words[i]));
			text.setFont(Font.font("Times Roman", 20));
			text.setRotate(Math.toDegrees(phi) + 90);
			
			pane.getChildren().add(text);
		}
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Exercise14_05");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
