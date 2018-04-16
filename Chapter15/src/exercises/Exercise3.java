package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise3 extends Application {

	public void start(Stage primaryStage) {
		
		BallPane ballPane = new BallPane();

		double translation = 20;
		Button btnLeft = new Button("Left");
		btnLeft.setOnAction(e -> {ballPane.moveLeft(translation);});
		
		Button btnRight = new Button("Right");
		btnRight.setOnAction(e -> {ballPane.moveRight(translation);});
		
		Button btnUp = new Button("Up");
		btnUp.setOnAction(e -> {ballPane.moveUp(translation);});
		
		Button btnDown = new Button("Down");
		btnDown.setOnAction(e -> {ballPane.moveDown(translation);});
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.getChildren().addAll(btnLeft, btnRight, btnUp, btnDown);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setBottom(buttons);
		BorderPane.setAlignment(buttons, Pos.CENTER);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise15_03");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class BallPane extends Pane {
		
		private Circle circle;
		private final double RADIUS = 50;
		
		public BallPane() {
			super();
			this.setPadding(new Insets(30));
			circle = new Circle(RADIUS, RADIUS, RADIUS);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			getChildren().add(circle);
		}
		
		public void moveLeft(double tranlation) {
			if (circle.getCenterX() - RADIUS - tranlation > 0)
				circle.setCenterX(circle.getCenterX() - tranlation);
		}
		
		public void moveRight(double translation) {
			if (circle.getCenterX() + RADIUS + translation < this.getWidth())
				circle.setCenterX(circle.getCenterX() + translation);
		}
		
		public void moveUp(double translation) {
			if (circle.getCenterY() - RADIUS - translation > 0)
				circle.setCenterY(circle.getCenterY() - translation);
		}
		
		public void moveDown(double translation) {
			if (circle.getCenterY() + RADIUS + translation < this.getHeight())
				circle.setCenterY(circle.getCenterY() + translation);
		}
	}
}
