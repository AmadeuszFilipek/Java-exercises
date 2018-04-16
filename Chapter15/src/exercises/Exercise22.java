package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise22 extends Application {

public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		double radiusX = 100;
		double radiusY = 50;
		double cylinderHeight = 200;
		
		//Top cap of the cylinder
		Arc arcTop = new Arc(200, 100, radiusX, radiusY, 0, 360);
		arcTop.radiusXProperty().bind(pane.widthProperty().divide(4));
		arcTop.radiusYProperty().bind(pane.heightProperty().divide(8));
		arcTop.centerXProperty().bind(pane.widthProperty().divide(2));
		arcTop.centerYProperty().bind(pane.heightProperty().divide(4));
		arcTop.setFill(Color.WHITE);
		arcTop.setStroke(Color.BLACK);
		arcTop.setType(ArcType.OPEN);
		
		//Bottom of the cylinder
		Arc arcBot = new Arc(200, cylinderHeight + 100, radiusX, radiusY, 0, -180);
		arcBot.radiusXProperty().bind(pane.widthProperty().divide(4));
		arcBot.radiusYProperty().bind(pane.heightProperty().divide(8));
		arcBot.centerXProperty().bind(pane.widthProperty().divide(2));
		arcBot.centerYProperty().bind(pane.heightProperty().multiply(3 / 4.));
		arcBot.setFill(Color.WHITE);
		arcBot.setStroke(Color.BLACK);
		arcBot.setType(ArcType.OPEN);
		
		Arc arcDashedBot = new Arc(200, cylinderHeight + 100, radiusX, radiusY, 0, 180);
		arcDashedBot.radiusXProperty().bind(pane.widthProperty().divide(4));
		arcDashedBot.radiusYProperty().bind(pane.heightProperty().divide(8));
		arcDashedBot.centerXProperty().bind(pane.widthProperty().divide(2));
		arcDashedBot.centerYProperty().bind(pane.heightProperty().multiply(3 / 4.));
		arcDashedBot.setFill(Color.WHITE);
		arcDashedBot.setStroke(Color.BLACK);
		arcDashedBot.setType(ArcType.OPEN);
		arcDashedBot.getStrokeDashArray().addAll(6.0, 21.0);
		
		//Left side of cylinder
		Line leftLine = new Line(arcTop.getCenterX() - radiusX, arcTop.getCenterY(), 
														 arcBot.getCenterX() - radiusX, arcBot.getCenterY());
		leftLine.startXProperty().bind(arcTop.centerXProperty().subtract(arcTop.radiusXProperty()));
		leftLine.startYProperty().bind(arcTop.centerYProperty());
		leftLine.endXProperty().bind(arcBot.centerXProperty().subtract(arcBot.radiusXProperty()));
		leftLine.endYProperty().bind(arcBot.centerYProperty());
		
		//Right side of cylinder
		Line rightLine = new Line(arcTop.getCenterX() + radiusX, arcTop.getCenterY(), 
															arcBot.getCenterX() + radiusX, arcBot.getCenterY());
		rightLine.startXProperty().bind(arcTop.centerXProperty().add(arcTop.radiusXProperty()));
		rightLine.startYProperty().bind(arcTop.centerYProperty());
		rightLine.endXProperty().bind(arcBot.centerXProperty().add(arcBot.radiusXProperty()));
		rightLine.endYProperty().bind(arcBot.centerYProperty());
		
		pane.getChildren().addAll(arcTop, arcBot, arcDashedBot, leftLine, rightLine);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise14_10");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
