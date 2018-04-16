package exercises;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise15 extends Application {

	private static Label lblGrape = new Label("Grapes", new ImageView("grapes.png"));

	public void start(Stage primaryStage) {

		//top box
		ComboBox<ContentDisplay> cbbDisplay = new ComboBox<>();
		cbbDisplay.setItems(FXCollections.observableArrayList(ContentDisplay.values()));
		cbbDisplay.setOnAction(e -> lblGrape.setContentDisplay(cbbDisplay.getValue()));

		Label lblDisplay = new Label("Content Display", cbbDisplay);
		lblDisplay.setContentDisplay(ContentDisplay.RIGHT);

		TextField tfTextGap = new TextField();
		tfTextGap.setPrefColumnCount(5);
		tfTextGap.setOnAction(e -> {
			try {
				lblGrape.setGraphicTextGap(Integer.parseInt(tfTextGap.getText()));
			} catch (NumberFormatException ex) {}
		});
		
		Label lblTextGap = new Label("Graphic Text Gap", tfTextGap);
		lblTextGap.setContentDisplay(ContentDisplay.RIGHT);
		
		HBox topBox = new HBox(10);
		topBox.setAlignment(Pos.CENTER);
		topBox.getChildren().addAll(lblDisplay, lblTextGap);
		
		//mid box
		StackPane midPane = new StackPane();
		midPane.getChildren().add(lblGrape);
		
		//main pane
		BorderPane pane = new BorderPane();
		pane.setTop(topBox);
		pane.setCenter(midPane);
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Exercise16_15");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
