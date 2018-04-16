package exercises;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14 extends Application {

	private static ComboBox<Integer> cbbSize = new ComboBox<>();
	private static ComboBox<String> cbbFont = new ComboBox<>();
	private static CheckBox cbBold = new CheckBox("Bold");
	private static CheckBox cbItalic = new CheckBox("Italic");
	private static Text text = new Text("Programming is fun");
	
	public void start(Stage primaryStage) {

		//middle pane
		StackPane midPane = new StackPane();
		midPane.getChildren().add(text);

		//top pane
		HBox topBox = new HBox(10);
		
		ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
		cbbFont.setItems(fonts);
		cbbFont.setValue(fonts.get(0));
		cbbFont.setOnAction(e -> setFont());

		Label lblFonts = new Label("Font Name", cbbFont);

		ObservableList<Integer> sizes = FXCollections.observableArrayList();
		for (int i = 1; i <= 100; i++)
			sizes.add(i);
		cbbSize.setItems(sizes);
		cbbSize.setOnAction(e -> setFont());
		cbbSize.setValue(40);
		
		Label lblSize = new Label("Font Size", cbbSize);

		topBox.getChildren().addAll(lblFonts, lblSize);

		//bot pane
		HBox botBox = new HBox(20);
		botBox.setAlignment(Pos.CENTER);
		
		//action for the check boxes
		cbBold.setOnAction(e -> setFont());
		cbItalic.setOnAction(e -> setFont());	
		
		botBox.getChildren().addAll(cbBold, cbItalic);

		//main pane
		BorderPane pane = new BorderPane();
		pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		pane.setPadding(new Insets(20));
		pane.setTop(topBox);
		pane.setCenter(midPane);
		pane.setBottom(botBox);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_14");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setFont() {
		if (cbBold.isSelected()) {
			if (cbItalic.isSelected())
				text.setFont(Font.font(cbbFont.getValue(), FontWeight.BOLD, FontPosture.ITALIC, cbbSize.getValue()));
			else
				text.setFont(Font.font(cbbFont.getValue(), FontWeight.BOLD, FontPosture.REGULAR, cbbSize.getValue()));
		}
		else {
			if (cbItalic.isSelected())
				text.setFont(Font.font(cbbFont.getValue(), FontWeight.NORMAL, FontPosture.ITALIC, cbbSize.getValue()));
			else
				text.setFont(Font.font(cbbFont.getValue(), FontWeight.NORMAL, FontPosture.REGULAR, cbbSize.getValue()));
		}	
	}
}
