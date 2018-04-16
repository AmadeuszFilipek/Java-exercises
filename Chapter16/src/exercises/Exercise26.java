package exercises;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise26 extends Application {
	
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		ImageView imageView = new ImageView("flag.png");
		pane.getChildren().add(imageView);
		
		PathTransition pt = new PathTransition(Duration.millis(10000), 
				new Line(100, 200, 100, 0), imageView);
		pt.setCycleCount(5);
		pt.play();
		
		MediaPlayer anthem = new MediaPlayer(new Media(
				"http://cs.armstrong.edu/liang/common" + "/audio/anthem/anthem" + 6 + ".mp3"));
		anthem.play();
		
		
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Exercise16_26");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
