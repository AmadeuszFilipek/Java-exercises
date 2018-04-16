package exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise2 extends Application {

	public void start(Stage primaryStage) {

		//top pane with a figure
		StackPane topPane = new StackPane();
		topPane.setStyle("-fx-border-color: black");

		//bottom pane with controls
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);

		CheckBox cbFill = new CheckBox("Fill");

		cbFill.setOnAction(e -> {
			for(Node node : topPane.getChildren()) {
				if (node instanceof Shape) {
					if (cbFill.isSelected()) {
						((Shape)node).setFill(Color.BLACK);
					}
					else {
						((Shape)node).setFill(null);
						((Shape)node).setStroke(Color.BLACK);
					}
				}
			}
		});

		ToggleGroup tg = new ToggleGroup();
		RadioButton btnCircle = new RadioButton("Circle");
		RadioButton btnRectangle = new RadioButton("Rectangle");
		RadioButton btnEllipse = new RadioButton("Ellipse");

		btnCircle.setToggleGroup(tg);
		btnRectangle.setToggleGroup(tg);
		btnEllipse.setToggleGroup(tg);

		btnCircle.setOnAction(e -> {
			Circle tmp = new Circle(50);
			if (!cbFill.isSelected()) {
				tmp.setFill(null);
				tmp.setStroke(Color.BLACK);
			}
			topPane.getChildren().clear();
			topPane.getChildren().add(tmp);
		});

		btnRectangle.setOnAction(e -> {
			Rectangle tmp = new Rectangle(100, 50);
			if (!cbFill.isSelected()) {
				tmp.setFill(null);
				tmp.setStroke(Color.BLACK);
			}
			topPane.getChildren().clear();
			topPane.getChildren().add(tmp);
		});

		btnEllipse.setOnAction(e -> {
			Ellipse tmp = new Ellipse(100, 50);
			if (!cbFill.isSelected()) {
				tmp.setFill(null);
				tmp.setStroke(Color.BLACK);
			}
			topPane.getChildren().clear();
			topPane.getChildren().add(tmp);
		});

		botBox.getChildren().addAll(btnCircle, btnRectangle, btnEllipse, cbFill);

		//main panel
		BorderPane mainPane = new BorderPane();
		mainPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		mainPane.setCenter(topPane);
		mainPane.setBottom(botBox);

		Scene scene = new Scene(mainPane, 300, 200);
		primaryStage.setTitle("Exercise16_02");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
