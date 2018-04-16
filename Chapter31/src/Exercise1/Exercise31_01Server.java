package Exercise1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise31_01Server extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		TextArea taLog = new TextArea();

		Pane mainPane = new StackPane(taLog);

		Scene scene = new Scene(mainPane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise31_01Server");
		primaryStage.show();

		Thread serverThread = new Thread( () -> {
			try (ServerSocket serverSocket = new ServerSocket(8000)) {
				Platform.runLater( () -> taLog.appendText(new Date() + ": Exercise31_01Server started" + '\n'));

				//await incoming connection request
				while(true) {
					try (
							Socket client = serverSocket.accept();
							DataInputStream fromClient = new DataInputStream(client.getInputStream());
							DataOutputStream toClient = new DataOutputStream(client.getOutputStream());
							) {
						Platform.runLater( () -> taLog.appendText(new Date() + 
								": New client connected with IP: " + client.getInetAddress().getHostAddress() + '\n'));

						double annualInterestRate = fromClient.readDouble();
						int numberOfYears = fromClient.readInt();
						double loanAmount = fromClient.readDouble();

						double monthlyInterestRate = annualInterestRate / 100 / 12;
						double monthlyPayment = loanAmount * monthlyInterestRate /
								(1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
						double totalPayment = monthlyPayment * numberOfYears * 12;

						toClient.writeDouble(monthlyPayment);
						toClient.writeDouble(totalPayment);

						Platform.runLater(() -> {
							taLog.appendText("Annual interest rate: " + annualInterestRate + '\n');
							taLog.appendText("Number of years: " + numberOfYears + '\n');
							taLog.appendText("Loan amount: " + loanAmount + '\n');
							taLog.appendText("Monthly payment: " + monthlyPayment + '\n');
							taLog.appendText("Total payment: " + totalPayment + '\n');
						});
					}
				}
			} catch(IOException ex) {
				taLog.appendText(ex.getMessage() + '\n');
			}
		});

		serverThread.setDaemon(true);
		serverThread.start();
	}
}

