package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise13 extends Application {
	
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(50));
		
		Rectangle rectangle = new Rectangle(100, 60, 100, 40);
		rectangle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);
		
		Text txt = new Text();
		pane.getChildren().addAll(rectangle, txt);
		
		Scene scene = new Scene(pane, 400, 300);
		
		scene.setOnMouseMoved(e -> {
			txt.setX(e.getX());
			txt.setY(e.getY());
			if (rectangle.contains(e.getX(), e.getY()))
				txt.setText("Mouse is inside the rectangle");
			else
				txt.setText("Mouse is outside the rectangle");
		});
		
		primaryStage.setTitle("Exercise15_13");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
