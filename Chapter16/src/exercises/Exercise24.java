package exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise24 extends Application {

	//not for the jar executable
	//jar cfe app.jar exercises.Exercise24 exercises/Exercise24.class
	//runs this main which invokes the application start
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//works at 10-2-2018
	private static final String MEDIA_URL = 
			"http://cs.armstrong.edu/liang/common/sample.mp4";

	public void start(Stage primaryStage) {
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);

		Button btnPlay = new Button(">");
		btnPlay.setOnAction(e -> {
			if (btnPlay.getText().equals(">")) {
				mediaPlayer.play();
				btnPlay.setText("||");
			} 
			else {
				mediaPlayer.pause();
				btnPlay.setText(">");
			}	
		});

		Button btnRewind = new Button("<<");
		btnRewind.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

		
		//time slider and time label with animations
		Label lblTotalTime = new Label();
		lblTotalTime.setFont(Font.font(20));
		lblTotalTime.setText("00:00:00/00:05:03");

		Slider slTime = new Slider();
		slTime.setMax((Duration.minutes(5).add(Duration.seconds(3))).toMillis());
		slTime.setMin(0);	
		
		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
			updateLabel(lblTotalTime, mediaPlayer.getCurrentTime());
			slTime.adjustValue(mediaPlayer.getCurrentTime().toMillis());
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		slTime.setOnMousePressed(e -> {
			animation.pause();
		});
		
		slTime.setOnMouseDragged(e -> updateLabel(lblTotalTime, Duration.millis(slTime.getValue())));
		
		slTime.setOnMouseReleased(e -> {
			mediaPlayer.setStartTime(Duration.millis(slTime.getValue()));
			updateLabel(lblTotalTime, Duration.millis(slTime.getValue()));
			if (mediaPlayer.getStatus() == Status.PLAYING) {
				mediaPlayer.seek(Duration.millis(slTime.getValue()));
			}
			animation.play();
		});
		
		slTime.setValue(0);
		slTime.setPrefWidth(150);
		slTime.setMaxWidth(Region.USE_PREF_SIZE);
		slTime.setMinWidth(30);
		//volume slider
	
		Slider slVolume = new Slider();
		slVolume.setPrefWidth(150);
		slVolume.setMaxWidth(Region.USE_PREF_SIZE);
		slVolume.setMinWidth(30);
		slVolume.setValue(50);
		mediaPlayer.volumeProperty().bind(
				slVolume.valueProperty().divide(100));

		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(30));
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btnPlay, btnRewind, new Label("Time"), slTime, lblTotalTime,
				new Label("Volume"), slVolume);

		BorderPane pane = new BorderPane();
		pane.setCenter(mediaView);
		pane.setBottom(hBox);

		Scene scene = new Scene(pane, 750, 600);
		primaryStage.setTitle("Exercise16_24");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void updateLabel(Label lbl, Duration time) {
		int hour = (int) time.toHours() % 24;
		int min = (int) time.toMinutes() % 60;
		int sec = (int) time.toSeconds() % 60;
		
		if (hour < 10)
			lbl.setText("0" + hour);
		else 
			lbl.setText(hour + "");
		
		if (min < 10)
			lbl.setText(lbl.getText() + ":0" + min);
		else
			lbl.setText(lbl.getText() + ":" + min);
		
		if (sec < 10)
			lbl.setText(lbl.getText() + ":0" + sec);
		else
			lbl.setText(lbl.getText() + ":" + sec);
		
		
		lbl.setText(lbl.getText() + "/00:05:03");
	}
}
