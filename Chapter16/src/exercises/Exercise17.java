package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise17 extends Application {

	private static Slider slRed = new Slider(0, 255, 255);
	private static Slider slGreen = new Slider(0, 255, 255);
	private static Slider slBlue = new Slider(0, 255, 0);
	private static Slider slOpacity = new Slider(0, 1, 0);

	private static Text text = new Text("Show Colors");

	public void start(Stage primaryStage) {

		Label lblRed = new Label("Red");
		Label lblGreen = new Label("Green");
		Label lblBlue = new Label("Blue");
		Label lblOpacity = new Label("Opacity");
//
//		lblRed.setContentDisplay(ContentDisplay.RIGHT);
//		lblGreen.setContentDisplay(ContentDisplay.RIGHT);
//		lblBlue.setContentDisplay(ContentDisplay.RIGHT);
//		lblOpacity.setContentDisplay(ContentDisplay.RIGHT);

		text.setFont(Font.font(50));
		updateColor();
		slRed.valueProperty().addListener(e -> updateColor());
		slGreen.valueProperty().addListener(e -> updateColor());
		slBlue.valueProperty().addListener(e -> updateColor());
		slOpacity.valueProperty().addListener(e -> updateColor());

		StackPane midPane = new StackPane(text);
		
		GridPane botPane = new GridPane();
		botPane.setHgap(10);
		botPane.setVgap(10);
		botPane.setAlignment(Pos.CENTER);
		botPane.add(lblRed, 0, 0); botPane.add(slRed, 1, 0);
		botPane.add(lblGreen, 0, 1); botPane.add(slGreen, 1, 1);
		botPane.add(lblBlue, 0, 2); botPane.add(slBlue, 1, 2);
		botPane.add(lblOpacity, 0, 3); botPane.add(slOpacity, 1, 3);
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(20));
		pane.setCenter(midPane);
		pane.setBottom(botPane);

		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise16_17");
		primaryStage.show(); 
	}

	private static void updateColor() {
		text.setFill(Color.rgb(
				(int)slRed.getValue(), (int)slGreen.getValue(),
				(int)slBlue.getValue(), slOpacity.getValue()));
	}
}
