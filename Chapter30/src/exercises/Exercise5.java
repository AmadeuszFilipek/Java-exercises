package exercises;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise5 extends Application {

	public static Thread animation;

	public void start(Stage primaryStage) {

		VBox pane = new VBox(10);
		HBox hBox = new HBox(10);

		//create a fan
		FanPane fan = new FanPane(100);
		fan.setCenterShape(true);

		//use a thread instead
		//		//define the animation for the fan
		//		Timeline animation = new Timeline(
		//				new KeyFrame(Duration.millis(10), e -> {fan.rotate(5);}));
		//		animation.setAutoReverse(false);
		//		animation.setCycleCount(Timeline.INDEFINITE);
		//		animation.play();
		//		
		//add the control buttons
		Button pause = new Button("Pause");
		Button resume = new Button("Resume");
		Button reverse = new Button("Reverse");		

		//define the actions for buttons
		pause.setOnAction(e -> animationControl(true, fan));
		resume.setOnAction(e -> animationControl(false, fan));
		reverse.setOnAction(e -> {fan.reverse();});

		hBox.getChildren().addAll(pause, resume, reverse);
		hBox.setAlignment(Pos.BOTTOM_CENTER);

		pane.getChildren().addAll(fan, hBox);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_28");
		primaryStage.setScene(scene);
		primaryStage.show();

		animationControl(false, fan);
	}

	public static void animationControl(boolean isRunning, FanPane fan) {

		if (isRunning) {
			if (animation != null) {
				animation.interrupt();
				animation = null;
			}
		}
		else {
			if (animation == null) {
				animation = new Thread(() -> {
					try {
						while(true) {
							fan.rotate(5);
							Thread.sleep(10); 
						}
					} catch(InterruptedException ex) { }
				});

				animation.setDaemon(true);
				animation.start();
			}
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
