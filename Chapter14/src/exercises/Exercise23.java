package exercises;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise23 extends Application {

	public void start(Stage primaryStage) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter center coordinates, width and height of rectangle 1 :");
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();
		double width1 = scanner.nextDouble();
		double height1 = scanner.nextDouble();

		System.out.println("Please enter center coordinates, width and height of rectangle 1 :");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		double width2 = scanner.nextDouble();
		double height2 = scanner.nextDouble();
		scanner.close();
		
		Pane pane = new Pane();

		Rectangle rec1 = new Rectangle(x1, y1, width1, height1);
		rec1.setFill(null);
		rec1.setStroke(Color.BLACK);

		Rectangle rec2 = new Rectangle(x2, y2, width2, height2);
		rec2.setFill(null);
		rec2.setStroke(Color.BLACK);


		pane.getChildren().addAll(rec1, rec2);

		//create 2 MyRectangles2D to use the implemented in [10.13] methods
		MyRectangle2D myRec1 = new MyRectangle2D(x1, y1, width1, height1);
		MyRectangle2D myRec2 = new MyRectangle2D(x2, y2, width2, height2);
		String temp = null;

		if (myRec1.overlaps(myRec2))
			temp = "The rectangles overlap";
		else if (myRec1.contains(myRec2) || myRec2.contains(myRec1))
			temp = "One rectangle is contained in another";
		else
			temp = "The rectangles do not overlap";

		Text text = new Text(temp);
		text.xProperty().set(50);
		text.yProperty().bind(pane.heightProperty().subtract(30));
		pane.getChildren().add(text);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_23");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
