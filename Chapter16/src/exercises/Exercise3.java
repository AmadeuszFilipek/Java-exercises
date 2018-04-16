package exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise3 extends Application {

	public void start(Stage primaryStage) {
		
		//top pane
		Pane pane = new Pane();
		
		double lightWidth = 100;
		double lightHeight = 300;
		Rectangle recBody = new Rectangle(lightWidth, lightHeight);
		recBody.xProperty().bind(pane.widthProperty().subtract(lightWidth).divide(2));
		recBody.setY(20);
		recBody.setFill(null);
		recBody.setStroke(Color.BLACK);
		
		Circle crcRed = new Circle(40);
		crcRed.centerXProperty().bind(pane.widthProperty().divide(2));
		crcRed.setCenterY(recBody.getY() + crcRed.getRadius() + 10);
		crcRed.setStroke(Color.BLACK);
		
		Circle crcYellow = new Circle(40);
		crcYellow.centerXProperty().bind(pane.widthProperty().divide(2));
		crcYellow.setCenterY(crcRed.getCenterY() + 2 * crcRed.getRadius() + 10);
		crcYellow.setStroke(Color.BLACK);
		
		Circle crcGreen = new Circle(40);
		crcGreen.centerXProperty().bind(pane.widthProperty().divide(2));
		crcGreen.setCenterY(crcYellow.getCenterY() + 2 * crcYellow.getRadius() + 10);
		crcGreen.setStroke(Color.BLACK);
		
		
		pane.getChildren().addAll(recBody, crcRed, crcYellow, crcGreen);
		
		//bottom pane
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		
		ToggleGroup tg = new ToggleGroup();
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbGreen = new RadioButton("Green");
		
		rbRed.setToggleGroup(tg);
		rbYellow.setToggleGroup(tg);
		rbGreen.setToggleGroup(tg);
		
		rbRed.setOnAction(e -> {
			crcRed.setFill(Color.RED);
			crcYellow.setFill(Color.WHITE);
			crcGreen.setFill(Color.WHITE);
		});
		
		rbYellow.setOnAction(e -> {
			crcRed.setFill(Color.WHITE);
			crcYellow.setFill(Color.YELLOW);
			crcGreen.setFill(Color.WHITE);
		});
		
		
		rbGreen.setOnAction(e -> {
			crcRed.setFill(Color.WHITE);
			crcYellow.setFill(Color.WHITE);
			crcGreen.setFill(Color.GREEN);
		});
		
		botBox.getChildren().addAll(rbRed, rbYellow, rbGreen);
		
		// main pane
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(pane);
		mainPane.setBottom(botBox);
		
		//initial state
		rbRed.fire();
		
		Scene scene = new Scene(mainPane, 400, 400);
		primaryStage.setTitle("Exercise16_03");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
