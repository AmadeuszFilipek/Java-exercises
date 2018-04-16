package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise23 extends Application {
	public void start(Stage primaryStage) {

		StackPane pane = new StackPane();
		pane.setPadding(new Insets(50));
		double centerX = 200;
		double centerY = 200;
		double radius = 150;

		Polygon octagon = new Polygon();
		octagon.setFill(Color.RED);
		octagon.scaleXProperty().bind(pane.widthProperty().divide(400.));
		octagon.scaleYProperty().bind(pane.heightProperty().divide(400.));
		//add the octagon corner points
		for(int i = 0; i < 8; i++) {
			double fi = 2 * Math.PI / 8. * i + + 2 * Math.PI / 8 / 2;
			octagon.getPoints().add(centerX + Math.cos(fi) * radius);
			octagon.getPoints().add(centerY + Math.sin(fi) * radius);
		}

		Label text = new Label("STOP");
		text.setFont(Font.font(65));
		text.setTextFill(Color.WHITE);

		pane.getChildren().addAll(octagon, text);

		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise14_15");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
