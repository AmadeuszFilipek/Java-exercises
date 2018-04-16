package exercises;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise19 extends Application {

	public void start(Stage primaryStage) {

		ArrayList<FanWithControlsPane> fans = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			fans.add(new FanWithControlsPane());

		HBox midBox = new HBox(10);
		midBox.setAlignment(Pos.CENTER);
		midBox.getChildren().addAll(fans);

		Button btnStartAll = new Button("Start All");
		Button btnStopAll = new Button("Stop All");
		
		btnStartAll.setOnAction(e -> {
			for(FanWithControlsPane f : fans)
				f.start();
		});
		btnStopAll.setOnAction(e -> {
			for(FanWithControlsPane f : fans)
				f.stop();
		});
		
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		botBox.getChildren().addAll(btnStartAll, btnStopAll);
	
		BorderPane pane = new BorderPane();
		pane.setCenter(midBox);
		pane.setBottom(botBox);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_19");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static class FanWithControlsPane extends BorderPane {

		private double fanSpeed = 5;

		//add the control buttons
		private Button pause = new Button("Pause");
		private Button resume = new Button("Resume");
		private Button reverse = new Button("Reverse");		

		public FanWithControlsPane() {

			//create a fan
			FanPane fan = new FanPane(100);
			fan.setCenterShape(true);

			//define the animation for the fan
			Timeline animation = new Timeline(
					new KeyFrame(Duration.millis(10), e -> {fan.rotate(fanSpeed);}));
			animation.setAutoReverse(false);
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();

			//define the actions for buttons
			pause.setOnAction(e -> {animation.pause();});
			resume.setOnAction(e -> {animation.play();});
			reverse.setOnAction(e -> {fan.reverse();});

			HBox hBox = new HBox(10);
			hBox.getChildren().addAll(pause, resume, reverse);
			hBox.setAlignment(Pos.CENTER);

			//define the slider
			Slider slSpeed = new Slider(0, 50, 5);
			slSpeed.setBlockIncrement(2);
			slSpeed.valueProperty().addListener(e -> setSpeed(slSpeed.getValue()));

			//place everything on the main border pane
			setTop(hBox);
			setCenter(fan);
			setBottom(slSpeed);
			setPadding(new Insets(10));
			setStyle("-fx-border-color: black");
		}

		public void setSpeed(double v) {
			fanSpeed = v;
		}

		public void start() {
			resume.fire();
		}

		public void stop() {
			pause.fire();
		}
	}

	public static class FanPane extends Pane {

		private Circle circle;
		private List<Arc> fans;
		private int direction = 1;

		public FanPane(double radius) {
			setPadding(new Insets(20));
			setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

			//create a bounding circle
			circle = new Circle(radius, radius, radius);
			circle.centerXProperty().bind(widthProperty().divide(2));
			circle.centerYProperty().bind(heightProperty().divide(2));
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);

			//create fans
			fans = new ArrayList<>();
			for (int f = 0; f < 4; f ++) {
				Arc arc = new Arc(circle.getCenterX(), circle.getCenterY(), radius * 0.9, radius * 0.9, 45/2. + 90 * f, 45);
				arc.centerXProperty().bind(circle.centerXProperty());
				arc.centerYProperty().bind(circle.centerYProperty());
				arc.setFill(Color.RED);
				arc.setType(ArcType.ROUND);
				fans.add(arc);
			}

			getChildren().add(circle);
			getChildren().addAll(fans);
		}

		public void rotate(double degree) {
			for(Arc fan : fans) {
				fan.setStartAngle(fan.getStartAngle() + degree * direction);
			}	
		}

		public void reverse() {
			direction = -direction;
		}
	}
}
