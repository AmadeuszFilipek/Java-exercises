package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise31 extends Application {

	public static final int EMPTY = 0;
	public static final int RED = 1;
	public static final int BLUE = 2;

	public static final int RUNNING = 5;
	public static final int FINISHED = 6;
	public static final int DRAW = 7;

	public void start(Stage primaryStage) {

		Scene scene = new Scene(new GamePane());
		primaryStage.setTitle("Exercise16_31");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public class GamePane extends BorderPane {

		private GridPane grid = new GridPane();
		private Cell[][] cells = new Cell[6][7];

		private Label lblStatus = new Label("Red player turn");
		private int currentPlayer = RED;
		private int gameStatus = RUNNING;

		public GamePane() {

			for(int i = 0; i < 6; i++)
				for(int j = 0; j < 7; j++) {
					Cell cell = new Cell(i, j);
					cells[i][j] = cell;
					cell.setOnMouseClicked(e -> validateClick(cell.getRow(), cell.getColumn()));

					grid.add(cells[i][j], j, i);
				}

			lblStatus.setFont(Font.font(20));

			HBox botBox = new HBox();
			botBox.setAlignment(Pos.CENTER);
			botBox.setPadding(new Insets(10));
			botBox.getChildren().add(lblStatus);

			setCenter(grid);
			setBottom(botBox);

		}

		private void validateClick(int i, int j) {
			//check whether the clicked cell is valid as a next move
			if (cells[i][j].getStatus() != EMPTY)
				return;

			for(int row = i + 1; row < 6; row++){
				if(cells[row][j].getStatus() == EMPTY)
					return;
			}

			cells[i][j].setStatus(currentPlayer);
			nextTurn();
		}

		private void nextTurn() {

			//check if all the places are taken
			gameStatus = FINISHED;
			for(int i = 0; i < cells.length; i++)
				for(int j = 0; j < cells[i].length; j++) {
					if (cells[i][j].getStatus() == EMPTY)
						gameStatus = RUNNING;
				}

			//check if finished
			if (isConsecutiveFour(cells)) {
				
				if (currentPlayer == RED)
					lblStatus.setText("Red player has won!");
				else if (currentPlayer == BLUE)
					lblStatus.setText("Blue player has won!");
				
				gameStatus = FINISHED;
				return;
			}
			else if (gameStatus == FINISHED) {
				gameStatus = DRAW;
				lblStatus.setText("The game has ended. It's a draw");
				return;
			}

			if(currentPlayer == RED) {
				currentPlayer = BLUE;
				lblStatus.setText("Blue player turn");
			}
			else {
				currentPlayer = RED;
				lblStatus.setText("Red player turn");
			}
		}

		public boolean isConsecutiveFour(Cell[][] values) {

			// check vertically
			for(int i = 0; i < values.length; i++)
				for(int j = 0; j < values[i].length - 3; j++)
					if(values[i][j].equals(values[i][j + 1]) &&
							values[i][j + 1].equals(values[i][j + 2]) &&
							values[i][j + 2].equals(values[i][j + 3])) {
						values[i][j].markWin();
						values[i][j + 1].markWin();
						values[i][j + 2].markWin();
						values[i][j + 3].markWin();

						return true;
					}

			// check horizontally
			for(int i = 0; i < values.length - 3; i++)
				for(int j = 0; j < values[i].length; j++)
					if (values[i][j].equals(values[i + 1][j]) &&
							values[i + 1][j].equals(values[i + 2][j]) &&
							values[i + 2][j].equals(values[i + 3][j])) {
						values[i][j].markWin();
						values[i + 1][j].markWin();
						values[i + 2][j].markWin();
						values[i + 3][j].markWin();

						return true;	
					}

			//check diagonally down-stream orientation
			for(int i = 0; i < values.length - 3; i++)
				for(int j = 0; j < values[i].length - 3; j++)
					if (values[i][j].equals(values[i + 1][j + 1]) &&
							values[i + 1][j + 1].equals(values[i + 2][j + 2]) &&
							values[i + 2][j + 2].equals(values[i + 3][j + 3])) {
						values[i][j].markWin();
						values[i + 1][j + 1].markWin();
						values[i + 2][j + 2].markWin();
						values[i + 3][j + 3].markWin();

						return true;
					}

			//check diagonally up-stream orientation
			for(int i = values.length - 1; i >= 3; i--)
				for(int j = 0; j < values[i].length - 3; j++)
					if (values[i][j].equals(values[i - 1][j + 1]) &&
							values[i - 1][j + 1].equals(values[i - 2][j + 2]) &&
							values[i - 2][j + 2].equals(values[i - 3][j + 3])) {
						values[i][j].markWin();
						values[i - 1][j + 1].markWin();
						values[i - 2][j + 2].markWin();
						values[i - 3][j + 3].markWin();

						return true;
					}

			return false;				
		}
	}

	public class Cell extends StackPane {

		private Circle circle = new Circle();

		int status = EMPTY;
		int row;
		int column;

		public Cell(int row, int column) {
			this.row = row;
			this.column = column;

			circle.setRadius(40);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);

			setPadding(new Insets(10));
			setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
			getChildren().add(circle);
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}	

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;

			switch (this.status) {
			case EMPTY : circle.setFill(Color.WHITE); break;
			case RED : circle.setFill(Color.RED); break;
			case BLUE : circle.setFill(Color.BLUE); break;
			default : break;
			}
		}

		public Circle getCircle() {
			return circle;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Cell) {
				if (((Cell)obj).getStatus() == status && status != EMPTY)
					return true;
			}

			return false;
		}

		public void markWin() {
			if (status == BLUE)
				circle.setFill(Color.AZURE);
			else if (status == RED)
				circle.setFill(Color.FIREBRICK);
		}
	}
}
