package Exercise2;

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

public class Exercise31_02Client extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		//top pane
		GridPane topPane = new GridPane();
		topPane.setHgap(10);
		topPane.setVgap(10);

		TextField tfWeight = new TextField();
		TextField tfHeight = new TextField();

		topPane.add(new Label("Weight in kilograms"), 0, 0);
		topPane.add(tfWeight, 1, 0);
		topPane.add(new Label("Height in meters"), 0, 1);
		topPane.add(tfHeight, 1, 1);

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
				double weight = Double.parseDouble(tfWeight.getText());
				double height = Double.parseDouble(tfHeight.getText());

				if (height > 0 && weight > 0)
					try (
							Socket connection = new Socket("localhost", 8000);
							DataInputStream fromServer = new DataInputStream(connection.getInputStream());
							DataOutputStream toServer = new DataOutputStream(connection.getOutputStream());
							) {

						toServer.writeDouble(weight);
						toServer.writeDouble(height);

						double BMI = fromServer.readDouble();
						String interpretation = fromServer.readUTF();

						Platform.runLater(() -> {
							taLog.appendText("Weight: " + weight + '\n');
							taLog.appendText("Height: " + height + '\n');
							taLog.appendText("BMI is : " + BMI + " " + interpretation + '\n');
						});
					} catch(IOException ex) {
						Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
					}
				// no server connection
				else {
					Platform.runLater(() -> taLog.appendText("Invalid input : negative or zero value" + '\n'));
				}
			} catch(NumberFormatException ex) {
				Platform.runLater(() -> taLog.appendText("Invalid input : not a number" + '\n'));
			}
		});
	}
}
