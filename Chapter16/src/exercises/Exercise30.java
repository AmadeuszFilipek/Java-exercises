package exercises;

import java.util.Random;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise30 extends Application {

	private Label lblMessage = new Label();
	private GridPane grid = new GridPane();
	private MyTextField[][] matrix = new MyTextField[7][6];
	
	public void start(Stage primaryStage) {
		
		Random rng = new Random();
		lblMessage.setFont(Font.font(20));
		grid.setVgap(5);
		grid.setHgap(5);
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6; j++) {
				matrix[i][j] = new MyTextField(rng.nextInt(10) + "");
				matrix[i][j].setFont(Font.font(18));
				matrix[i][j].setPrefColumnCount(1);
				matrix[i][j].setAlignment(Pos.CENTER);
				
				grid.add(matrix[i][j], j, i);
			}
		}
		
		Button btnSolve = new Button("Solve");
		btnSolve.setOnAction(e -> {
			if (isConsecutiveFour(matrix))
				lblMessage.setText("A consecutive four found");
			else
				lblMessage.setText("No consecutive four found");
		});
		
		HBox topBox = new HBox();
		topBox.setAlignment(Pos.CENTER);
		topBox.getChildren().add(lblMessage);
		
		HBox botBox = new HBox();
		botBox.setPadding(new Insets(20));
		botBox.setAlignment(Pos.CENTER);
		botBox.getChildren().add(btnSolve);
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(30));
		pane.setTop(topBox);
		pane.setCenter(grid);
		pane.setBottom(botBox);
		
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise16_29");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}

	public class MyTextField extends TextField {
		
		public MyTextField(String text) {
			super(text);
		}
		
		@Override
		public boolean equals(Object val) {
			if (val instanceof TextField) {
				
				if (getText().equals(((TextField) val).getText()))
						return true;
				
				return false;
			}
			
			return false;
		}
	}
	
	public boolean isConsecutiveFour(TextField[][] values) {
		for(int i = 0; i < values.length; i++)
			for(int j = 0; j < values[i].length; j++)
				values[i][j].setStyle("");
		
		// check vertically
		for(int i = 0; i < values.length; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if(values[i][j].equals(values[i][j + 1]) &&
					 values[i][j + 1].equals(values[i][j + 2]) &&
					 values[i][j + 2].equals(values[i][j + 3])) {
					values[i][j].setStyle("-fx-border-color: black");
					values[i][j + 1].setStyle("-fx-border-color: black");
					values[i][j + 2].setStyle("-fx-border-color: black");
					values[i][j + 3].setStyle("-fx-border-color: black");
								
					return true;
				}
		
		// check horizontally
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length; j++)
				if (values[i][j].equals(values[i + 1][j]) &&
				    values[i + 1][j].equals(values[i + 2][j]) &&
				    values[i + 2][j].equals(values[i + 3][j])) {
					values[i][j].setStyle("-fx-border-color: black");
					values[i + 1][j].setStyle("-fx-border-color: black");
					values[i + 2][j].setStyle("-fx-border-color: black");
					values[i + 3][j].setStyle("-fx-border-color: black");
					
					return true;	
				}
		
		//check diagonally down-stream orientation
		for(int i = 0; i < values.length - 3; i++)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j].equals(values[i + 1][j + 1]) &&
				    values[i + 1][j + 1].equals(values[i + 2][j + 2]) &&
				    values[i + 2][j + 2].equals(values[i + 3][j + 3])) {
					values[i][j].setStyle("-fx-border-color: black");
					values[i + 1][j + 1].setStyle("-fx-border-color: black");
					values[i + 2][j + 2].setStyle("-fx-border-color: black");
					values[i + 3][j + 3].setStyle("-fx-border-color: black");
					
					return true;
				}
		
		//check diagonally up-stream orientation
		for(int i = values.length - 1; i >= 3; i--)
			for(int j = 0; j < values[i].length - 3; j++)
				if (values[i][j].equals(values[i - 1][j + 1]) &&
						values[i - 1][j + 1].equals(values[i - 2][j + 2]) &&
						values[i - 2][j + 2].equals(values[i - 3][j + 3])) {
					values[i][j].setStyle("-fx-border-color: black");
					values[i - 1][j + 1].setStyle("-fx-border-color: black");
					values[i - 2][j + 2].setStyle("-fx-border-color: black");
					values[i - 3][j + 3].setStyle("-fx-border-color: black");
					
					return true;
				}
		
		return false;				
	}
}
