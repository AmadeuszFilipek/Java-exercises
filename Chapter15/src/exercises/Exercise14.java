package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14 extends Application {
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		pane.setPadding(new Insets(50));

		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		polygon.getPoints().addAll(40., 20., 70., 40., 60., 80., 45., 45., 20., 60.);
		
		Text txt = new Text();
		pane.getChildren().addAll(polygon, txt);

		Scene scene = new Scene(pane, 400, 300);

		scene.setOnMouseMoved(e -> {
			txt.setX(e.getX());
			txt.setY(e.getY());
			if (polygon.contains(e.getX(), e.getY()))
				txt.setText("Mouse is inside the polygon");
			else
				txt.setText("Mouse is outside the polygon");
		});

		primaryStage.setTitle("Exercise15_13");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
