package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import demos.DescriptionPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise27 extends Application {


	private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", 
			"India", "Norway", "United Kingdom", "United States of America"};

	private ImageView[] flagImage = { 
			new ImageView("image/canada.png"),
			new ImageView("image/china.png"),
			new ImageView("image/denmark.png"),
			new ImageView("image/france.png"),
			new ImageView("image/germany.png"),
			new ImageView("image/india.png"),
			new ImageView("image/norway.png"),
			new ImageView("image/uk.png"),
			new ImageView("image/usa.png"),
	};

	private String[] flagDescription = new String[9];

	private DescriptionPane descriptionPane = new DescriptionPane();

	private ComboBox<String> cbo = new ComboBox<>();

	public void start(Stage primaryStage) {

		flagDescription[0] = "Description for Canada...";
		flagDescription[1] = "Description for China...";
		flagDescription[2] = "Description for Denmark...";
		flagDescription[3] = "Description for France...";
		flagDescription[4] = "Description for Germany...";
		flagDescription[5] = "Description for India...";
		flagDescription[6] = "Description for Norway...";
		flagDescription[7] = "Description for UK...";
		flagDescription[8] = "Description for USA...";

		for(int i = 0; i < flagDescription.length; i++) {
			File file = new File("description" + (i + 1) + ".txt");
			try (Scanner input = new Scanner(file)) {
				flagDescription[i] = "";
				while(input.hasNextLine())
					flagDescription[i] += input.nextLine();
				
			} catch(FileNotFoundException ex) {}
		}
		
		setDisplay(0);

		BorderPane pane = new BorderPane();

		BorderPane paneForComboBox = new BorderPane();
		paneForComboBox.setLeft(new Label("Select a country: "));
		paneForComboBox.setCenter(cbo);
		pane.setTop(paneForComboBox);

		cbo.setPrefWidth(400);
		cbo.setValue("Canada");
		ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
		cbo.getItems().addAll(items);
		pane.setCenter(descriptionPane);

		cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("ComboBoxDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setDisplay(int index) {
		descriptionPane.setTitle(flagTitles[index]);
		descriptionPane.setImageView(flagImage[index]);
		descriptionPane.setDescription(flagDescription[index]);
	}
}