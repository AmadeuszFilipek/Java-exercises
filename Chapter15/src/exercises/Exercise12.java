package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise12 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(50));
		
		Circle circle = new Circle(100, 60, 50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		Text txt = new Text();
		pane.getChildren().addAll(circle, txt);
		
		Scene scene = new Scene(pane, 400, 300);
		
		scene.setOnMouseMoved(e -> {
			txt.setX(e.getX());
			txt.setY(e.getY());
			if (circle.contains(e.getX(), e.getY()))
				txt.setText("Mouse is inside the circle");
			else
				txt.setText("Mouse is outside the circle");
		});
		
		primaryStage.setTitle("Exercise15_12");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
