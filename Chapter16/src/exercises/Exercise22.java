package exercises;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise22 extends Application {
	
	private File file = new File("RunWild.mp3");
	private MediaPlayer music = new MediaPlayer(new Media(
			 file.toURI().toString()));

	public void start(Stage primaryStage) {

		music.setStartTime(Duration.seconds(0));
		music.setStopTime(Duration.seconds(5));
		
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(20));

		Button btnPlay = new Button("Play");
		Button btnLoop = new Button("Loop");
		Button btnStop = new Button("Stop");

		btnPlay.setOnAction(e -> music.play());
		btnLoop.setOnAction(e -> music.setCycleCount(MediaPlayer.INDEFINITE));
		btnStop.setOnAction(e -> music.stop());

		hBox.getChildren().addAll(btnPlay, btnLoop, btnStop);

		Scene scene = new Scene(hBox);
		primaryStage.setTitle("Exercise16_22");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
