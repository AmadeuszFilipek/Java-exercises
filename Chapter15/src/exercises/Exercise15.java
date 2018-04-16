package exercises;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15 extends Application {

	public void start (Stage primaryStage) {
		
		Pane pane = new Pane();
		
		pane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				pane.getChildren().add(new Circle(e.getX(), e.getY(), 30));
			}
			else if (e.getButton() == MouseButton.SECONDARY) {
				for(Node node : pane.getChildren()) {
					if (node.contains(e.getX(), e.getY())) {
						pane.getChildren().remove(node); // removing while iterating is dangerous(disastrous)
						break; 													 // but a break is here for the rescue
					}
				}	
			}
		});
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Exercise15_15");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}
