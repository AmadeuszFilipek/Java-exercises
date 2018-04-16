package exercises;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise23 extends Application {

	TextField tfAnimationSpeed = new TextField();
	TextField tfImagePrefix = new TextField();
	TextField tfImagesNumber = new TextField();
	TextField tfURI = new TextField();

	private ImageView image = new ImageView();
	private int imageNumber = 1;
	private int slides;
	Timeline animation;

	double numberOfImages;

	public void start(Stage primaryStage) {

		//bot panel
		tfAnimationSpeed.setPrefColumnCount(30);
		tfURI.setPrefColumnCount(30);
		tfImagePrefix.setPrefColumnCount(30);
		tfImagesNumber.setPrefColumnCount(30);

		Label lblInformation = new Label("Enter information for animation");
		Label lblAnimationSpeed = new Label("Animation speed in milliseconds");
		Label lblImagePrefix = new Label("Image file prefix");
		Label lblImagesNumber = new Label("Number of images");
		Label lblURI = new Label("Audio file URL");

		GridPane botPane = new GridPane();
		botPane.setAlignment(Pos.CENTER);
		botPane.setHgap(20);
		botPane.add(lblInformation, 0, 0);
		botPane.add(lblAnimationSpeed, 0, 1); botPane.add(tfAnimationSpeed, 1, 1);
		botPane.add(lblImagePrefix, 0, 2); botPane.add(tfImagePrefix, 1, 2);
		botPane.add(lblImagesNumber, 0, 3); botPane.add(tfImagesNumber, 1, 3);
		botPane.add(lblURI, 0, 4); botPane.add(tfURI, 1, 4);

		HBox topBox = new HBox();
		topBox.setAlignment(Pos.TOP_RIGHT);

		Button btnStartAnimation = new Button("Start Animation");
		btnStartAnimation.setOnAction(e -> startAnimation());
		topBox.getChildren().add(btnStartAnimation);

		BorderPane pane = new BorderPane();
		pane.setTop(topBox);
		pane.setCenter(image);
		pane.setBottom(botPane);

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Exercise23");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void startAnimation() {
		imageNumber = 1;
		
		try {
			int milis = Integer.parseInt(tfAnimationSpeed.getText());
			slides = Integer.parseInt(tfImagesNumber.getText());

			animation = new Timeline(new KeyFrame(Duration.millis(milis), e -> nextImage()));
			animation.setCycleCount(slides);
			animation.play();

			File file = new File(tfURI.getText());
			if (file.isFile()) {
				MediaPlayer player = new MediaPlayer(new Media(file.toURI().toString()));
				player.setStopTime(Duration.millis(milis * slides));
				player.play();
			} 
			else
				tfURI.setText("invalid file");

		} catch(NumberFormatException ex) {

		} 		
	}

	private void nextImage() {
		try {
			image.setImage(new Image(tfImagePrefix.getText() + imageNumber  + ".PNG"));
			imageNumber++;

		} catch(IllegalArgumentException ex) {
			tfImagePrefix.setText("invalid file prefix: no such files");
			animation.stop();
		}
	}
}
