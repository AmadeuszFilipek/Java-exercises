package exercises;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise24 extends Application {

	public void start(Stage primaryStage) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter coordinates of five points: ");
		ArrayList<ArrayList<Double>> points = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			points.add(new ArrayList<>());
			points.get(i).add(scanner.nextDouble());
			points.get(i).add(scanner.nextDouble());
		}
		
		Point2D pnt = new Point2D(scanner.nextDouble(), scanner.nextDouble());
		
		scanner.close();
		
		Pane pane = new Pane();
		
		//create the polygon
		Polygon poly = new Polygon();
		for(ArrayList<Double> point: points)
			poly.getPoints().addAll(point);
		poly.setFill(null);
		poly.setStroke(Color.BLACK);
		
		//create a circle that shows the point
		Circle point = new Circle(pnt.getX(), pnt.getY(), 5);
		
		Text text = new Text();
		text.xProperty().set(50);
		text.yProperty().bind(pane.heightProperty().subtract(20));
		
		if (poly.contains(pnt))
			text.setText("The point is inside the polygon");
		else
			text.setText("The point is not inside the polygon");
		
		pane.getChildren().addAll(poly, point, text);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_24");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
