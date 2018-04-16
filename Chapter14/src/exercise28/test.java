package exercise28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

	public void start(Stage primaryStage) {

		ClockPane clk = new ClockPane();
		clk.setMinuteHandVisible(false);
		
		Scene scene = new Scene(clk);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
