package exercises;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise24 extends Application {
	
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(20));
		
		Arc arc = new Arc(200, 300, 100, 50, -30, -120);
		arc.setFill(null);
		arc.setStroke(Color.BLACK);
		arc.setType(ArcType.OPEN);
		
		Circle crcSwing = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 10);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(200));
		pt.setPath(arc);
		pt.setNode(crcSwing);
//		pt.setOrientation(
//				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		pane.getChildren().addAll(arc, crcSwing);
		
		pane.setOnMousePressed(e -> {pt.pause();});
		pane.setOnMouseReleased(e -> {pt.play();});
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_24");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
