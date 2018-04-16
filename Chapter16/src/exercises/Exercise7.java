package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise7 extends Application {

	public void start(Stage primaryStage) {
		
		ClockPane clockPane = new ClockPane();

		TextField hour = new TextField(clockPane.getHour() + "");
		TextField minute = new TextField(clockPane.getMinute() + "");
		TextField second = new TextField(clockPane.getSecond() + "");
		
		hour.setPrefColumnCount(10);
		minute.setPrefColumnCount(10);
		second.setPrefColumnCount(10);
		
		hour.setOnAction(e -> {
			try{
				clockPane.setHour(Integer.parseInt(hour.getText()));
			} catch(NumberFormatException ex) {}
			});
		
		minute.setOnAction(e -> {
			try{
				clockPane.setMinute(Integer.parseInt(minute.getText()));
			} catch(NumberFormatException ex) {}
			});
		
		second.setOnAction(e -> {
			try{
				clockPane.setSecond(Integer.parseInt(second.getText()));
			} catch(NumberFormatException ex) {}
			});
		
		
		Label lblHour = new Label("Hour", hour);
		Label lblMinute = new Label("Minute", minute);
		Label lblSecond = new Label("Second", second);
		
		lblHour.setContentDisplay(ContentDisplay.RIGHT);
		lblMinute.setContentDisplay(ContentDisplay.RIGHT);
		lblSecond.setContentDisplay(ContentDisplay.RIGHT);
		
		clockPane.setW(600);
		clockPane.setH(350);
		StackPane topPane = new StackPane(clockPane);
		
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		botBox.getChildren().addAll(lblHour, lblMinute, lblSecond);

		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(10));
		mainPane.setCenter(topPane);
		mainPane.setBottom(botBox);
				
		Scene scene = new Scene(mainPane, 600, 400);
		primaryStage.setTitle("Exercise16_07");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
