package exercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise18 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		double xOffset = 400 / 2.;
		double yOffset = 300;
		
		//create axes
		Line axisX = new Line(0, yOffset, 350, yOffset);
		Line axisY = new Line(xOffset, 400,
													xOffset, 50);
		
		//create arrows for axes
		Polyline xArrow = new Polyline();
		
		xArrow.getPoints().add(350 - 20.);
		xArrow.getPoints().add(yOffset - 20);
		xArrow.getPoints().add(350.);
		xArrow.getPoints().add(yOffset);
		xArrow.getPoints().add(350 - 20.);
		xArrow.getPoints().add(yOffset + 20);
		
		Polyline yArrow = new Polyline();
		
		yArrow.getPoints().add(xOffset - 20);
		yArrow.getPoints().add(50. + 20);
		yArrow.getPoints().add(xOffset);
		yArrow.getPoints().add(50.);
		yArrow.getPoints().add(xOffset + 20);
		yArrow.getPoints().add(50. + 20);
		
		//create label for axes
		
		Text xLabel = new Text(350, yOffset - 20, "X");
		Text ylabel = new Text(xOffset + 20, 50, "Y");
		
		//generate function polyline
		Polyline polyline = new Polyline();
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for (int x = -100; x <= 100; x++) {
		list.add(x + xOffset);
		list.add(yOffset - scaleFactor * x * x);
		}
		
		pane.getChildren().addAll(axisX, xArrow, axisY, yArrow, xLabel, ylabel, polyline);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise14_18");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
