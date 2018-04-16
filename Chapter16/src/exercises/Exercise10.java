package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class Exercise10 extends Application {

	private static TextArea textArea = new TextArea();
	
	public void start(Stage primaryStage) {
		
		textArea.setFont(Font.font(20));
		
		TextField tfFile = new TextField();
		tfFile.setOnAction(e -> readFile(tfFile.getText()));
		tfFile.setPrefColumnCount(30);
		Label lblFile = new Label("Filename", tfFile);
		lblFile.setContentDisplay(ContentDisplay.RIGHT);
		
		Button btnView = new Button("View");
		btnView.setOnAction(e -> readFile(tfFile.getText()));
		
		HBox botBox = new HBox(10);
		botBox.getChildren().addAll(tfFile, lblFile, btnView);
		
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(textArea);
		mainPane.setBottom(botBox);
		
		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("Exercise16_10");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private static void readFile(String filename) {
		try (Scanner input = new Scanner(new File(filename))) {
			textArea.clear();
			while(input.hasNextLine()) {
				textArea.setText(textArea.getText() + "\n" + input.nextLine()); 
			}
		} catch(FileNotFoundException ex) {
			textArea.setText(ex.getMessage());
		}
	}
}
