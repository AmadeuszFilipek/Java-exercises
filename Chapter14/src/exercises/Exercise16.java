package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise16 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		Line vLine1 = new Line();
		vLine1.startXProperty().bind(pane.widthProperty().divide(3));
		vLine1.startYProperty().set(0);
		vLine1.endXProperty().bind(pane.widthProperty().divide(3));
		vLine1.endYProperty().bind(pane.heightProperty());
		vLine1.setFill(Color.RED);
		vLine1.setStroke(Color.RED);
		
		Line vLine2 = new Line();
		vLine2.startXProperty().bind(pane.widthProperty().divide(3/2.));
		vLine2.startYProperty().set(0);
		vLine2.endXProperty().bind(pane.widthProperty().divide(3/2.));
		vLine2.endYProperty().bind(pane.heightProperty());
		vLine2.setFill(Color.RED);
		vLine2.setStroke(Color.RED);
		
		Line hLine1 = new Line();
		hLine1.startXProperty().set(0);
		hLine1.startYProperty().bind(pane.heightProperty().divide(3));
		hLine1.endXProperty().bind(pane.widthProperty());
		hLine1.endYProperty().bind(pane.heightProperty().divide(3));
		hLine1.setFill(Color.BLUE);
		hLine1.setStroke(Color.BLUE);
		
		Line hLine2 = new Line();
		hLine2.startXProperty().set(0);
		hLine2.startYProperty().bind(pane.heightProperty().divide(3/2.));
		hLine2.endXProperty().bind(pane.widthProperty());
		hLine2.endYProperty().bind(pane.heightProperty().divide(3/2.));
		hLine2.setFill(Color.BLUE);
		hLine2.setStroke(Color.BLUE);
		
		pane.getChildren().addAll(vLine1, vLine2, hLine1, hLine2);
	
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Exercise14_16");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
