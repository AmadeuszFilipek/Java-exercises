package exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise2 extends Application {

	public void start(Stage primaryStage) {
		
		VBox vBox = new VBox(100);
		vBox.setAlignment(Pos.CENTER);
		
	  Rectangle rec = new Rectangle(200, 100);
		rec.setFill(Color.WHITE);
		rec.setStroke(Color.BLACK);
		
		Button btnRotate = new Button("Rotate");
		btnRotate.setOnAction(e -> {rec.setRotate(rec.getRotate() + 15);});
		btnRotate.setAlignment(Pos.BOTTOM_CENTER);
		
		vBox.getChildren().addAll(rec, btnRotate);
		
		Scene scene = new Scene(vBox, 400, 400);
		primaryStage.setTitle("Exercise15_02");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
