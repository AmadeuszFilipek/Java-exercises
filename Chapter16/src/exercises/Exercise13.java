package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise13 extends Application {

	private static TextArea taTable = new TextArea();
	private static TextField tfLoanAmount = new TextField();
	private static TextField tfYears = new TextField();

	public void start(Stage primaryStage) {

		taTable.setFont(Font.font(18));
		
		HBox topBox = new HBox(10);

		tfLoanAmount.setPrefColumnCount(10);
		Label lblLoanAmount = new Label("LoanAmount", tfLoanAmount);
		lblLoanAmount.setContentDisplay(ContentDisplay.RIGHT);

		tfYears.setPrefColumnCount(5);
		Label lblYears = new Label("Number of Years", tfYears);
		lblYears.setContentDisplay(ContentDisplay.RIGHT);

		Button btnShow = new Button("Show Table");
		btnShow.setOnAction(e -> calculatePayment());
		
		topBox.getChildren().addAll(lblLoanAmount, lblYears, btnShow);

		BorderPane pane = new BorderPane();
		
		pane.setTop(topBox);
		pane.setCenter(taTable);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_13");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static void calculatePayment() {
		try {	
			calculatePayment(
					Double.parseDouble(tfLoanAmount.getText()),
					Integer.parseInt(tfYears.getText()));
		} catch (NumberFormatException ex) {
			taTable.clear();
			taTable.setText(ex.getMessage());
		}
	}

	private static void calculatePayment(double loanAmount, int years) {
		taTable.clear();
		taTable.setText("Interest Rate\tMonthly Payment\tTotal Payment\n");

		for(double i = 5 / 100.; i < 8.1 / 100.; i += 1 / 8. / 100.) {
			
			double monthlyPayment = loanAmount * i / 12 / (1 - 1 / Math.pow(1 + i / 12, years * 12));
			double totalPayment = monthlyPayment * years * 12;
			
			taTable.setText( taTable.getText() + 
					String.format("%.3f\t\t%.2f\t\t\t%.2f\n", i * 100, monthlyPayment, totalPayment));
			
		}
	}
}

