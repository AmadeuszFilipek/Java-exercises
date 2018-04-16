package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise12 extends Application {

	public void start(Stage primaryStage) {
		
		TextArea text = new TextArea();
		
		//load the text field from a file
		try (Scanner input = new Scanner(
				new File("C:/Amadeusz_all_files/Java/Chapter16/src/demos/BallPane.java"))) {
			while(input.hasNextLine()) {
				text.setText(text.getText() + input.nextLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		botBox.setPadding(new Insets(10));
		
		CheckBox cbEditable = new CheckBox("Editable");
		CheckBox cbWrap = new CheckBox("Wrap");
		
		cbEditable.setOnAction(e -> text.setEditable(cbEditable.isSelected()));
		cbWrap.setOnAction(e -> text.setWrapText(cbWrap.isSelected()));
		
		botBox.getChildren().addAll(cbEditable, cbWrap);
		
		BorderPane pane = new BorderPane();
		
		pane.setCenter(text);
		pane.setBottom(botBox);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_12");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
