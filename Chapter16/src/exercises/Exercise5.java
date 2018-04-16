package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise5 extends Application {

	private TextField tfDecimal = new TextField();
	private TextField tfHex = new TextField();
	private TextField tfBinary = new TextField();	

	public void start(Stage primaryStage) {

		GridPane pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setPadding(new Insets(20));
		pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		tfDecimal.setAlignment(Pos.BASELINE_RIGHT);
		tfHex.setAlignment(Pos.BASELINE_RIGHT);
		tfBinary.setAlignment(Pos.BASELINE_RIGHT);
		
		tfDecimal.setOnAction(e -> decimalInput());
		tfHex.setOnAction(e -> hexInput());
		tfBinary.setOnAction(e -> binaryInput());
		
		Label lblDecimal = new Label("Decimal");
		Label lblHex = new Label("Hex");
		Label lblBinary = new Label("Binary");
		
		pane.add(lblDecimal, 0, 0);
		pane.add(tfDecimal, 1, 0);
		pane.add(lblHex, 0, 1);
		pane.add(tfHex, 1, 1);
		pane.add(lblBinary, 0, 2);
		pane.add(tfBinary, 1, 2);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_05");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void decimalInput() {
		try {
			tfHex.setText(
					Integer.toHexString(
							Integer.parseInt(tfDecimal.getText(), 10))
					);
			tfBinary.setText(
					Integer.toBinaryString(
							Integer.parseInt(tfDecimal.getText(), 10))
					);
		} catch(NumberFormatException e) {
			tfHex.setText("Not a number");
			tfBinary.setText("Not a number");
		}
	}

	private void hexInput() {
		try {
			tfDecimal.setText(
					Integer.toString(
							Integer.parseInt(tfHex.getText(), 16))
					);
			tfBinary.setText(
					Integer.toBinaryString(
							Integer.parseInt(tfHex.getText(), 16))
					);
		} catch(NumberFormatException e) {
			tfDecimal.setText("Not a number");
			tfBinary.setText("Not a number");
		}
	}
	
	private void binaryInput() {
		try {
			tfHex.setText(
					Integer.toHexString(
							Integer.parseInt(tfBinary.getText(), 2))
					);
			tfDecimal.setText(
					Integer.toString(
							Integer.parseInt(tfBinary.getText(), 2))
					);
		} catch(NumberFormatException e) {
			tfHex.setText("Not a number");
			tfDecimal.setText("Not a number");
		}
	}
}
