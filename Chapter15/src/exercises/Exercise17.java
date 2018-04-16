package exercises;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise17 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		Rectangle recLeft = new Rectangle(50, 50, 200, 80);
		recLeft.setFill(null);
		recLeft.setStroke(Color.BLACK);
		
		Text lblInstruction = new Text(60, 70, "INSTRUCTION");
		lblInstruction.setFont(Font.font(20));
		Text lblAdd = new Text(60, 90, "Add: Left Click");
		lblAdd.setFont(Font.font(20));
		Text lblRemove = new Text(60, 110, "Remove: Right Click");
		lblRemove.setFont(Font.font(20));
		
		pane.getChildren().addAll(recLeft, lblInstruction, lblAdd, lblRemove);
		
		Rectangle recBounding = new Rectangle();
		recBounding.setFill(null);
		recBounding.setStroke(Color.BLACK);
		double radius = 10;
		
		pane.getChildren().add(recBounding);
		
		//define the add and remove circle action
		pane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				pane.getChildren().add(new Circle(e.getX(), e.getY(), radius));
				rebound(recBounding, pane);
			}
			else if (e.getButton() == MouseButton.SECONDARY) {
				for(Node node : pane.getChildren()) {
					if (node instanceof Circle && node.contains(e.getX(), e.getY())) {
						pane.getChildren().remove(node); // removing while iterating is dangerous(disastrous)
						rebound(recBounding, pane);
						break; 													 // but a break is here for the rescue
					}
				}	
			}
		});
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Exercise15_17");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void rebound(Rectangle rec, Pane pane) {
		double radius = 10; //assuming each circle has the same radius
		double minX = pane.getWidth(), minY = pane.getHeight(), maxX = 0, maxY = 0;
		for(Node node: pane.getChildren()) {
			if (node instanceof Circle) {
				if (((Circle)node).getCenterX() > maxX)
					maxX = ((Circle)node).getCenterX();
				if (((Circle)node).getCenterX() < minX)
					minX = ((Circle)node).getCenterX();
				if (((Circle)node).getCenterY() > maxY) 
					maxY = ((Circle)node).getCenterY();
				if (((Circle)node).getCenterY() < minY)
					minY = ((Circle)node).getCenterY();
			}
		}
		
		rec.setWidth(maxX - minX + 2 * radius);
		rec.setHeight(maxY - minY + 2 * radius);
		rec.setX(minX - radius);
		rec.setY(minY - radius);
	}
}
