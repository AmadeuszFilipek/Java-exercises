package exercises;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise30 extends Application {

	public void start (Stage primaryStage) {
		
		ImagePane pane = new ImagePane(10);
		
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
		primaryStage.setTitle("Exercise15_30");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static class ImagePane extends Pane {
		
		private ImageView image;
		private int imageNumber;
		private int slides;
		
		public ImagePane(int slides) {
			
			this.slides = slides;
			image = new ImageView("slide1.PNG");
			image.setPreserveRatio(false);
			image.resize(800, 600);
			getChildren().add(image);
			
		}
		
		public void nextImage() {
			if (imageNumber + 1 >= slides)
				imageNumber = 0;
			
			imageNumber++;
			image.setImage(new Image("slide" + imageNumber + ".PNG"));
		}		
	}
}
