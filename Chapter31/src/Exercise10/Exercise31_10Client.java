package Exercise10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise31_10Client extends Application {

	private static final String SERVER_ADDRESS = "2a02:a31a:a143:7c80:793c:d6cd:5907:bc72";

	private	TextField tfName = new TextField();
	private TextArea taMessageBoard = new TextArea();
	private TextField tfInputMessage = new TextField();
	private boolean connected = false;

	// jar cfev GaduGadu.jar Exercise10.Exercise31_10Client Exercise10/Exercise31_10Client.class icon.png
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		tfName.setFont(Font.font(18));
		taMessageBoard.setFont(Font.font(18));
		tfInputMessage.setFont(Font.font(18));
		
		taMessageBoard.setWrapText(true);
		
		HBox topBox = new HBox(20);
		topBox.setAlignment(Pos.CENTER);
		topBox.getChildren().addAll(new Label("Name"), tfName);

		taMessageBoard.setEditable(false);
		tfInputMessage.setPrefHeight(40);

		BorderPane mainPane = new BorderPane();
		mainPane.setTop(topBox);
		mainPane.setCenter(taMessageBoard);
		mainPane.setBottom(tfInputMessage);

		Button btnConnect = new Button("Connect");
		btnConnect.setOnAction(e -> {
			if (connected)
				Platform.runLater(() -> taMessageBoard.appendText("Already connected "+ '\n'));	
			else {
				connection().start();
			}
		});

		topBox.getChildren().add(btnConnect);

		Scene scene = new Scene(mainPane, 400, 300);
		primaryStage.getIcons().add(new Image(Exercise31_10Client.class.getResourceAsStream("/icon.png")));
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise31_10Client");
		primaryStage.show();
	}

	private Thread connection () {
		Thread connection = new Thread(() -> {
			try (Socket server = new Socket(SERVER_ADDRESS, 8000);
					DataOutputStream toServer = new DataOutputStream(server.getOutputStream());
					DataInputStream fromServer = new DataInputStream(server.getInputStream());
					){
				
				connected = true;

				tfInputMessage.setOnAction(e -> {
					try {
						toServer.writeUTF(tfInputMessage.getText());
						toServer.flush();
					} catch(IOException ex) {
						Platform.runLater(() -> taMessageBoard.appendText("No connection to the server" + '\n'));
					} finally {
						Platform.runLater(() -> tfInputMessage.clear());
					}
				});

				//send the name info
				toServer.writeUTF(tfName.getText().trim());

				//listen to the new messages of other clients
				while(true) {
					String message = fromServer.readUTF();
					Platform.runLater(() -> taMessageBoard.appendText(message + '\n'));
				}
			} catch (ConnectException ex) { 
				Platform.runLater(() -> taMessageBoard.appendText("Cannot connect to the server" + '\n'));
			} catch(IOException ex) {
				Platform.runLater(() -> taMessageBoard.appendText("Lost connection to the server" + '\n'));
			} finally {
				connected = false;
			}
		});
		
		connection.setDaemon(true);
		return connection;
	}
}
