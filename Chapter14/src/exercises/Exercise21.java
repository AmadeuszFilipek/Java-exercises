package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise21 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		double radius = 15;
		
		Line line = new Line(Math.random()* 300, Math.random()* 300, Math.random()* 300, Math.random()* 300);
		
		Circle circle1 = new Circle(line.getStartX(), line.getStartY(), radius);
		
		Circle circle2 = new Circle(line.getEndX(), line.getEndY(), radius);
		
		Text text = new Text((line.getStartX() + line.getEndX()) / 2 + 10, 
				(line.getStartY() + line.getEndY()) / 2 + 10, 
				Double.toString(Math.sqrt(Math.pow(line.getStartX() - line.getEndX(), 2) +
																	Math.pow(line.getStartY() - line.getEndY(), 2))));
		
		pane.getChildren().addAll(line, circle1, circle2, text);
	
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Exercise14_21");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
