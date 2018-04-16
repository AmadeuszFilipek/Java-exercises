package exercises;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/** I messed that up a little, it works as intended, but i should define circles as 
 *  global access objects, not CircleInfoPanes, that would enable me to easy access 
 *  and handle the events and actions on the circles
 * 
 * @author Amadeusz
 *
 */
public class Exercise8 extends Application {

	private Label lblIntersect = new Label("Two circles intersect? No");
	private CircleInfoPane infoPaneFirst = new CircleInfoPane(1, 50, 60, 30);
	private CircleInfoPane infoPaneSecond = new CircleInfoPane(2, 180, 56, 40);
	
	public void start(Stage primaryStage) {

		//top main pane
		HBox topBox = new HBox();
		topBox.setAlignment(Pos.CENTER);
		topBox.getChildren().add(lblIntersect);

		//middle main Pane
		TwoCirclePane middlePane = new TwoCirclePane();
		
		//bottom main pane with redraw button
		HBox botBox = new HBox();
		botBox.setAlignment(Pos.CENTER);
		Button btnRedraw = new Button("Redraw Circles");
		botBox.getChildren().add(btnRedraw);
		
		btnRedraw.setOnAction(e -> {
			infoPaneFirst.redrawCircle();
			infoPaneSecond.redrawCircle();
		});
		
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(10));
		mainPane.setTop(topBox);
		mainPane.setCenter(middlePane);
		mainPane.setBottom(botBox);

		Scene scene = new Scene(mainPane, 500, 400);
		primaryStage.setTitle("Exercise16_08");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	/** Merging class that contains pane with two circles and a two info panes*/
	public class TwoCirclePane extends BorderPane {

		public TwoCirclePane() {

			// top pane with two circles
			Pane circlePane = new Pane();
			circlePane.getChildren().addAll(infoPaneFirst.crc, infoPaneSecond.crc);
			
			//add listeners to the circles 
			addListeners();
			
			//middle pane with two CircleInfoPanes in a HBox
			HBox infoBox = new HBox(10);
			infoBox.setAlignment(Pos.CENTER);
			infoBox.getChildren().addAll(infoPaneFirst, infoPaneSecond);
					
			this.setCenter(circlePane);	
			this.setBottom(infoBox);
		}
		
		public void addListeners() {	
			
			ChangeListener<Number> listener = (e, i, j) -> {
				if (intersect())
					lblIntersect.setText("Two circles intersect? Yes");
				else
					lblIntersect.setText("Two circles intersect? No");
			};
			
			infoPaneFirst.crc.centerXProperty().addListener(listener);
			infoPaneFirst.crc.centerYProperty().addListener(listener);
			infoPaneSecond.crc.centerXProperty().addListener(listener);
			infoPaneSecond.crc.centerYProperty().addListener(listener);
		}
		
		public boolean intersect() {
			double distance = Math.sqrt(Math.pow(
					infoPaneFirst.crc.getCenterX() - infoPaneSecond.crc.getCenterX(), 2) + Math.pow(
					infoPaneFirst.crc.getCenterY() - infoPaneSecond.crc.getCenterY(), 2));
			if (distance > infoPaneFirst.crc.getRadius() + infoPaneSecond.crc.getRadius())
				return false;
			else 
				return true;
		}
	}

	/**Class containing a single info panel */
	public class CircleInfoPane extends BorderPane {

		public Circle crc;

		private Label lblInfo;

		private Label lblCenterX = new Label("Center x:");
		private Label lblCenterY = new Label("Center y:");
		private Label lblRadius = new Label("Radius:");

		private TextField tfCenterX = new TextField();
		private TextField tfCenterY = new TextField();
		private TextField tfRadius = new TextField();

		CircleInfoPane(int number, double x, double y, double radius) {
			
			crc = new Circle(x, y, radius);
			crc.setFill(Color.WHITE);
			crc.setStroke(Color.BLACK);
			
			crc.setOnMouseDragged(e -> {
				crc.setCenterX(e.getX());
				crc.setCenterY(e.getY());
				updateInfo();
			});
			
			updateInfo();

			lblInfo = new Label("Enter circle " + number + " info:");

			tfCenterX.setPrefColumnCount(8);
			tfCenterY.setPrefColumnCount(8);
			tfRadius.setPrefColumnCount(8);

			tfCenterX.setAlignment(Pos.BASELINE_RIGHT);
			tfCenterY.setAlignment(Pos.BASELINE_RIGHT);
			tfRadius.setAlignment(Pos.BASELINE_RIGHT);

			lblInfo.setAlignment(Pos.CENTER);

			GridPane centerPane = new GridPane();
			centerPane.setHgap(5);
			centerPane.setVgap(5);

			centerPane.add(lblCenterX, 0, 0);
			centerPane.add(tfCenterX, 1, 0);
			centerPane.add(lblCenterY, 0, 1);
			centerPane.add(tfCenterY, 1, 1);
			centerPane.add(lblRadius, 0, 2);
			centerPane.add(tfRadius, 1, 2);

			this.setTop(lblInfo);
			this.setCenter(centerPane);
			this.setStyle("-fx-border-color: black");
			this.setPadding(new Insets(10));
		}

		private void updateInfo() {
			tfCenterX.setText(crc.getCenterX() + "");
			tfCenterY.setText(crc.getCenterY() + "");
			tfRadius.setText(crc.getRadius() + "");
		}

		public void redrawCircle() {
			try {
				crc.setCenterX(getCenterX());
				crc.setCenterY(getCenterY());
				crc.setRadius(getRadius());
			} catch (NumberFormatException ex) { }
		}

		public double getCenterX() throws NumberFormatException {
			return Double.parseDouble(tfCenterX.getText());
		}

		public double getCenterY() throws NumberFormatException {
			return Double.parseDouble(tfCenterY.getText());
		}

		public double getRadius() throws NumberFormatException {
			return Double.parseDouble(tfRadius.getText());
		}
	}
}
