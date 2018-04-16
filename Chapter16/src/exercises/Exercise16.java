package exercises;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16 extends Application {

	private static final String[] COUNTRIES = {"China", "Japan", "Korea", "India", "Malaysia", "Vietnam"};
	private static Text txtSelected = new Text();
	private static ListView<String> lvCountries = new ListView<>();
	
	public void start (Stage primaryStage) {
		
		lvCountries.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lvCountries.setItems(FXCollections.observableArrayList(COUNTRIES));
		//lvCountries.getSelectionModel().selectedItemProperty().addListener(e -> updateText());
		//this way is more robust, not bugging, the method above tends to select nulls, no idea why
		lvCountries.setOnKeyReleased(e -> updateText());
		lvCountries.setOnMouseClicked(e -> updateText());
		//top Box
		ComboBox<SelectionMode> cbbSelectionMode = new ComboBox<>();
		cbbSelectionMode.setItems(FXCollections.observableArrayList(SelectionMode.values()));
		cbbSelectionMode.setValue(SelectionMode.SINGLE);
		cbbSelectionMode.setOnAction(e -> 
			lvCountries.getSelectionModel().setSelectionMode(cbbSelectionMode.getValue()));
		
		Label lblSelectionMode = new Label("Choose selection mode", cbbSelectionMode);
		lblSelectionMode.setContentDisplay(ContentDisplay.RIGHT);
		
		//mid box
		ScrollPane midPane = new ScrollPane(lvCountries);
		
		BorderPane pane = new BorderPane();
		pane.setTop(lblSelectionMode);
		pane.setCenter(midPane);
		pane.setBottom(txtSelected);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_16");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private static void updateText() {
		txtSelected.setText("");
		int size = lvCountries.getSelectionModel().getSelectedItems().size();
		
		if (size < 1) {
			txtSelected.setText("No selected items");
			return;
		}
		else if (size == 1) {
			txtSelected.setText("Selected item is " + 
					lvCountries.getSelectionModel().getSelectedItems().get(0));
			return;
		}
		
		txtSelected.setText("Selected items are ");
		for(String s : lvCountries.getSelectionModel().getSelectedItems()) {
			txtSelected.setText(txtSelected.getText() + s + " ");
		}
	}
}
