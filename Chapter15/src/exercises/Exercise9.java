package exercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise9 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		ObservableList<Node> nodes = pane.getChildren();
		
		double lineLength = 30;
		MyPoint	position = new MyPoint(150, 150);
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Exercise15_09");
		primaryStage.setScene(scene);
	
		//scene is focused by default so it listens to key events
		//in order to make the pane handle the key event i would need to call the pane.requestFocus
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case DOWN: 
				nodes.add(new Line(position.getX(), position.getY(), position.getX(), position.getY() + lineLength));
				position.setY(position.getY() + lineLength);
				break;
			case UP: 
				nodes.add(new Line(position.getX(), position.getY(), position.getX(), position.getY() -lineLength)); 
				position.setY(position.getY() - lineLength);
				break;
			case LEFT: 
				nodes.add(new Line(position.getX(), position.getY(), position.getX() - lineLength, position.getY())); 
				position.setX(position.getX() - lineLength);
				break;
			case RIGHT: 
				nodes.add(new Line(position.getX(), position.getY(), position.getX() + lineLength, position.getY())); 
				position.setX(position.getX() + lineLength);
				break;
			default: break;
			}		
		});
		
		primaryStage.show();
	}
	
	public static class MyPoint {
		private double x;
		private double y;
		
		public MyPoint() {}
		
		public MyPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getX() {
			return x;
		}
		
		public double getY() {
			return y;
		}
		
		public void setX(double x) {
			this.x = x;
		}
		
		public void setY(double y) {
			this.y = y;
		}
	}
}
