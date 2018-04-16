package exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Exercise29 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		//draw a box for the bean machine
		Polyline container = new Polyline();
		ObservableList<Double> list = container.getPoints();
		list.add(160.); list.add(50.);
		list.add(160.); list.add(80.);
		list.add(20.); list.add(300.);
		list.add(20.); list.add(350.);
		list.add(320.); list.add(350.);
		list.add(320.); list.add(300.);
		list.add(180.); list.add(80.);
		list.add(180.); list.add(50.);
		
		//draw circles inside
		ArrayList<Circle> circles = new ArrayList<>();
		for(int i = 1; i <= 7; i++) 
			for(int j = 1; j <= i ; j++) {
				circles.add(new Circle(150 + j * 40 - i * 20, 80 + 30 * i, 5.));
			}
		
		//draw lines for the bean collectors
		ArrayList<Line> drawers = new ArrayList<>();
		for(int i = circles.size() - 1; i >= circles.size() - 7; i--) {
			drawers.add(new Line(circles.get(i).getCenterX(), circles.get(i).getCenterY(),
													 circles.get(i).getCenterX(), 350));
		}
		
		pane.getChildren().add(container);
		pane.getChildren().addAll(circles);
		pane.getChildren().addAll(drawers);
		
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_29");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
