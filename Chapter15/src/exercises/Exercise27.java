package exercises;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise27 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		Text txt = new Text("Programming is fun");
		txt.setFont(Font.font(25));

		//create a guideline for the text animation
		Line line = new Line();
		line.startXProperty().set(- 150);
		line.startYProperty().bind(pane.heightProperty().divide(2));;
		line.endXProperty().bind(pane.widthProperty().add(150));
		line.endYProperty().bind(pane.heightProperty().divide(2));

		pane.getChildren().addAll(txt);
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Exercise15_27");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		PathTransition pt = new PathTransition();
		pt.setAutoReverse(false);
		pt.setNode(txt);
		pt.setPath(line);
		pt.setDuration(Duration.millis(2000));
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		pane.setOnMousePressed(e -> {pt.pause();});
		pane.setOnMouseReleased(e -> {pt.play();});
	}
}
