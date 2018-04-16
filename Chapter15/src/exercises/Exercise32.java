package exercises;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise32 extends Application {

	public void start(Stage primaryStage) {

		ClockPane clock = new ClockPane();
		
		Button btnStop = new Button("Stop");
		Button btnStart = new Button("Start");
		
		btnStop.setOnAction(e -> {clock.stop();});
		btnStart.setOnAction(e -> {clock.start();});
		
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(20));
		hBox.getChildren().addAll(btnStart, btnStop);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		BorderPane pane = new BorderPane(clock);
		pane.setBottom(hBox);
		BorderPane.setAlignment(clock, Pos.CENTER);
		
		Scene scene = new Scene(pane, 250, 300);
		primaryStage.setTitle("Exercise15_32");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static class ClockPane extends Pane {


		private Timeline animation;
		private int hour;
		private int minute;
		private int second;
		// clock pane's width and height
		private double w = 250, h = 250;

		public ClockPane() {
			this.setCurrentTime();

			animation = new Timeline(new KeyFrame(Duration.millis(100), e -> {
				this.setCurrentTime();
			}));
			animation.setCycleCount(Timeline.INDEFINITE);
		}

		public ClockPane(int hour, int minute, int second) {
			this();

			this.hour = hour;
			this.minute = minute;
			this.second = second;
			this.paintClock();
		}
		public int getHour() {
			return hour;
		}	
		public void setHour(int hour) {
			this.hour = hour;
			this.paintClock();
		}	
		public int getMinute() {
			return minute;
		}	
		public void setMinute(int minute) {
			this.minute = minute;
			this.paintClock();
		}
		public int getSecond() {
			return second;
		}
		public void setSecond(int second) {
			this.second = second;
			this.paintClock();
		}
		public double getW() {
			return w;
		}
		public void setW(double w) {
			this.w = w;
			this.paintClock();
		}
		public double getH() {
			return h;
		}
		public void setH(double h) {
			this.h = h;
			this.paintClock();
		}
		public void setCurrentTime() {
			Calendar calendar = new GregorianCalendar();

			this.hour = calendar.get(Calendar.HOUR_OF_DAY);
			this.minute = calendar.get(Calendar.MINUTE);
			this.second = calendar.get(Calendar.SECOND);

			this.paintClock();
		}
		protected void paintClock() {
			double clockRadius = Math.min(w,  h) * 0.8 * 0.5;
			double centerX = w / 2;
			double centerY = h / 2;

			Circle circle = new Circle(centerX, centerY, clockRadius);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
			Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
			Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
			Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

			//second "hand"
			double sLength = clockRadius * 0.8;
			double secondX = centerX + sLength * 
					Math.sin(second * (2 * Math.PI / 60));
			double secondY = centerY - sLength *
					Math.cos(second *(2 * Math.PI / 60));
			Line sLine = new Line(centerX, centerY, secondX, secondY);
			sLine.setStroke(Color.RED);

			//minute hand
			double mLength = clockRadius * 0.65;
			double minuteX = centerX + mLength *
					Math.sin(minute * (2 * Math.PI / 60));
			double minuteY = centerY - mLength *
					Math.cos(minute * (2 * Math.PI / 60));
			Line mLine = new Line(centerX, centerY, minuteX, minuteY);
			mLine.setStroke(Color.BLUE);

			//hour hand
			double hLength = clockRadius * 0.5;
			double hourX = centerX + hLength *
					Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
			double hourY = centerY - hLength * 
					Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
			Line hLine = new Line(centerX, centerY, hourX, hourY);
			hLine.setStroke(Color.GREEN);

			this.getChildren().clear();
			this.getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);

		}

		public void start() {
			animation.play();
		}

		public void stop() {
			animation.pause();
		}
	}
}