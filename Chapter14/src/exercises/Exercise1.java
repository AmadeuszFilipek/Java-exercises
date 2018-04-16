package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5));
		pane.setHgap(5);
		pane.setVgap(5);

		try {
	
			pane.add(new ImageView("images/canada.jpg"), 0, 0);
		  pane.add(new ImageView("images/japan.jpg"), 0, 1);
			pane.add(new ImageView("images/usa.jpg"), 1, 0);
			pane.add(new ImageView("images/uk.jpg"), 1, 1);

			Scene scene = new Scene(pane);
			primaryStage.setTitle("Exercise14_01");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Could not find the images");
			System.exit(1);
		}
	}
}








