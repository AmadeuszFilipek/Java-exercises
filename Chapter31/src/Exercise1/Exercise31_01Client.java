package Exercise1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise31_01Client extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		//top pane
		GridPane topPane = new GridPane();
		topPane.setHgap(10);
		topPane.setVgap(10);

		TextField tfAnnualInterestRate = new TextField();
		TextField tfNumberOfYears = new TextField();
		TextField tfLoanAmount = new TextField();

		topPane.add(new Label("Annual Interest Rate"), 0, 0);
		topPane.add(tfAnnualInterestRate, 1, 0);
		topPane.add(new Label("Number Of Years"), 0, 1);
		topPane.add(tfNumberOfYears, 1, 1);
		topPane.add(new Label("Loan Amount"), 0, 2);
		topPane.add(tfLoanAmount, 1, 2);

		Button btSubmit = new Button("Submit");
		topPane.add(btSubmit, 2, 1);

		//main pane
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(topPane);

		TextArea taLog = new TextArea();
		mainPane.setCenter(taLog);

		Scene scene = new Scene(mainPane, 400, 300);
		primaryStage.setTitle("Exercise31_01Client");
		primaryStage.setScene(scene);
		primaryStage.show();

		btSubmit.setOnAction(e -> {
			
			try { 
				// try parsing the numbers, if the data is invalid, do not engage the server connection
				// a client should never be able to disturb the server in any way
				double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
				int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());
				double loanAmount = Double.parseDouble(tfLoanAmount.getText());

				try (
						Socket connection = new Socket("localhost", 8000);
						DataInputStream fromServer = new DataInputStream(connection.getInputStream());
						DataOutputStream toServer = new DataOutputStream(connection.getOutputStream());
						) {

					toServer.writeDouble(annualInterestRate);
					toServer.writeInt(numberOfYears);
					toServer.writeDouble(loanAmount);

					double monthlyPayment = fromServer.readDouble();
					double totalPayment = fromServer.readDouble();

					Platform.runLater(() -> {
						taLog.appendText("Annual interest rate: " + annualInterestRate + '\n');
						taLog.appendText("Number of years: " + numberOfYears + '\n');
						taLog.appendText("Loan amount: " + loanAmount + '\n');
						taLog.appendText("Monthly payment: " + monthlyPayment + '\n');
						taLog.appendText("Total payment: " + totalPayment + '\n');
					});
				} catch(IOException ex) {
					Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
				}
			} catch(NumberFormatException ex) {
				Platform.runLater(() -> taLog.appendText("Invalid input : not a number" + '\n'));
			}
		});
	}
}
