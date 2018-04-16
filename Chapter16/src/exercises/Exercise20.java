package exercises;

import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise20 extends Application {

	public void start(Stage primaryStage) {
		
		CounterPane timerPane = new CounterPane();
		
		Button btnStart = new Button("Start");
		Button btnClear = new Button("Clear");
		
		btnStart.setOnAction(e -> {
			if (timerPane.isRunning()) {
				timerPane.pause();
				btnStart.setText("Start");
			}
			else {
				timerPane.start();
				btnStart.setText("Stop");
			}		
		});
		
		btnClear.setOnAction(e -> {
			timerPane.clear();
			btnStart.setText("Start");
		});
		
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		botBox.getChildren().addAll(btnStart, btnClear);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(timerPane);
		pane.setBottom(botBox);
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Exercise16_20");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public class CounterPane extends StackPane {
		
		private Text txtTime = new Text();
		private GregorianCalendar time = new GregorianCalendar();
		private Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(1000), e -> increment()));
		
		private boolean isRunning = false;
		
		public CounterPane() {

			time.setTimeInMillis(0);
			
			animation.setAutoReverse(false);
			animation.setCycleCount(Timeline.INDEFINITE);
			
			txtTime.setFont(Font.font(30));
			getChildren().add(txtTime);
			updateTimer();
		}
		
		private void increment() {
			time.add(GregorianCalendar.SECOND, 1);
			updateTimer();
		}
		
		public void clear() {
			isRunning = false;
			animation.stop();
			time.setTimeInMillis(0);
			updateTimer();
		}
		
		public void start() {
			isRunning = true;
			animation.play();
		}
		
		public void pause() {
			isRunning = false;
			animation.pause();
		}
		
		private void updateTimer() {
			int h = time.get(GregorianCalendar.HOUR) - 1;
			
			if (h < 10)
				txtTime.setText("0" + h);
			else
				txtTime.setText(h + "");
			
			int min = time.get(GregorianCalendar.MINUTE);
			
			if (min < 10) 
				txtTime.setText(txtTime.getText() + ":0" + min);
			else
				txtTime.setText(txtTime.getText() + ":" + min);
			
			int sec = time.get(GregorianCalendar.SECOND);
			
			if (sec < 10) 
				txtTime.setText(txtTime.getText() + ":0" + sec);
			else
				txtTime.setText(txtTime.getText() + ":" + sec);
		}
		
		public boolean isRunning() {
			return isRunning;
		}
	}
}
