package exercises;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise5 extends Application {

	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20));

		TextField investmentAmount = new TextField();
		TextField numberOfYears = new TextField();
		TextField annualInterestRate = new TextField();
		TextField futureValue = new TextField();
		futureValue.setEditable(false);

		gridPane.add(investmentAmount, 1, 0);
		gridPane.add(new Label("Investement Amount:"), 0, 0);
		gridPane.add(numberOfYears, 1, 1);
		gridPane.add(new Label("Number of years:"), 0, 1);
		gridPane.add(annualInterestRate, 1, 2);
		gridPane.add(new Label("Annual Interes Rate:"), 0, 2);
		gridPane.add(futureValue, 1, 3);
		gridPane.add(new Label("Future Value:"), 0, 3);

		Button btCalculate = new Button("Calculate");
		btCalculate.setOnAction(e -> {
			try {
				futureValue.setText(Double.toString(
						Double.parseDouble(investmentAmount.getText()) *
						Math.pow((1 + 1. / 12 / 100 * Double.parseDouble(annualInterestRate.getText())),
								12 * Double.parseDouble(numberOfYears.getText()))
						));
			} catch(NumberFormatException ex) {
				futureValue.setText("Invalid number format input");
			}
		});

		gridPane.add(btCalculate, 1, 4);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);
		
		investmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
		numberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		annualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		futureValue.setAlignment(Pos.BOTTOM_RIGHT);
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Exercise15_05");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
