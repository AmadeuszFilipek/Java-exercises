package exercises;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise6 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(30));
		
		Text lblText = new Text("Java is fun");
		lblText.xProperty().set(0);
		lblText.yProperty().bind(pane.heightProperty().divide(2));
		String[] displays = {"Java is fun", "Java is powerful"};
		List<Integer> i = new ArrayList<>();
		
		pane.setOnMouseClicked(e -> {		
			i.add(1); // could lead to memory problems
			lblText.setText(displays[i.size() % 2]);
		});
		
		pane.getChildren().add(lblText);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_06");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
