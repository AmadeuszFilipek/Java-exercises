package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise28 extends Application {

public void start (Stage primaryStage) {
		
		TextPane pane = new TextPane(9);
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(2000), e -> {pane.nextImage();}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		pane.setOnMouseClicked(e -> {
			if (animation.getStatus() == Status.RUNNING)
				animation.pause();
			else
				animation.play();
		});

		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_28");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static class TextPane extends Pane {
		
		private  TextArea text = new TextArea();
		private int imageNumber;
		private int slides;
		
		public TextPane(int slides) {
			
			text.setEditable(false);
			this.slides = slides;
			fillText("description1.txt");
			
			getChildren().add(text);
			
		}
		
		public void nextImage() {
			if (imageNumber + 1 >= slides)
				imageNumber = 0;
			
			imageNumber++;
			fillText("description" + imageNumber + ".txt");
		}
		
		private void fillText(String adress) {
			File file = new File(adress);
			try (Scanner input = new Scanner(file)) {
				text.clear();
				while(input.hasNextLine()) {
					text.setText(text.getText() + input.nextLine() + "\n");
				}
				
			} catch(FileNotFoundException	ex) {
				text.setText(ex.getMessage());
			}
		}
	}
}
