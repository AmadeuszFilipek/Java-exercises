package exercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Exercise20 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();

		for(int i = 0; i < 20; i++)
		drawArrowLine(Math.random() * 400, Math.random() * 400, Math.random() * 400, Math.random() * 400, pane);
		
		Scene scene = new Scene(pane,500, 500);
		primaryStage.setTitle("Exercise14_20");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
	
		Line line = new Line(startX, startY, endX, endY);
		
		//draw the head of the arrow
		Polyline arrow = new Polyline();
		ObservableList<Double> list = arrow.getPoints();
		
		//find the angle created with the line
		double a = endX - startX;
		double b = -(endY - startY); //the y-axis is shifted upside down
		double phase = Math.PI / 2 - Math.atan2(a, b); // atan2 - this function is tricky

		double radius = 30;
		double angle = 10 * Math.PI / 180; 

		// the angle is 180 - phase because now we focus on the ending point, not the starting
		list.add(endX + radius * Math.cos(Math.PI - phase + angle));
		list.add(endY + radius * Math.sin(Math.PI - phase + angle));
		list.add(endX);
		list.add(endY);
		list.add(endX + radius * Math.cos(Math.PI - phase - angle));
		list.add(endY + radius * Math.sin(Math.PI - phase - angle));
	
		pane.getChildren().addAll(line, arrow);
		
	}
}
