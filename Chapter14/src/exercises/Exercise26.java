package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import listingsAndDemos.ClockPane;

public class Exercise26 extends Application {

	public void start(Stage primaryStage) {
		
		HBox pane = new HBox(20);
		pane.setPadding(new Insets(20));
		
		ClockPane clk1 = new ClockPane(4, 20, 45);
		ClockPane clk2 = new ClockPane(22, 46, 15);
		
		pane.getChildren().addAll(clk1, clk2);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_26");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
