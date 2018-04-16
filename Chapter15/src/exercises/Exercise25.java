package exercises;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise25 extends Application {

		public void start(Stage primaryStage) {

			Pane pane = new Pane();

			double xOffset = 400 / 2.;
			double yOffset = 200;
			double xLength = 400;
			double yLength = 400;
			double scaleFactor = 50;
			//create axes
			Line axisX = new Line(0, yOffset, xLength, yOffset);
			Line axisY = new Line(xOffset, yLength + 50,
					xOffset, 50);

			//create tics for x axis
			pane.getChildren().add(new Text(xOffset + 5, yOffset + 10, "0"));
			pane.getChildren().add(new Text(xOffset - 25 * Math.PI, yOffset + 10, "-\u03c0"));
			pane.getChildren().add(new Text(xOffset - 25 * 2 * Math.PI, yOffset + 10, "-2\u03c0"));
			pane.getChildren().add(new Text(xOffset + 25. * Math.PI, yOffset + 10, "+\u03c0"));
			pane.getChildren().add(new Text(xOffset + 2 * 25. * Math.PI, yOffset + 10, "+2\u03c0"));

			//create arrows for axes
			Polyline xArrow = new Polyline();

			xArrow.getPoints().add(xLength - 20.);
			xArrow.getPoints().add(yOffset - 20);
			xArrow.getPoints().add(xLength);
			xArrow.getPoints().add(yOffset);
			xArrow.getPoints().add(xLength - 20.);
			xArrow.getPoints().add(yOffset + 20);

			Polyline yArrow = new Polyline();

			yArrow.getPoints().add(xOffset - 20);
			yArrow.getPoints().add(50. + 20);
			yArrow.getPoints().add(xOffset);
			yArrow.getPoints().add(50.);
			yArrow.getPoints().add(xOffset + 20);
			yArrow.getPoints().add(50. + 20);

			//create label for axes
			Text xLabel = new Text(350, yOffset - 20, "X");
			Text yLabel = new Text(xOffset + 20, 50, "Y");

			Polyline sine = new Polyline();
			sine.setStroke(Color.RED);
			ObservableList<Double> list = sine.getPoints();
			for (int x = -170; x <= 170; x++) {
				list.add(x + xOffset);
				list.add(yOffset - scaleFactor * Math.sin(x / 25.));
			}

			//create a ball
			Circle crcBall = new Circle(10);
			
			//define the animation of ball
			PathTransition pt = new PathTransition();
			pt.setPath(sine);
			pt.setNode(crcBall);
			pt.setDuration(Duration.millis(1000));
			pt.setCycleCount(Timeline.INDEFINITE);
			pt.setAutoReverse(false);
			pt.play();
			
			//define the play/stop actions
			pane.setOnMouseClicked(e -> {
				if (e.getButton() == MouseButton.PRIMARY) {
					pt.play();
					return;
				}
				if (e.getButton() == MouseButton.SECONDARY) {
					pt.pause();
				}
			});
			
			pane.getChildren().addAll(axisX, axisY, xArrow, yArrow, xLabel, yLabel, sine, crcBall);

			Scene scene = new Scene(pane, 500, 300);
			primaryStage.setTitle("Exercise14_19");
			primaryStage.setScene(scene);
			primaryStage.show();


		}
	}
