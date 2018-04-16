package exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise31 extends Application {

	public void start(Stage primaryStage) {

		PendulumPane pane = new PendulumPane();

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_31");
		primaryStage.setScene(scene);
		primaryStage.show();

		pane.requestFocus();
	}

	public static class PendulumPane extends Pane {

		private Circle crcPin;
		private Circle crcPath;	
		private Circle crcMass;
		private Line lnPendulum;
		private Timeline animation;

		// initial simulation parameters;
		private double angle = 0; // in degrees
		private double time = 0; // in seconds
		private double timeSpeed = 0.001; //in seconds
		private double selfFrequency = 1; //in ones over second
		private double amplitude = 30; // in degrees

		public PendulumPane() {

			setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

			crcPin = new Circle(200, 50, 5);
			crcPath = new Circle(200, 50, 300);
			crcMass = new Circle(crcPath.getCenterX(), crcPath.getCenterY() + crcPath.getRadius(), 10);
			lnPendulum = new Line();
			lnPendulum.setStartX(crcPath.getCenterX());
			lnPendulum.setStartY(crcPath.getCenterY());
			lnPendulum.endXProperty().bind(crcMass.centerXProperty());
			lnPendulum.endYProperty().bind(crcMass.centerYProperty());

			getChildren().addAll(crcPin, crcMass, lnPendulum);
			setPadding(new Insets(20));
			
			//define the animation
			animation = new Timeline(new KeyFrame(Duration.millis(10), e -> {
				propagate();
			}));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
			
			//define the actions to control the animation
			setOnMousePressed(e -> {animation.pause();});
			setOnMouseReleased(e -> {animation.play();});

			setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.UP) {
					setTimeSpeed(getTimeSpeed() + 0.001);
				}
				else if (e.getCode() == KeyCode.DOWN) {
					setTimeSpeed(getTimeSpeed() - 0.001);
				}
			});

		}

		public void setTimeSpeed(double speed) {
			timeSpeed = speed;
		}

		public double getTimeSpeed() {
			return timeSpeed;
		}

		public void propagate() {
			time += timeSpeed;
			angle = amplitude * Math.cos(selfFrequency * time * 2 * Math.PI);
	
			//analytical solution for small angles is used, but that is not essential in this exercise
			crcMass.setCenterX(crcPath.getCenterX() + crcPath.getRadius() * Math.cos(angle * Math.PI / 180. - Math.PI / 2.));
			crcMass.setCenterY(crcPath.getCenterY() - crcPath.getRadius() * Math.sin(angle * Math.PI / 180. - Math.PI / 2.));
		}
	}
}
