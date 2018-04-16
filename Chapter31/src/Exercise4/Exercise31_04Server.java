package Exercise4;

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

public class Exercise31_04Server extends Application {

	private TextArea taLog = new TextArea();
	
	volatile int numberOfClients = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {

		Pane mainPane = new StackPane(taLog);

		Scene scene = new Scene(mainPane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise31_04Server");
		primaryStage.show();

		Thread serverThread = new Thread( () -> {
			try (ServerSocket serverSocket = new ServerSocket(8000)) {
				Platform.runLater( () -> taLog.appendText(new Date() + ": Exercise31_04Server started" + '\n'));

				//await incoming connection request
				while(true) {
					try {
						
						Socket client = serverSocket.accept();
						Platform.runLater( () -> {
							taLog.appendText("Starting thread " + numberOfClients + '\n');
							taLog.appendText("Client IP /" + client.getInetAddress().getHostAddress() + '\n');
							});
						
						//handle the client in a separate thread
						numberOfClients++;
						Thread newClientThread = new Thread(new ClientHandler(client));
						newClientThread.setDaemon(true);
						newClientThread.start();

					} catch(IOException ex) {
						taLog.appendText(ex.getMessage() + '\n');
					}
				}
			} catch(IOException ex) {
				taLog.appendText(ex.getMessage() + '\n');
			}
		});

		serverThread.setDaemon(true);
		serverThread.start();
	}

	class ClientHandler implements Runnable {

		Socket client;
		DataInputStream fromClient;
		DataOutputStream toClient; 

		public ClientHandler(Socket client) throws IOException {

			this.client = client;
			fromClient = new DataInputStream(client.getInputStream());
			toClient = new DataOutputStream(client.getOutputStream());
		}

		public void run() {
			try {

				toClient.writeInt(numberOfClients);
				
				while(true) {
					Thread.sleep(1000);
				}	
			} catch(IOException ex) {
				Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
			} catch (InterruptedException ex) { 
				Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
			}
		}
	}
}
