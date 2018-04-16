package exercises;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise19 extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 500, 400);
		
		Label lblResult = new Label();
		lblResult.setVisible(false);
		lblResult.setFont(Font.font(30));
		lblResult.layoutXProperty().bind(pane.widthProperty().multiply(0.1));
		lblResult.layoutYProperty().bind(pane.heightProperty().divide(2));
		
		Circle crcMain = new Circle(10);
		randomizeCircle(crcMain, pane);
		
		pane.getChildren().addAll(lblResult, crcMain);
		pane.setBackground(new Background(new BackgroundFill(Color.BISQUE, new CornerRadii(50), null)));
		GameStatus status = new GameStatus(10);
		
		crcMain.setOnMouseClicked(e -> {
			if (!status.started) {
				//start the "game"
				status.setStarted(true);
				status.setMilis(System.currentTimeMillis());
				status.setCount(status.getCount() + 1);
				randomizeCircle(crcMain, pane);
			} 
			else {
				status.setCount(status.getCount() + 1);
				if (status.count < status.getCountsToFinishTheGame()) {
					//game is running
					randomizeCircle(crcMain, pane);	
				}
				else {
					//game is finished
					crcMain.setVisible(false);
					status.setMilis(System.currentTimeMillis() - status.getMilis());
					lblResult.setText("Time spent is : " + status.getMilis() + " miliseconds.");
					lblResult.setVisible(true);
				}
			}	
		});
		
		primaryStage.setTitle("Exercise15_19");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void randomizeCircle(Circle c, Pane pane) {
		Random rng = new Random();
		c.setFill(Color.rgb(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
		c.setCenterX(rng.nextDouble() * (pane.getHeight() - 2 * c.getRadius()) + c.getRadius());
		c.setCenterY(rng.nextDouble() * (pane.getHeight() - 2 * c.getRadius()) + c.getRadius());
	}
	
	public static class GameStatus {
		private long milis;
		private int count;
		private boolean started;
		private int countsToFinishTheGame;
		
		public GameStatus() {}

		public GameStatus(int c) {
			countsToFinishTheGame = c; 
		}
		
	public long getMilis() {
		return milis;
	}

	public void setMilis(long milis) {
		this.milis = milis;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public int getCountsToFinishTheGame() {
		return countsToFinishTheGame;
	}

	public void setCountsToFinishTheGame(int countsToFinishTheGame) {
		this.countsToFinishTheGame = countsToFinishTheGame;
	}
		
	}
}
