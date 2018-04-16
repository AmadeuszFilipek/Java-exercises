package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise10 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		double radiusX = 100;
		double radiusY = 50;
		double cylinderHeight = 200;
		
		//Top cap of the cylinder
		Arc arcTop = new Arc(200, 100, radiusX, radiusY, 0, 360);
		arcTop.setFill(Color.WHITE);
		arcTop.setStroke(Color.BLACK);
		arcTop.setType(ArcType.OPEN);
		
		//Bottom of the cylinder
		Arc arcBot = new Arc(200, cylinderHeight + 100, radiusX, radiusY, 0, -180);
		arcBot.setFill(Color.WHITE);
		arcBot.setStroke(Color.BLACK);
		arcBot.setType(ArcType.OPEN);
		
		Arc arcDashedBot = new Arc(200, cylinderHeight + 100, radiusX, radiusY, 0, 180);
		arcDashedBot.setFill(Color.WHITE);
		arcDashedBot.setStroke(Color.BLACK);
		arcDashedBot.setType(ArcType.OPEN);
		arcDashedBot.getStrokeDashArray().addAll(6.0, 21.0);
		
		//Left side of cylinder
		Line leftLine = new Line(arcTop.getCenterX() - radiusX, arcTop.getCenterY(), 
														 arcBot.getCenterX() - radiusX, arcBot.getCenterY());
	
		//Right side of cylinder
		Line rightLine = new Line(arcTop.getCenterX() + radiusX, arcTop.getCenterY(), 
															arcBot.getCenterX() + radiusX, arcBot.getCenterY());
		
		pane.getChildren().addAll(arcTop, arcBot, arcDashedBot, leftLine, rightLine);
		
		Scene scene = new Scene(pane, radiusX * 2 + 200, cylinderHeight + 200);
		primaryStage.setTitle("Exercise14_10");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
