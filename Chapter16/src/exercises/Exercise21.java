package exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise21 extends Application {

	private TextField tfTime = new TextField();
	private Timeline animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e -> incrementTime()));
	private Text remaining = new Text();
	private Label lblTime = new Label("Insert time in seconds", tfTime);
	
	private int sec;
	
	public void start(Stage primaryStage) {
	
		animation.setOnFinished(e -> finish());
		tfTime.setOnAction(e -> startCounting());
		
		lblTime.setFont(Font.font(30));
		lblTime.setGraphicTextGap(20);
		lblTime.setContentDisplay(ContentDisplay.RIGHT);
		tfTime.setPrefColumnCount(5);
		
		remaining.setVisible(false);
		remaining.setFont(Font.font(40));
		
		StackPane pane = new StackPane();
		pane.getChildren().addAll(lblTime, remaining);
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Exercise16_21");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void startCounting() {
		try {
			sec = Integer.parseInt(tfTime.getText());
			lblTime.setVisible(false);
			remaining.setVisible(true);
			remaining.setText(sec + "");
			animation.setCycleCount(sec);
			animation.play();
		} catch(NumberFormatException e) {
			tfTime.setText(e.getMessage());
		}
	}
	
	private void incrementTime() {
		sec -= 1;
		remaining.setText(sec + "");
	}
	
	private void finish() {
		//NOTE ! URI not URL, and it needs a protocol before the :/PATH so the protocol is file like http:
		MediaPlayer music = new MediaPlayer(new Media("file:RunWild.mp3"));
		music.setCycleCount(MediaPlayer.INDEFINITE);
		music.play();
	}
}
