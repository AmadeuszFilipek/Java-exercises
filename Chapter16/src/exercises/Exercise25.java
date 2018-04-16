package exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise25 extends Application {

	public void start(Stage primaryStage) {

		//top box
		HBox topBox = new HBox(10);
		topBox.setAlignment(Pos.CENTER);
		topBox.setPadding(new Insets(20));

		CarPane car1 = new CarPane();
		CarPane car2 = new CarPane();
		CarPane car3 = new CarPane();
		CarPane car4 = new CarPane();

		CarTextField tfCar1 = new CarTextField(car1);
		CarTextField tfCar2 = new CarTextField(car2);
		CarTextField tfCar3 = new CarTextField(car3);
		CarTextField tfCar4 = new CarTextField(car4);

		topBox.getChildren().addAll(new Label("Car 1:"), tfCar1, 
				new Label("Car 2:"), tfCar2, new Label("Car 3:"), tfCar3, new Label("Car 4: "), tfCar4);

		VBox mainPane = new VBox(10);
		mainPane.getChildren().addAll(topBox, car1, car2, car3, car4);

		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("Exercise16_25");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static class CarTextField extends TextField {

		private CarPane car;

		CarTextField(CarPane car) {
			this.car = car;
			setPrefColumnCount(5);

			setOnAction(e -> {
				try {
					this.car.setSpeed(Integer.parseInt(getText()));
				} catch(NumberFormatException ex) {
					setText("NaN");
				}
			});

			setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.TAB)
					try {
						this.car.setSpeed(Integer.parseInt(getText()));
					} catch(NumberFormatException ex) {
						setText("NaN");
					}
			});
		}
	}
	public static class CarPane extends Pane {

		private Circle leftWheel;
		private Circle rightWheel;
		private Rectangle body;
		private Polygon roof;
		private int speed = 1;

		public CarPane() {

			Timeline animation = new Timeline(new KeyFrame(
					Duration.millis(10), e -> {translate();}));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();

			setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

			double x = 0, y = 100;
			leftWheel = new Circle(x + 15, y - 5, 5);
			rightWheel = new Circle(x + 35, y - 5, 5);
			body = new Rectangle(x, y - 20, 50, 10);
			body.setFill(Color.SIENNA);
			roof = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
			roof.setFill(Color.BLUEVIOLET);

			getChildren().addAll(leftWheel, rightWheel, body, roof);

			this.setStyle("-fx-border-color: black");
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
