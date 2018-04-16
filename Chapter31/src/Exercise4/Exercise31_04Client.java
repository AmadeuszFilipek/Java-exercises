package Exercise4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise31_04Client extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		
		try(Socket socket = new Socket("localhost", 8000)) {
			
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			
			int visitorNo = fromServer.readInt();
			
			StackPane pane = new StackPane(new Label("You are visitor " + visitorNo));
			pane.setPadding(new Insets(20));
			
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercise31_04Client");
			primaryStage.show();
			
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
