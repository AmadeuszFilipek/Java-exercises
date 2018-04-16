package exercises;

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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise2 extends Application {

	private static Thread animation;
	private static CarPane pane = new CarPane();
	
	public void start (Stage primaryStage) {

		//		Timeline animation = new Timeline(new KeyFrame(
		//				Duration.millis(10), e -> {pane.translate();}));
		//		animation.setCycleCount(Timeline.INDEFINITE);
		//		animation.play();

		//use thread instead of animation and compare the animation speed
	
		pane.setOnMousePressed(e -> controlAnimation(true));
		pane.setOnMouseReleased(e -> controlAnimation(false));
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				pane.setSpeed(pane.getSpeed() + 1);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				pane.setSpeed(pane.getSpeed() - 1);
			}
		});

		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Exercise30_02");
		primaryStage.setScene(scene);
		primaryStage.show();

		pane.requestFocus(); //request focus on keyboard input
		
		controlAnimation(false);
	}
	
	public void controlAnimation(boolean running) {
		if (running) {
			animation.interrupt();			
		}
		else {
			animation = new Thread(pane);
			animation.setDaemon(true);
			animation.setPriority(Thread.MAX_PRIORITY);
			animation.start();
		}		
	}

	public static class CarPane extends Pane implements Runnable {

		private Circle leftWheel;
		private Circle rightWheel;
		private Rectangle body;
		private Polygon roof;
		private int speed = 1;

		public CarPane() {

			setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

			double x = 0, y = 100;
			leftWheel = new Circle(x + 15, y - 5, 5);
			rightWheel = new Circle(x + 35, y - 5, 5);
			body = new Rectangle(x, y - 20, 50, 10);
			body.setFill(Color.SIENNA);
			roof = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
			roof.setFill(Color.BLUEVIOLET);

			getChildren().addAll(leftWheel, rightWheel, body, roof);

		}

		public void run() {
			try {
				while(true) {
					translate();
					Thread.sleep(10);
				}
			} catch(InterruptedException ex) {}
		}
		
		public void translate() {
			translate(speed);
		}

		public void translate(double x) {

			//check if the car runs out of frame
			if (speed > 0) {
				if (leftWheel.getTranslateX() + x >= getWidth()) {
					setTranslate(0);
					return;
				}
			}
			else {
				if (leftWheel.getTranslateX() + x <= 0) {
					setTranslate(getWidth());
					return;
				}
			}

			leftWheel.setTranslateX(leftWheel.getTranslateX() + x);
			rightWheel.setTranslateX(rightWheel.getTranslateX() + x);
			body.setTranslateX(body.getTranslateX() + x);
			roof.setTranslateX(roof.getTranslateX() + x);
		}

		public void setTranslate(double x) {
			leftWheel.setTranslateX(x);
			rightWheel.setTranslateX(x);
			body.setTranslateX(x);
			roof.setTranslateX(x);
		}

		public int getSpeed()	{
			return this.speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}
	}
}
