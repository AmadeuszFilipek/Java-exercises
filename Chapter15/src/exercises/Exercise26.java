package exercises;

import javafx.animation.FadeTransition;
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

public class Exercise26 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(20));
		
		Arc arc = new Arc(200, 300, 100, 50, -30, -120);
		arc.setFill(null);
		arc.setStroke(Color.BLACK);
		arc.setType(ArcType.OPEN);
		
		Circle crcSwing = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 10);
		
		//define the animation of a ball
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(500));
		pt.setPath(arc);
		pt.setNode(crcSwing);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(500), crcSwing);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		
		pane.getChildren().addAll(arc, crcSwing);
		
		pane.setOnMousePressed(e -> {pt.pause(); ft.pause();});
		pane.setOnMouseReleased(e -> {pt.play(); ft.play();});
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_24");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
