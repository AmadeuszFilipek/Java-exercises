package exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise6 extends Application {

	public void start(Stage primaryStage) {
		
		//Top pane
		HBox topBox = new HBox(10);
		topBox.setAlignment(Pos.CENTER);
		
		TextField tf = new TextField("JavaFX");
		Label lblTextField = new Label("Text Field");
		
		topBox.getChildren().addAll(lblTextField, tf);
		
		//bottom pane
		ToggleGroup tg = new ToggleGroup();
		RadioButton rbLeft = new RadioButton("Left");
		RadioButton rbCenter = new RadioButton("Center");
		RadioButton rbRight = new RadioButton("Right");
		
		rbLeft.setToggleGroup(tg);
		rbCenter.setToggleGroup(tg);
		rbRight.setToggleGroup(tg);
		
		rbLeft.setOnAction(e -> tf.setAlignment(Pos.BASELINE_LEFT));
		rbCenter.setOnAction(e -> tf.setAlignment(Pos.BASELINE_CENTER));		
		rbRight.setOnAction(e -> tf.setAlignment(Pos.BASELINE_RIGHT));
		
		TextField tfColSize = new TextField();
		tfColSize.setPrefWidth(50);
		
		Label lblColSize = new Label("ColumnSize", tfColSize);
		lblColSize.setContentDisplay(ContentDisplay.RIGHT);
		
		tfColSize.setOnAction(e -> {
			try {
				tf.setPrefColumnCount(Integer.parseInt(tfColSize.getText()));
			} catch(NumberFormatException ex) {}
		});
		
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		
		botBox.getChildren().addAll(rbLeft, rbCenter, rbRight, lblColSize, tfColSize);
		
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(topBox);
		mainPane.setBottom(botBox);
		
		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("Exercise16_06");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
