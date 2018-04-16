package exercises;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise14 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(30));
		
		Point2D highCorner = new Point2D(30, 30);
		Point2D lowCorner = new Point2D(15, 50);
		
		DoubleProperty cubeWidth = new SimpleDoubleProperty();
		DoubleProperty cubeHeight = new SimpleDoubleProperty();
		cubeWidth.bind(pane.widthProperty().subtract(60));
		cubeHeight.bind(pane.heightProperty().subtract(60));
		
		//lines connecting the rectangles creating the sides of the cube
		Line line1 = new Line();
		line1.startXProperty().set(highCorner.getX());
		line1.startYProperty().set(highCorner.getY());
		line1.endXProperty().set(lowCorner.getX());
		line1.endYProperty().set(lowCorner.getY());
		
		Line line2 = new Line();
		line2.startXProperty().bind(cubeWidth.add(highCorner.getX()));
		line2.startYProperty().set(highCorner.getY());
		line2.endXProperty().bind(cubeWidth.add(lowCorner.getX()));
		line2.endYProperty().set(lowCorner.getY());
		
		Line line3 = new Line();
		line3.startXProperty().set(highCorner.getX());
		line3.startYProperty().bind(cubeHeight.add(highCorner.getY()));
		line3.endXProperty().set(lowCorner.getX());
		line3.endYProperty().bind(cubeHeight.add(lowCorner.getY()));
		
		Line line4 = new Line();
		line4.startXProperty().bind(cubeWidth.add(highCorner.getX()));
		line4.startYProperty().bind(cubeHeight.add(highCorner.getY()));
		line4.endXProperty().bind(cubeWidth.add(lowCorner.getX()));
		line4.endYProperty().bind(cubeHeight.add(lowCorner.getY()));
		
		
		//the front rectangle
		Rectangle face = new Rectangle(highCorner.getX(), highCorner.getY(), cubeWidth.get(), cubeHeight.get());
		face.setFill(null); // that is truly no color, thus transparent rectangle
		face.setStroke(Color.BLACK);
		face.widthProperty().bind(cubeWidth);
		face.heightProperty().bind(cubeHeight);
		
		//the back rectangle
		Rectangle back = new Rectangle(lowCorner.getX(), lowCorner.getY(), cubeWidth.get(), cubeHeight.get());
		back.setFill(null);
		back.setStroke(Color.BLACK);
	//	back.setBlendMode(BlendMode.HARD_LIGHT);
		back.widthProperty().bind(cubeWidth);
		back.heightProperty().bind(cubeHeight);
		
		pane.getChildren().addAll(face, back, line1, line2, line3, line4);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_14");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
