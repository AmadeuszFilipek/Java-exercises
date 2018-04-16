package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise11 extends Application {
	public void start(Stage primaryStage) {

		BallPane ballPane = new BallPane();
		double translation = 20;
		
		Scene scene = new Scene(ballPane, 400, 400);
		
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case DOWN: ballPane.moveDown(translation); break;
			case UP: ballPane.moveUp(translation); break;
			case LEFT: ballPane.moveLeft(translation);	break;
			case RIGHT: ballPane.moveRight(translation); break;
			default: break;
			}
		});
		
		primaryStage.setTitle("Exercise15_11");
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

		public void moveLeft(double translation) {
			if (circle.getCenterX() - RADIUS - translation > 0)
				circle.setCenterX(circle.getCenterX() - translation);
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
