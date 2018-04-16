package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise4 extends Application {

	private final double MILE_TO_KILOMETERS = 1.609344;
	private TextField tfMile = new TextField();
	private TextField tfKilometer = new TextField();

	public void start(Stage primaryStage) {

		GridPane pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setPadding(new Insets(20));
		
		Label lblMile = new Label("Mile");
		Label lblKilometer = new Label("Kilometer");
		
		tfMile.setOnAction(e -> calculateKilometers());
		tfKilometer.setOnAction(e -> calculateMiles());
		
		pane.add(lblMile, 0, 0);
		pane.add(tfMile, 1, 0);
		pane.add(lblKilometer, 0, 1);
		pane.add(tfKilometer, 1, 1);
			
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_04");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	

	private void calculateMiles() {
		try {
			tfMile.setText(
					Double.toString(
							(Double.parseDouble(tfKilometer.getText()) / MILE_TO_KILOMETERS))
					);
		} catch(NumberFormatException ex) {
			tfMile.setText("Not a number");
		}
	}

	private void calculateKilometers() {
		try {
			tfKilometer.setText(
					Double.toString(
							(Double.parseDouble(tfMile.getText()) * MILE_TO_KILOMETERS))
					);
		} catch(NumberFormatException ex) {
			tfKilometer.setText("Not a number");
		}
	}
}
