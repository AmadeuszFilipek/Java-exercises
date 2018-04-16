package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise22 extends Application {

	public void start(Stage primaryStage) {

		Pane pane = new Pane();

		double radius = 15;
		
		Line line = new Line(Math.random()* 300, Math.random()* 300, Math.random()* 300, Math.random()* 300);

		//line should not cross the circles, but they are filled white so that does the trick
		Circle circle1 = new Circle(line.getStartX(), line.getStartY(), radius);
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.BLACK);
		
		Circle circle2 = new Circle(line.getEndX(), line.getEndY(), radius);
		circle2.setFill(Color.WHITE);
		circle2.setStroke(Color.BLACK);
		
		Text text1 = new Text(circle1.getCenterX(), circle1.getCenterY(), "1");
		Text text2 = new Text(circle2.getCenterX(), circle2.getCenterY(), "2");

		pane.getChildren().addAll(line, circle1, circle2, text1, text2);
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Exercise14_22");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
