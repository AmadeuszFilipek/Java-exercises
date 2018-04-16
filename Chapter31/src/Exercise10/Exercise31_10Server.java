package Exercise10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise31_10Server extends Application {

	private static TextArea taLog = new TextArea();
//	private IntegerWrapper activeClients = new IntegerWrapper(0);
	private volatile int activeClients = 0;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		Scene scene = new Scene(taLog, 800, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise31_10Server");
		primaryStage.show();

		Thread serverThread = new Thread(() -> {

			try (ServerSocket server = new ServerSocket(8000)) {
				
				Platform.runLater(() ->	taLog.appendText("MultiThreadServer started at " + new Date() + '\n'));
					
				Map<Integer, DataOutputStream> toClients = 
						Collections.synchronizedMap(new HashMap<Integer,DataOutputStream>());
				Map<Integer, DataInputStream> fromClients = 
						Collections.synchronizedMap(new HashMap<Integer, DataInputStream>());
				
				//await incoming connections
				while (true) {
					
					Socket client = server.accept();
					Platform.runLater(() ->	taLog.appendText("Connection from socket " + client +
							" at " + new Date() + '\n'));
					
					toClients.put(activeClients, new DataOutputStream(client.getOutputStream()));
					fromClients.put(activeClients, new DataInputStream(client.getInputStream()));
					
					//create a new thread to handle this client
					Thread clientThread = new Thread(
							new ClientHandler(taLog, toClients, fromClients, activeClients));
	
					clientThread.setDaemon(true);
					clientThread.start();
					activeClients++;
				}
			} catch(IOException ex) {
				Platform.runLater(() ->	taLog.appendText(ex.getMessage()));
			}
		});

	serverThread.setDaemon(true);
	serverThread.start();
	}
}
