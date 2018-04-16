package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise11 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(5));
		
		double radius = 200;
		
		//The frame for the smile
		Circle head = new Circle(radius, radius, radius);		
		head.setFill(Color.WHITE);
		head.setStroke(Color.BLACK);
		
		//a nose 
		Polygon nose = new Polygon();
		nose.getPoints().add(head.getCenterX()); // x - coordinate
		nose.getPoints().add(head.getCenterY() - radius / 5); // y - coordinate

		nose.getPoints().add(head.getCenterX() - radius / 5);
		nose.getPoints().add(head.getCenterY() + radius / 5);
		
		nose.getPoints().add(head.getCenterX() + radius / 5); // x - coordinate
		nose.getPoints().add(head.getCenterY() + radius / 5); // y - coordinate
		
		nose.setFill(Color.WHITE);
		nose.setStroke(Color.BLACK);
		
		//a mouth
		Arc mouth = new Arc(head.getCenterX(), head.getCenterY() + radius / 2, radius / 2, radius / 5, 0, - 180);
		mouth.setType(ArcType.OPEN);
		mouth.setFill(Color.WHITE);
		mouth.setStroke(Color.BLACK);
		
		//eyes
		Ellipse leftEye = new Ellipse(head.getCenterX() - 100, head.getCenterY() - radius /3, 50, 40);
		leftEye.setFill(Color.WHITE);
		leftEye.setStroke(Color.BLACK);
		
		Ellipse rightEye = new Ellipse(head.getCenterX() + 100, head.getCenterY() - radius /3, 50, 40);
		rightEye.setFill(Color.WHITE);
		rightEye.setStroke(Color.BLACK);
		 
	  Circle leftEyeFill = new Circle(head.getCenterX() - 100, head.getCenterY() - radius /3, 30);
	  Circle rightEyeFill = new Circle(head.getCenterX() + 100, head.getCenterY() - radius /3, 30);
	  
		pane.getChildren().addAll(head, nose, mouth, leftEye, leftEyeFill, rightEye, rightEyeFill);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_11");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
