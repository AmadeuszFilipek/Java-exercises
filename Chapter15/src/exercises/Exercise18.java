package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise18 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		Rectangle recMain = new Rectangle(200, 100);
		recMain.setFill(Color.BLUEVIOLET);
		recMain.setOpacity(0.5);
		
		recMain.setOnMouseDragged(e -> {
			recMain.setX(e.getX() - recMain.getWidth() / 2.);
			recMain.setY(e.getY() - recMain.getHeight() / 2.);		
		});
		
		pane.getChildren().add(recMain);
		
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Exercise15_18");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
