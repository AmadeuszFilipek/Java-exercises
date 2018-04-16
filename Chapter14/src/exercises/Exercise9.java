package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise9 extends Application {

	public void start(Stage primaryStage) {

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setPadding(new Insets(5));

		double radius = 200;
		double arcRadius = radius - 50;

		//create and add "fan" to the grid
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				Pane tmp = new Pane();
				pane.setAlignment(Pos.CENTER);
				Circle circle = new Circle(radius, radius, radius);
				circle.setFill(Color.WHITE);
				circle.setStroke(Color.BLACK);
				tmp.getChildren().add(circle);

				for (int f = 0; f < 4; f ++) {
					Arc arc = new Arc(circle.getCenterX(), circle.getCenterX(), arcRadius, arcRadius, 45/2 + 90 * f, 45);
					arc.setFill(Color.RED);
					arc.setType(ArcType.ROUND);
					tmp.getChildren().add(arc);

				}

				pane.add(tmp, j, i);
			}
		}

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_09");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
