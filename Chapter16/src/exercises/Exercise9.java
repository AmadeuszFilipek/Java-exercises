package exercises;

import javafx.application.Application;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise9 extends Application {

	private static Rectangle recFirst = new Rectangle(79, 20, 40, 50);
	private static Rectangle recSecond = new Rectangle(110, 33, 50, 20);
	private static Label lblIntersect = new Label("Two rectangles intersect? Yes");

	public void start(Stage primaryStage) {

		HBox intersectPane = new HBox(lblIntersect);
		intersectPane.setAlignment(Pos.CENTER);

		Pane recPane = new Pane();
		recPane.getChildren().addAll(recFirst, recSecond);

		RectangleInfoPane infoPane1 = new RectangleInfoPane(1);
		infoPane1.updateInfo(recFirst);
		RectangleInfoPane infoPane2 = new RectangleInfoPane(2);
		infoPane2.updateInfo(recSecond);
		HBox infoPane = new HBox(infoPane1, infoPane2);
		infoPane.setAlignment(Pos.CENTER);

		//define the rectangle activities
		setRectangle(recFirst, infoPane1);	
		setRectangle(recSecond, infoPane2);

		HBox btnPane = new HBox();
		btnPane.setAlignment(Pos.CENTER);
		btnPane.setPadding(new Insets(5));
		Button btnRedraw = new Button("Redraw Rectangles");
		btnRedraw.setOnAction(e -> {
			redraw(recFirst, infoPane1);
			redraw(recSecond, infoPane2);
		});

		btnPane.getChildren().addAll(btnRedraw);

		//final construction of the GUI panes
		BorderPane subMainPane = new BorderPane();
		subMainPane.setCenter(recPane);
		subMainPane.setBottom(infoPane);

		BorderPane mainPane = new BorderPane();
		mainPane.setTop(intersectPane);
		mainPane.setCenter(subMainPane);
		mainPane.setBottom(btnPane);

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise16_09");
		primaryStage.show();

	}

	private static boolean intersect() {
		return recFirst.intersects(recSecond.getBoundsInLocal());
	}

	private static void setRectangle(Rectangle rec, RectangleInfoPane pane) {

		rec.setFill(Color.WHITE);
		rec.setStroke(Color.BLACK);

		rec.setOnMouseDragged(e -> {
			rec.setX(e.getX());
			rec.setY(e.getY());
			pane.updateInfo(rec);
			if (intersect())
				lblIntersect.setText("Two rectangles intersect? Yes");
			else
				lblIntersect.setText("Two rectangles intersect? No");
		});
	}

	private static void redraw(Rectangle rec, RectangleInfoPane pane) {
		try {
			rec.setX(pane.getCenterX());
			rec.setY(pane.getCenterY());
			rec.setWidth(pane.getRecWidth());
			rec.setHeight(pane.getRecHeight());
		} catch (NumberFormatException ex) {}
	}

	public class RectangleInfoPane extends BorderPane {

		private Label lblInfo;

		private Label lblCenterX = new Label("Center x:");
		private Label lblCenterY = new Label("Center y:");
		private Label lblWidth = new Label("Width:");
		private Label lblHeight = new Label("Height:");

		private TextField tfCenterX = new TextField();
		private TextField tfCenterY = new TextField();
		private TextField tfWidth = new TextField();
		private TextField tfHeight = new TextField();

		public RectangleInfoPane(int number) {

			lblInfo = new Label("Enter Rectangle " + number + " info:");

			tfCenterX.setPrefColumnCount(8);
			tfCenterY.setPrefColumnCount(8);
			tfWidth.setPrefColumnCount(8);
			tfHeight.setPrefColumnCount(8);

			tfCenterX.setAlignment(Pos.BASELINE_RIGHT);
			tfCenterY.setAlignment(Pos.BASELINE_RIGHT);
			tfWidth.setAlignment(Pos.BASELINE_RIGHT);
			tfHeight.setAlignment(Pos.BASELINE_RIGHT);		

			HBox topBox = new HBox();
			topBox.setAlignment(Pos.CENTER);
			topBox.getChildren().add(lblInfo);

			GridPane botPane = new GridPane();
			botPane.setHgap(10);
			botPane.setVgap(10);

			botPane.add(lblCenterX, 0, 0);
			botPane.add(tfCenterX, 1, 0);
			botPane.add(lblCenterY, 0, 1);
			botPane.add(tfCenterY, 1, 1);
			botPane.add(lblWidth, 0, 2);
			botPane.add(tfWidth, 1, 2);
			botPane.add(lblHeight, 0, 3);
			botPane.add(tfHeight, 1, 3);

			this.setTop(topBox);
			this.setBottom(botPane);
			this.setPadding(new Insets(10));
			this.setStyle("-fx-border-color: black");

		}

		public void updateInfo(Rectangle rec) {
			tfCenterX.setText(rec.getX() + "");
			tfCenterY.setText(rec.getY() + "");
			tfWidth.setText(rec.getWidth() + "");
			tfHeight.setText(rec.getHeight() + "");
		}

		public double getCenterX() throws NumberFormatException {
			return Double.parseDouble(tfCenterX.getText());
		}

		public double getCenterY() throws NumberFormatException {
			return Double.parseDouble(tfCenterY.getText());
		}

		public double getRecWidth() throws NumberFormatException {
			return Double.parseDouble(tfWidth.getText());
		}

		public double getRecHeight() throws NumberFormatException {
			return Double.parseDouble(tfHeight.getText());
		}
	}
}
