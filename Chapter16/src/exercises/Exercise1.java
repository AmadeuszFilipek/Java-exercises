package exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise1 extends Application {
	
	public void start(Stage primaryStage) {
		
		//middle panel
		Pane midPane = new Pane();
		midPane.setStyle("-fx-border-color: black");
		
		Text txt = new Text(50, 50, "Programming is fun");
		txt.setFont(Font.font(25));
		midPane.getChildren().add(txt);
		
		//upper toggle bar
		HBox topBox = new HBox(10);
		topBox.setAlignment(Pos.CENTER);
		
		//create radio buttons
		ToggleGroup tg = new ToggleGroup();
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		
		//add the radio buttons to toggle group
		rbRed.setToggleGroup(tg);
		rbYellow.setToggleGroup(tg);
		rbBlack.setToggleGroup(tg);
		rbOrange.setToggleGroup(tg);
		rbGreen.setToggleGroup(tg);
		
		//define the action for the buttons
		rbRed.setOnAction(e -> txt.setFill(Color.RED));
		rbYellow.setOnAction(e -> txt.setFill(Color.YELLOW));
		rbBlack.setOnAction(e -> txt.setFill(Color.BLACK));
		rbOrange.setOnAction(e -> txt.setFill(Color.ORANGE));
		rbGreen.setOnAction(e -> txt.setFill(Color.GREEN));	
		
		topBox.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		
		//bottom panel
		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		
		Button btnLeft = new Button("<=");
		Button btnRight = new Button("=>");
		
		btnLeft.setOnAction(e -> txt.setX(txt.getX() - 5));
		btnRight.setOnAction(e -> txt.setX(txt.getX() + 5));
		
		botBox.getChildren().addAll(btnLeft, btnRight);
		
		//combine the panels
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(topBox);
		mainPane.setCenter(midPane);
		mainPane.setBottom(botBox);
		mainPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		Scene scene = new Scene(mainPane, 500, 400);
		primaryStage.setTitle("Exercise16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
