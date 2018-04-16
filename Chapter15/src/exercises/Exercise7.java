package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise7 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(20));
		
		Circle circle = new Circle(200);
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		
		circle.setFill(null);
		circle.setStroke(Color.BLACK);
		
		pane.setOnMousePressed(e -> {
			circle.setFill(Color.BLACK);
		});
		
		pane.setOnMouseReleased(e -> {
			circle.setFill(Color.WHITE);
		});
	
		pane.getChildren().add(circle);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_07");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
