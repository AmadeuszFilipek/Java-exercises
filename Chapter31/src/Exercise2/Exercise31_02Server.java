package Exercise2;

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

public class Exercise31_02Server extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		TextArea taLog = new TextArea();

		Pane mainPane = new StackPane(taLog);

		Scene scene = new Scene(mainPane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise31_02Server");
		primaryStage.show();

		Thread serverThread = new Thread( () -> {
			try (ServerSocket serverSocket = new ServerSocket(8000)) {
				Platform.runLater( () -> taLog.appendText(new Date() + ": Exercise31_02Server started" + '\n'));

				//await incoming connection request
				while(true) {
					try (
							Socket client = serverSocket.accept();
							DataInputStream fromClient = new DataInputStream(client.getInputStream());
							DataOutputStream toClient = new DataOutputStream(client.getOutputStream());
							) {
						Platform.runLater( () -> taLog.appendText(new Date() + 
								": New client connected with IP: " + client.getInetAddress().getHostAddress() + '\n'));

						//data has to be correct here
						double weight = fromClient.readDouble();
						double height = fromClient.readDouble();
						double BMI = weight / height / height;
						String interpretation;
						
						if (BMI < 18.5)
							interpretation = "underweight";
						else if (BMI < 25)
							interpretation = "Normal";
						else if (BMI < 30)
							interpretation = "Overweight";
						else
							interpretation = "Obese";

						toClient.writeDouble(BMI);
						toClient.writeUTF(interpretation);
						
						Platform.runLater(() -> {
							taLog.appendText("Weight: " + weight + '\n');
							taLog.appendText("Height: " + height + '\n');
							taLog.appendText("BMI is : " + BMI + " " + interpretation + '\n');
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
