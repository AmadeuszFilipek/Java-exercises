package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		// create two circles
		Circle circle1 = new Circle(40, 40, 10);
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.BLACK);
		Circle circle2 = new Circle(120, 150, 10);
		circle2.setFill(Color.WHITE);
		circle2.setStroke(Color.BLACK);
		
		//create a line connecting two points
		Line line = new Line(40, 40, 120, 150);
		line.startXProperty().bind(circle1.centerXProperty());
		line.startYProperty().bind(circle1.centerYProperty());
		line.endXProperty().bind(circle2.centerXProperty());
		line.endYProperty().bind(circle2.centerYProperty());
		
		//create a label indicating the distance
		Text text = new Text();
		text.xProperty().bind(line.endXProperty().add(line.startXProperty()).divide(2));
		text.yProperty().bind(line.endYProperty().add(line.startYProperty()).divide(2));
		updateText(text, circle1, circle2);
		
		pane.getChildren().addAll(circle1, circle2, line, text);
		
		//define the events for the dragging the circles
		circle1.setOnMouseDragged(e -> {		
				circle1.setCenterX(e.getX());
				circle1.setCenterY(e.getY());
				updateText(text, circle1, circle2);
		});
		
		circle2.setOnMouseDragged(e -> {
			circle2.setCenterX(e.getX());
			circle2.setCenterY(e.getY());
			updateText(text, circle1, circle2);
		});
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Exercise15_16");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void updateText(Text text, Circle c1, Circle c2) {
		text.setText(Double.toString(Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + 
				Math.pow(c1.getCenterY() - c2.getCenterY(), 2))));		
	}
}
