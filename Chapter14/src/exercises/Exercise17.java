package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise17 extends Application {

	public void start(Stage primaryStage) {
		
		Arc support = new Arc(50, 300, 30, 10, 0, 180);
		support.setType(ArcType.OPEN);
		support.setFill(null);
		support.setStroke(Color.BLACK);
		
		Line pole = new Line(50, 300 - 10, 50, 30);
		
		Line holder = new Line(50, 30, 150, 30);
		
		Line rope = new Line(150, 30, 150, 50);

		Circle head = new Circle(150, 70, 20);
		head.setFill(null);
		head.setStroke(Color.BLACK);
		
		Line leftArm = new Line(150 + 20 * Math.cos(Math.PI + 2 * Math.PI/10.),
				70 - 20 * Math.sin(Math.PI + 2 * Math.PI/10.),
				150 + 60 * Math.cos(Math.PI + 2 * Math.PI/10.),
				70 - 60 * Math.sin(Math.PI + 2 * Math.PI/10.));
		
		Line rightArm = new Line(150 + 20 * Math.cos(- 2 * Math.PI / 10.),
				70 - 20 * Math.sin(- 2 * Math.PI / 10.),
				150 + 60 * Math.cos(- 2 * Math.PI / 10.),
				70 - 60 * Math.sin(- 2 * Math.PI / 10.));
		
		Line body = new Line(150, 90, 150, 140);

		Line leftLeg = new Line(150, 140,
				150 + 40 * Math.cos(Math.PI + 2 * Math.PI/10.),
				140 - 40 * Math.sin(Math.PI + 2 * Math.PI/10.));
		
		Line rightLeg = new Line(150, 140,
				150 + 40 * Math.cos(- 2 * Math.PI / 10.),
				140 - 40 * Math.sin(- 2 * Math.PI / 10.));
		
		Pane pane = new Pane();
		pane.getChildren().addAll(support, pole, holder, rope, head, leftArm, rightArm, body, leftLeg, rightLeg);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_17");
		primaryStage.show();
	}
}
