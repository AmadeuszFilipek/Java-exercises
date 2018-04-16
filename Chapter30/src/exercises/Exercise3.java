package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise3 extends Application {

	ImageView imageView = new ImageView("flag.png");

	public void start(Stage primaryStage) {

		Pane pane = new Pane();

		pane.getChildren().add(imageView);

		//use a thread instead of path transition
		//		PathTransition pt = new PathTransition(Duration.millis(10000), 
		//				new Line(100, 200, 100, 0), imageView);
		//		pt.setCycleCount(5);
		//		pt.play();

		Scene scene = new Scene(pane);
		primaryStage.setTitle("FlagRisingAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();

		Thread animation = new Thread(new RisingFlag(5));
		animation.setDaemon(true);
		animation.start();
	}

	// could also define a line to follow it through
	public class RisingFlag implements Runnable {

		private int cycleCount = 1;

		public RisingFlag() {}

		public RisingFlag(int cycleCount) {
			this.cycleCount = cycleCount;
		}

		public void run() {
			try {
				for (int c = 0; c < cycleCount; c++) {
					imageView.setX(0);
					imageView.setY(200);
					for (int i = 1; i <= 200; i++) {
						imageView.setY(imageView.getY() - 1);
						Thread.sleep(50);
					}
				}
			} catch (InterruptedException ex) { }
		}
	}
}
