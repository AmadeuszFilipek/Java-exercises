package exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise25 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(50));
		
		double radius = 200;
		Circle circle = new Circle(radius, radius, radius);
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle.setFill(null);
		circle.setStroke(Color.BLACK);
		
		//create a polygon and generate its points
		Polygon poly = new Polygon();
		poly.setFill(null);
		poly.setStroke(Color.BLACK);
		
		//generate random points, defined by angles
		ArrayList<Double> angles = new ArrayList<>();
		
		for (int i = 0; i < 5; i++)
			angles.add(Math.random() * 2 * Math.PI);
		
		//sort the angles in increasing order, so the polygon is correctly built
		angles.sort((a, b) -> { return a.compareTo(b);});
		
		for (Double angle : angles)
			poly.getPoints().addAll(radius * Math.cos(angle),
					radius * Math.sin(angle));
		
		//set the binded offset
		poly.translateXProperty().bind(pane.widthProperty().divide(2));
		poly.translateYProperty().bind(pane.heightProperty().divide(2));
		pane.getChildren().addAll(circle, poly);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_25");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
